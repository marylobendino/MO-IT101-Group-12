/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorphemployeeportal;

/**
 *
 * @author marylobendino
 */

public class PagibigDeduction extends Deduction {
    @Override
    public double calculateDeduction(double grossMonthlySalary) {
        double pagibigDeduction = 0;
        
        if (grossMonthlySalary >= 1000 && grossMonthlySalary <= 1500) {
            pagibigDeduction = grossMonthlySalary * 0.01;  // Employee's contribution rate of 1%
        } else if (grossMonthlySalary > 1500) {
            pagibigDeduction = grossMonthlySalary * 0.02;  // Employee's contribution rate of 2%
        }

        // Apply the maximum contribution cap of 100
        if (pagibigDeduction > 100) {
            pagibigDeduction = 100;
        }
        
        return pagibigDeduction;
    }
}
