/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.motorphemployeeportal;

/**
 *
 * @author marylobendino
 */

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;  // Import added here
import java.util.ArrayList;
import java.util.List;

public class HoursWorkedPerWeek {

    public static long calculateHoursWorked(List<Attendance> attendanceList, int employeeNumber, LocalDate startDate, LocalDate endDate) {
        // Check that the date range is exactly 7 days (inclusive)
        if (ChronoUnit.DAYS.between(startDate, endDate) != 6) {
            System.out.println("Error: Invalid date range. Please enter a duration of exactly one week.");
            return 0;  // Or return any appropriate value to indicate an error
        }

        // Filter attendance entries for the chosen employee within the week range
        List<Attendance> filteredAttendanceList = filterAttendance(attendanceList, employeeNumber, startDate, endDate);

        // Calculate total work hours for the employee within the chosen week
        long totalMinutesWorked = 0;
        for (Attendance attendance : filteredAttendanceList) {
            Duration duration = calculateHours(attendance.getTimeIn(), attendance.getTimeOut());
            totalMinutesWorked += duration.toMinutes();  // Accumulate total minutes worked
        }

        // Convert total minutes to hours (with fraction)
        return totalMinutesWorked / 60;
    }

    // Helper method to filter attendance entries
    private static List<Attendance> filterAttendance(List<Attendance> attendanceList, int employeeNumber, LocalDate startDate, LocalDate endDate) {
        List<Attendance> filteredList = new ArrayList<>();
        for (Attendance attendance : attendanceList) {
            LocalDate attendanceDate = attendance.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (attendance.getEmployeeNumber() == employeeNumber &&
                (attendanceDate.isEqual(startDate) || attendanceDate.isAfter(startDate)) &&
                (attendanceDate.isEqual(endDate) || attendanceDate.isBefore(endDate))) {
                filteredList.add(attendance);
            }
        }
        return filteredList;
    }

    private static Duration calculateHours(LocalTime timeIn, LocalTime timeOut) {
        if (timeIn == null || timeOut == null) {
            return Duration.ZERO; // Handle missing time data
        }

        // Calculate the duration between timeIn and timeOut
        return Duration.between(timeIn, timeOut);
    }
}
