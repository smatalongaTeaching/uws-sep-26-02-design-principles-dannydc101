package com.uws.excercise1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeePayrollTest {

    @Test
    void testCalculateMonthlySalary_ReturnsCorrectAmount() {
        Employee emp = new Employee(1, "Jane Smith", "Developer", 48000.00);
        EmployeePayroll payroll = new EmployeePayroll(emp);
        // 48000 / 12 = 4000.00
        assertEquals(4000.00, payroll.calculateMonthlySalary(), 0.001);
    }

    @Test
    void testCalculateAnnualTax_Returns20Percent() {
        Employee emp = new Employee(1, "Jane Smith", "Developer", 48000.00);
        EmployeePayroll payroll = new EmployeePayroll(emp);
        // 48000 * 0.20 = 9600.00
        assertEquals(9600.00, payroll.calculateAnnualTax(), 0.001);
    }

    @Test
    void testCalculateMonthlyNetSalary_ReturnsCorrectAmount() {
        Employee emp = new Employee(1, "Jane Smith", "Developer", 48000.00);
        EmployeePayroll payroll = new EmployeePayroll(emp);
        // (48000 - 9600) / 12 = 3200.00
        assertEquals(3200.00, payroll.calculateMonthlyNetSalary(), 0.001);
    }

    @Test
    void testCalculateMonthlySalary_ZeroSalary_ReturnsZero() {
        Employee emp = new Employee(1, "Jane Smith", "Developer", 0.00);
        EmployeePayroll payroll = new EmployeePayroll(emp);
        assertEquals(0.00, payroll.calculateMonthlySalary(), 0.001);
    }

    @Test
    void testCalculateAnnualTax_ZeroSalary_ReturnsZero() {
        Employee emp = new Employee(1, "Jane Smith", "Developer", 0.00);
        EmployeePayroll payroll = new EmployeePayroll(emp);
        assertEquals(0.00, payroll.calculateAnnualTax(), 0.001);
    }
}
