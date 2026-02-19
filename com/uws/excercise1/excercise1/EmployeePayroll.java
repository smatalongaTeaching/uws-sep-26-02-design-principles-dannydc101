package com.uws.excercise1;

public class EmployeePayroll {
    private final Employee employee;
    //payroll calculation for selected employee
    public EmployeePayroll(Employee employee) {
        this.employee = employee;
    }
    public double calculateMonthlySalary() {
        return employee.getSalary() / 12;
    }// calculate gross salary
    public double calculateAnnualTax() {
        return employee.getSalary() * 0.20;
    }//calculate annual tax for employee
    public double calculateMonthlyNetSalary() {
        double annualNet = employee.getSalary() - calculateAnnualTax();
        return annualNet / 12;
    }// calculate net salary for employee
    public void printPayrollSummary() {
        System.out.println("=== Payroll Summary for " + employee.getName() + " ===");
        System.out.printf("Annual Salary:       £%,.2f%n", employee.getSalary());
        System.out.printf("Annual Tax (20%%):    £%,.2f%n", calculateAnnualTax());
        System.out.printf("Monthly Gross:       £%,.2f%n", calculateMonthlySalary());
        System.out.printf("Monthly Net:         £%,.2f%n", calculateMonthlyNetSalary());
    }// output payroll summary
}
