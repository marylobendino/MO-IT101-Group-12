/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorphemployeeportal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author marylobendino
 */
public class Attendance {

    private int employeeNumber;
    private String lastName;
    private String firstName;
    private Date date;
    private LocalTime timeIn;
    private LocalTime timeOut;

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber (int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    public LocalTime getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }

        public Attendance(int employeeNumber, String lastName, String firstName, Date date, LocalTime timeIn, LocalTime timeOut) {
            this.employeeNumber = employeeNumber;
            this.lastName = lastName;
            this.firstName = firstName;
            this.date = date;
            this.timeIn = timeIn;
            this.timeOut = timeOut;
        }
}