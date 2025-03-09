/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorphemployeeportal;

/**
 *
 * @author marylobendino
 */

public class SSSDeduction extends Deduction {
    @Override
    public double calculateDeduction(double grossMonthlySalary) {
        double sssDeduction = 0;
        
        if (grossMonthlySalary < 3250) {
            sssDeduction = 135;
        } 
        else if (grossMonthlySalary >= 3250 && grossMonthlySalary <= 3750){
            sssDeduction = 157.5;
        }        
        else if (grossMonthlySalary > 3750 && grossMonthlySalary <= 4250){
            sssDeduction = 180;
        }
        else if (grossMonthlySalary > 4250 && grossMonthlySalary <= 4750){
            sssDeduction = 202.5;
        }        
        else if (grossMonthlySalary > 4750 && grossMonthlySalary <= 5250){
            sssDeduction = 225;
        }
        else if (grossMonthlySalary > 5250 && grossMonthlySalary <= 5750){
            sssDeduction = 247.5;
        }        
        else if (grossMonthlySalary > 5750 && grossMonthlySalary <= 6250){
            sssDeduction = 270;
        }        
        else if (grossMonthlySalary > 6250 && grossMonthlySalary <= 6750){
            sssDeduction = 292.5;
        }        
        else if (grossMonthlySalary > 6750 && grossMonthlySalary <= 7250){
            sssDeduction = 315;
        }
        else if (grossMonthlySalary > 7250 && grossMonthlySalary <= 7750){
            sssDeduction = 337.5;
        }        
        else if (grossMonthlySalary > 7750 && grossMonthlySalary <= 8250){
            sssDeduction = 360;
        }
        else if (grossMonthlySalary > 8250 && grossMonthlySalary <= 8750){
            sssDeduction = 382.5;
        }
        else if (grossMonthlySalary > 8750 && grossMonthlySalary <= 9250){
            sssDeduction = 405;
        }
        else if (grossMonthlySalary > 9250 && grossMonthlySalary <= 9750){
            sssDeduction = 427.5;
        }
        else if (grossMonthlySalary > 9750 && grossMonthlySalary <= 10250){
            sssDeduction = 450;
        }
        else if (grossMonthlySalary > 10250 && grossMonthlySalary <= 10750){
            sssDeduction = 472.5;
        }
        else if (grossMonthlySalary > 10750 && grossMonthlySalary <= 11250){
            sssDeduction = 495;
        }
        else if (grossMonthlySalary > 11250 && grossMonthlySalary <= 11750){
            sssDeduction = 517.5;
        }
        else if (grossMonthlySalary > 11750 && grossMonthlySalary <= 12250){
            sssDeduction = 540;
        }
        else if (grossMonthlySalary > 12250 && grossMonthlySalary <= 12750){
            sssDeduction = 562.5;
        }
        else if (grossMonthlySalary > 12750 && grossMonthlySalary <= 13250){
            sssDeduction = 585;
        }
        else if (grossMonthlySalary > 13250 && grossMonthlySalary <= 13750){
            sssDeduction = 607.5;
        }
        else if (grossMonthlySalary > 13750 && grossMonthlySalary <= 14250){
            sssDeduction = 630;
        }
        else if (grossMonthlySalary > 14250 && grossMonthlySalary <= 14750){
            sssDeduction = 652.5;
        }
        else if (grossMonthlySalary > 14750 && grossMonthlySalary <= 15250){
            sssDeduction = 675;
        }
        else if (grossMonthlySalary > 15250 && grossMonthlySalary <= 15750){
            sssDeduction = 697.5;
        }
        else if (grossMonthlySalary > 15750 && grossMonthlySalary <= 16250){
            sssDeduction = 720;
        }
        else if (grossMonthlySalary > 16250 && grossMonthlySalary <= 16750){
            sssDeduction = 742.5;
        }
        else if (grossMonthlySalary > 16750 && grossMonthlySalary <= 17250){
            sssDeduction = 765;
        }
        else if (grossMonthlySalary > 17250 && grossMonthlySalary <= 17750){
            sssDeduction = 787.5;
        }
        else if (grossMonthlySalary > 17750 && grossMonthlySalary <= 18250){
            sssDeduction = 810;
        }
        else if (grossMonthlySalary > 18250 && grossMonthlySalary <= 18750){
            sssDeduction = 832.5;
        }
        else if (grossMonthlySalary > 18750 && grossMonthlySalary <= 19250){
            sssDeduction = 855;
        }
        else if (grossMonthlySalary > 19250 && grossMonthlySalary <= 19750){
            sssDeduction = 877.5;
        }
        else if (grossMonthlySalary > 19750 && grossMonthlySalary <= 20250){
            sssDeduction = 900;
        }
        else if (grossMonthlySalary > 20250 && grossMonthlySalary <= 20750){
            sssDeduction = 922.5;
        }
        else if (grossMonthlySalary > 20750 && grossMonthlySalary <= 21250){
            sssDeduction = 945;
        }
        else if (grossMonthlySalary > 21250 && grossMonthlySalary <= 21750){
            sssDeduction = 967.5;
        }
        else if (grossMonthlySalary > 21750 && grossMonthlySalary <= 22250){
            sssDeduction = 990;
        }
        else if (grossMonthlySalary > 22250 && grossMonthlySalary <= 22750){
            sssDeduction = 1012.5;
        }
        else if (grossMonthlySalary > 22750 && grossMonthlySalary <= 23250){
            sssDeduction = 1035;
        }
        else if (grossMonthlySalary > 23250 && grossMonthlySalary <= 23750){
            sssDeduction = 1057.5;
        }
        else if (grossMonthlySalary > 23750 && grossMonthlySalary <= 24250){
            sssDeduction = 1080;
        }
        else if (grossMonthlySalary > 24250 && grossMonthlySalary <= 24750){
            sssDeduction = 1102.5;
        }
        else {
            sssDeduction = 1125;  // Any salary over 24750 has a fixed deduction of 1125
        }

        return sssDeduction;
    }
}

