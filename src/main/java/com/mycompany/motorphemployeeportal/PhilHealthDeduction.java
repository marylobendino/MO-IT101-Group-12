/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorphemployeeportal;

/**
 *
 * @author marylobendino
 */
public class PhilHealthDeduction extends Deduction {
      @Override
    public double calculateDeduction(double grossMonthlySalary) {
        double philHealthDeduction = 0;
        
        if (grossMonthlySalary <= 10000) {
            philHealthDeduction = 300/2;
        }
        else if (grossMonthlySalary > 10000 && grossMonthlySalary < 60000) {
            philHealthDeduction = grossMonthlySalary * .03 / 2;
        }
        else if (grossMonthlySalary >= 60000) {
            philHealthDeduction = 1800/2;
        }
        return philHealthDeduction;
    }
}
