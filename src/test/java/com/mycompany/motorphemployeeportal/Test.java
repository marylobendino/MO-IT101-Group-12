/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.motorphemployeeportal;

/**
 *
 * @author marylobendino
 */
public class Test {

    public static void main(String[] args) {
        // Test for calculateGrossSalary
        Employee employee = new Employee(
            1, "Dela Cruz", "Juan", "01/01/1990", "123 Street", "09123456789",
            "00-0000000-0", "000000000000", "000-000-000-000", "00000000000",
            "Regular", "CEO", "N/A", 90000.00, 1500.00, 2000.00, 1000.00, 45000.00, 535.71
        );

        double totalHoursWorked = 160;
        double expectedGrossSalary = 85713.6; //Correct expected value for the test

        // Test calculateGrossSalary
        double actualGrossSalary = MotorPHEmployeePortal.calculateGrossSalary(employee, (long) totalHoursWorked);

        System.out.printf("Expected Gross Salary: %.2f\n", expectedGrossSalary);
        System.out.printf("Actual Gross Salary: %.2f\n", actualGrossSalary);

        if (Math.abs(expectedGrossSalary - actualGrossSalary) < 0.01) {
            System.out.println("Test Passed: calculateGrossSalary");
        } else {
            System.out.println("Test Failed: calculateGrossSalary");
            System.out.println("Expected: " + expectedGrossSalary + ", but got: " + actualGrossSalary);
        }

        // Test for calculateWithholdingTax
        double taxableIncome = 30000.0;
        double expectedTax = 1833.4; // Correct expected value for the test

        double actualTax = MotorPHEmployeePortal.calculateWithholdingTax(taxableIncome);

        System.out.printf("\nExpected Tax: %.2f\n", expectedTax);
        System.out.printf("Actual Tax: %.2f\n", actualTax);

        if (Math.abs(expectedTax - actualTax) < 0.01) {
            System.out.println("Test Passed: calculateWithholdingTax");
        } else {
            System.out.println("Test Failed: calculateWithholdingTax");
            System.out.println("Expected: " + expectedTax + ", but got: " + actualTax);
        }
    }
}
