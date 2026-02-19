package com.uws.excercise1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

public class EmployeeRepositoryTest {

    private EmployeeRepository repository;
    private static final String TEST_XML = "TestEmployees.xml";

    @BeforeEach
    void setUp() {
        repository = new EmployeeRepository(TEST_XML);
    }

    @AfterEach
    void tearDown() {
        // Remove the test XML file after each test to keep things clean
        new File(TEST_XML).delete();
    }

    @Test
    void testSave_CreatesXmlFile() {
        Employee emp = new Employee(1, "Jane Smith", "Developer", 48000.00);
        repository.save(emp);
        assertTrue(new File(TEST_XML).exists());
    }

    @Test
    void testFindById_ReturnsCorrectEmployee() {
        Employee emp = new Employee(1, "Jane Smith", "Developer", 48000.00);
        repository.save(emp);

        Employee loaded = repository.findById(1);
        assertNotNull(loaded);
        assertEquals(1, loaded.getId());
        assertEquals("Jane Smith", loaded.getName());
    }

    @Test
    void testFindById_ReturnsNullForNonExistentId() {
        Employee result = repository.findById(999);
        assertNull(result);
    }

    @Test
    void testSave_MultipleThenFindById_ReturnsCorrectOne() {
        repository.save(new Employee(1, "Jane Smith", "Developer", 48000.00));
        repository.save(new Employee(2, "John Doe",   "Designer",  42000.00));

        Employee loaded = repository.findById(2);
        assertNotNull(loaded);
        assertEquals("John Doe", loaded.getName());
    }

    @Test
    void testFindById_LoadsCorrectSalary() {
        Employee emp = new Employee(1, "Jane Smith", "Developer", 48000.00);
        repository.save(emp);

        Employee loaded = repository.findById(1);
        assertNotNull(loaded);
        assertEquals(48000.00, loaded.getSalary(), 0.001);
    }
}
