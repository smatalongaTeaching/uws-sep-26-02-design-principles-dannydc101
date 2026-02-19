package com.uws.excercise1;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
public class EmployeeRepository {
    private static final String XML_FILE_PATH = "Employees.xml";
    //save employee to xml

    public void save(Employee employee) {
        try {
            File xmlFile = new File(XML_FILE_PATH);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc;
            Element rootElement;

            if (xmlFile.exists() && xmlFile.length() > 0) {
                doc = dBuilder.parse(xmlFile);
                rootElement = doc.getDocumentElement();
            } else {
                doc = dBuilder.newDocument();
                rootElement = doc.createElement("employees");
                doc.appendChild(rootElement);
            }

            Element employeeElem = doc.createElement("employee");

            Element idElem = doc.createElement("id");
            idElem.appendChild(doc.createTextNode(String.valueOf(employee.getId())));
            employeeElem.appendChild(idElem);

            Element nameElem = doc.createElement("name");
            nameElem.appendChild(doc.createTextNode(employee.getName()));
            employeeElem.appendChild(nameElem);

            Element positionElem = doc.createElement("position");
            positionElem.appendChild(doc.createTextNode(employee.getPosition()));
            employeeElem.appendChild(positionElem);

            Element salaryElem = doc.createElement("salary");
            salaryElem.appendChild(doc.createTextNode(String.format("%.2f", employee.getSalary())));
            employeeElem.appendChild(salaryElem);

            rootElement.appendChild(employeeElem);

            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result = new javax.xml.transform.stream.StreamResult(xmlFile);
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

            System.out.println("Saved employee to Employees.xml: " + employee.getName());

        } catch (Exception e) {
            System.out.println("Error saving to Employees.xml: " + e.getMessage());
        }
    }
    public Employee findById(int id) {
        try {
            File xmlFile = new File(XML_FILE_PATH);
            if (!xmlFile.exists()) {
                System.out.println("Employees.xml file not found at: " + xmlFile.getAbsolutePath());
                return null;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            javax.xml.xpath.XPathFactory xPathFactory = javax.xml.xpath.XPathFactory.newInstance();
            javax.xml.xpath.XPath xpath = xPathFactory.newXPath();
            String expression = String.format("/employees/employee[id=%d]", id);
            Node employeeNode = (Node) xpath.evaluate(expression, doc, javax.xml.xpath.XPathConstants.NODE);

            if (employeeNode != null && employeeNode.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) employeeNode;
                int empId       = Integer.parseInt(elem.getElementsByTagName("id").item(0).getTextContent());
                String empName  = elem.getElementsByTagName("name").item(0).getTextContent();
                String empPos   = elem.getElementsByTagName("position").item(0).getTextContent();
                double empSal   = Double.parseDouble(elem.getElementsByTagName("salary").item(0).getTextContent());
                return new Employee(empId, empName, empPos, empSal);
            } else {
                System.out.println("Employee with ID " + id + " not found in Employees.xml.");
                return null;
            }

        } catch (Exception e) {
            System.out.println("Error loading from Employees.xml: " + e.getMessage());
            return null;
        }
    }

}
