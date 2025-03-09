/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.motorphemployeeportal;

/**
 *
 * @author marylobendino
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.time.ZoneId;

public class MotorPHEmployeePortal {

    // Formatter for parsing dates in the format MM/DD/YYYY
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    // List to store deductions (static to be accessible across methods)
    private static List<Deduction> deductions = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to get user input

    // Initialize the static deductions list with specific deduction types
    deductions.add(new SSSDeduction());
    deductions.add(new PhilHealthDeduction());
    deductions.add(new PagibigDeduction());
    
    // Initialize employeeNumber and employee objects
        int employeeNumber;
        Employee employee = null;
        
    // Load attendance data from a Attendance.txt file and store in a list
        List<Attendance> attendanceList = readAttendanceData("C:\\Users\\vncbv\\Desktop\\MotorPHApp\\Attendance.txt");

    // Loop to ask for employee number until a valid employee is found
        while (employee == null) {
            System.out.print("\nPlease enter your Employee Number: ");
            employeeNumber = Integer.parseInt(scanner.nextLine());
            try {
    // Fetch employee data based on the input employee number
                employee = getEmployeeData(employeeNumber);
                if (employee == null) {
                    System.out.println("Employee not found. Please try again.");
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: Employee Not Found");
            }
        }

    // Main menu loop to display options to the employee
        while (true) {
            showMainMenu(employee);
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
    // Display employee information                
                    displayEmployeeInformation(employee);
                    break;
                case 2:
    // Display hours worked per week within a date range                
            System.out.println("\nNOTE: Please enter date ranges from Monday to Sunday");
            LocalDate startDate = promptForDate(scanner, "Enter Start Date (MM/DD/YYYY): ");
            LocalDate endDate = promptForDate(scanner, "Enter End Date (MM/DD/YYYY): ");
    // If attendance data is available, display it
            if (attendanceList == null || attendanceList.isEmpty()) {
            System.out.println("Sorry, no data available.");
            } else {
    // Print header for attendance details
        System.out.println("----------------------------------------");
        System.out.println("|     DATE     |  TIME IN  |  TIME OUT |");
        System.out.println("----------------------------------------");

    // Loop through attendance records and print relevant details
            for (Attendance attendance : attendanceList) {
            if (attendance.getEmployeeNumber() == employee.getEmployeeNumber() &&
                !attendance.getDate().toInstant().isBefore(startDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()) &&
                !attendance.getDate().toInstant().isAfter(endDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())) {

                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String formattedDate = dateFormat.format(attendance.getDate());

                System.out.printf("|  %s  |   %s   |   %s   |\n", 
                                  formattedDate, 
                                  attendance.getTimeIn().toString(), 
                                  attendance.getTimeOut().toString());
            }
        }
    // Print total hours worked during the date range
            System.out.println("----------------------------------------");
            long totalHoursWorked = HoursWorkedPerWeek.calculateHoursWorked(attendanceList, employee.getEmployeeNumber(), startDate, endDate);
            System.out.println("Total Hours Worked: " + totalHoursWorked);
        }
    break;
    
    // Calculate and display the employee's gross weekly salary
                case 3:
                    System.out.println("\nNOTE: Please enter date ranges from Monday to Sunday");
                    startDate = promptForDate(scanner, "Enter Start Date (MM/DD/YYYY): ");
                    endDate = promptForDate(scanner, "Enter End Date (MM/DD/YYYY): ");
                    long totalHoursWorked = HoursWorkedPerWeek.calculateHoursWorked(attendanceList, employee.getEmployeeNumber(), startDate, endDate);
                    double grossSalary = calculateGrossSalary(employee, totalHoursWorked);
                    System.out.println("Gross Weekly Salary: PHP " + String.format("%.2f",grossSalary));
                    break;
                    
    // Calculate and display the employee's net weekly salary
                    case 4:
                    System.out.println("\nNOTE: Please enter date ranges from Monday to Sunday");
                    startDate = promptForDate(scanner, "Enter Start Date (MM/DD/YYYY): ");
                    endDate = promptForDate(scanner, "Enter End Date (MM/DD/YYYY): ");
                    System.out.println("=====================================================");
                    totalHoursWorked = HoursWorkedPerWeek.calculateHoursWorked(attendanceList, employee.getEmployeeNumber(), startDate, endDate);
                    double netWeeklySalary = calculateNetSalary(employee, totalHoursWorked);
                    System.out.println("Net Weekly Salary: PHP " + String.format("%.2f",netWeeklySalary));
                    break;
                    
                case 5:
                    System.exit(0);
            }
    // Ask the user if they want to go back to the main menu        
            if (!askToGoBackToMainMenu(scanner)) {
                System.exit(0);
            }
            }
            }

    // Method to display the main menu for the employee portal
         private static void showMainMenu(Employee employee) {
             System.out.println("\nHi, " + employee.getFirstName() + "!");
             System.out.println("Welcome to MotorPH Employee Portal");
             System.out.println("**********************************");
             System.out.println("           Main Menu      ");
             System.out.println("**********************************");
             System.out.println("1: Display Employee Details");
             System.out.println("2: View Hours Worked Per Week");
             System.out.println("3: Calculate Gross Weekly Salary");
             System.out.println("4: Calculate Net Weekly Salary");   
             System.out.println("5: Exit");
             System.out.println("**********************************");
             System.out.print("Enter your choice here: ");
    }

    // Method to prompt the user for a date input and parse it to LocalDate
            private static LocalDate promptForDate(Scanner scanner, String prompt) {
            System.out.print(prompt);
            String dateStr = scanner.nextLine();
            return LocalDate.parse(dateStr, FORMATTER);
    }

    // Method to ask the user if they want to go back to the main menu
            private static boolean askToGoBackToMainMenu(Scanner scanner) {
            int userChoice = -1;  // Initialize with an invalid choice

    // Loop until the user enters either 1 or 0
            while (userChoice != 1 && userChoice != 0) {
            System.out.print("\nPress 1 to go back to the main menu or 0 to exit the program: ");
            if (scanner.hasNextInt()) {
            userChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            } else {
            System.out.println("Invalid input. Please enter 1 or 0.");
            scanner.nextLine();  // Clear the invalid input
            }
            }
            return userChoice == 1;
            }
    
    // Method to read attendance data from a file
            public static List<Attendance> readAttendanceData(String filePath) throws FileNotFoundException {
            List<Attendance> attendanceList = new ArrayList<>(); //Create empty list to store Attendance objects
            try (Scanner scanner = new Scanner(new File(filePath))) { //Open attendance data file using Scanner object
                scanner.nextLine(); 
                
                while (scanner.hasNextLine()) { // Read each line of the file while there's data available
                    String line = scanner.nextLine();
                    String[] data = line.split("\\|");

                    int employeeNumber = Integer.parseInt(data[0]); // Convert employee number to integer
                    String lastName = data[1]; // Store remaining data as strings
                    String firstName = data[2];
                    
                    Date date = null;
                    try { // Attempt to parse date and time (handle potential exceptions)
                        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                        date = dateFormat.parse(data[3]); 
                    } catch (ParseException e) {
                        System.out.println("Error parsing date: " + e.getMessage());
                    }
                    
                    LocalTime timeIn = null;
                    LocalTime timeOut = null;
                    
                    try{ // Directly parse time strings using LocalTime.parse
                        timeIn = LocalTime.parse(data[4]);
                        timeOut = LocalTime.parse(data[5]);
                    } catch (DateTimeParseException e) {
                        System.out.println("Error parsing time: " + e.getMessage());
                    }
        
    // Create an Attendance object with the extracted data
                    Attendance attendance = new Attendance(employeeNumber, lastName, firstName, date, timeIn, timeOut);
                    attendanceList.add(attendance);   // Add the attendance object to the list
                }
            }
            return attendanceList;
    }
    // Method to retrieve employee data based on employee number    
                    public static Employee getEmployeeData(int employeeNumber) throws FileNotFoundException {
                    String filePath = ("C:\\Users\\vncbv\\Desktop\\MotorPHApp\\MotorPHEmployeeData.txt"); ////use MotorPHEmployeeData txt file
                    try (Scanner fileScanner = new Scanner(new File(filePath))) // Use Scanner to read MotorPHEmployeeData.txt 
                    {
                    while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] data = line.split("\\|");
                
    // Handle lines with missing fields
                    if (data.length < 18) {
                    System.out.println("Error: Invalid data format in file. Line does not have 18 fields."); 
                    continue; // Move to the next line 
            }

                
                int fileEmpNumber = Integer.parseInt(data[0]);
                if (fileEmpNumber == employeeNumber) {
                    String lastName = data[1];
                    String firstName = data[2];
                    String birthday = data[3];
                    String address = data[4];
                    String phoneNumber = data[5];
                    String sssNumber = data[6];
                    String philhealthNumber = data[7];
                    String tinNumber = data[8];
                    String pagibigNumber = data[9];
                    String status = data[10];
                    String position = data[11];
                    String supervisor = data[12];
                    
                    try {
                        double basicSalary = Double.parseDouble(data[13]);
                        double riceSubsidy = Double.parseDouble(data[14]);
                        double phoneAllowance = Double.parseDouble(data[15]);
                        double clothingAllowance = Double.parseDouble(data[16]);
                        double grossSemiMonthlyRate = Double.parseDouble(data[17]);
                        double hourlyRate = Double.parseDouble(data[18]);
                        
                        return new Employee(employeeNumber, lastName, firstName, birthday, address, phoneNumber, sssNumber, philhealthNumber, tinNumber, pagibigNumber, status, position, supervisor, basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate); // Create and return Employee object
                        
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid data format in file.");
                    }
                }
            }   }
    throw new FileNotFoundException("Employee not found in file: " + filePath);
    }

    public static void displayEmployeeInformation(Employee employee) {
        if (employee != null) {
            System.out.println("\n==================================================================");
            System.out.println("                       EMPLOYEE INFORMATION");
            System.out.println("==================================================================");
            System.out.println("Employee Number: " + employee.getEmployeeNumber());
            System.out.println("Full Name: " + employee.getLastName() + ", " + employee.getFirstName());          
            System.out.println("Birthday: " + employee.getBirthday()); 
            System.out.println("Address: " + employee.getAddress());
            System.out.println("Phone Number: " + employee.getPhoneNumber());
            System.out.println("SSS Number: " + employee.getSSSNumber());
            System.out.println("PhilHealth Number: " + employee.getPhilHealthNumber());
            System.out.println("TIN Number: " + employee.getTinNumber());
            System.out.println("Pag-IBIG Number: " + employee.getPagIbigNumber());
            System.out.println("Employment Status: " + employee.getStatus());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Supervisor: " + employee.getSupervisor());
            System.out.println("Basic Salary: PHP " + String.format("%.2f",employee.getBasicSalary()));
            System.out.println("Rice Subsidy: PHP " + String.format("%.2f",employee.getRiceSubsidy()));
            System.out.println("Phone Allowance: PHP " + String.format("%.2f",employee.getPhoneAllowance()));
            System.out.println("Clothing Allowance: PHP " + String.format("%.2f",employee.getClothingAllowance()));
            System.out.println("Gross Semi-Monthly Rate: PHP " + String.format("%.2f",employee.getGrossSemiMonthlyRate()));
            System.out.println("Hourly Rate: PHP " + String.format("%.2f",employee.getHourlyRate()));
            System.out.println("==================================================================");          
        } else {
            System.out.println("Employee Information Unavailable.");
            }
            }

    // Method to calculate an employee's gross salary based on hours worked
            public static double calculateGrossSalary(Employee employee, long totalHoursWorked) {
            double hourlyRate = employee.getHourlyRate();
            return hourlyRate * totalHoursWorked;  
            }

    public static double calculateNetSalary(Employee employee, long totalHoursWorked) {
    // Calculate gross monthly salary based on total hours worked
    double grossMonthlySalary = calculateGrossSalary(employee, totalHoursWorked) * 4;

    // Initialize total deductions for the month
    double totalMonthlyDeductions = 0;

    // Loop through each deduction type and calculate the monthly deductions
    for (Deduction deduction : deductions) {
        double deductionAmount = deduction.calculateDeduction(grossMonthlySalary);

        // Print the deduction type and amount
        System.out.println(deduction.getClass().getSimpleName() + ": PHP " + String.format("%.2f", deductionAmount));

        // Accumulate the deduction amounts
        totalMonthlyDeductions += deductionAmount;
    }

    // Display the total monthly deductions - this is for QA purposes
    //System.out.println("Total Deductions: PHP " + String.format("%.2f", totalMonthlyDeductions));

    // Calculate taxable income (gross salary - total deductions)
    double taxableIncome = grossMonthlySalary - totalMonthlyDeductions;

    // Apply the withholding tax based on taxable income
    double monthlyWithholdingTax = calculateWithholdingTax(taxableIncome);

    // Print withholding tax amount
    System.out.println("Withholding Tax: PHP " + String.format("%.2f", monthlyWithholdingTax));
    System.out.println("=====================================================");
    
    // Subtract the monthly withholding tax from the taxable income
    double netMonthlySalary = taxableIncome - monthlyWithholdingTax;

    // Divide net monthly salary by 4 to get net weekly salary
    double weeklyNetSalary = netMonthlySalary / 4;

    return weeklyNetSalary;
    }

    // Method to calculate the withholding tax based on the taxable income
    public static double calculateWithholdingTax(double taxableIncome) {
    double tax = 0;

    if (taxableIncome <= 20832) {
        tax = 0; // No withholding tax
    } else if (taxableIncome > 20833 && taxableIncome < 33333) {
        tax = (taxableIncome - 20833) * 0.20;
    } else if (taxableIncome >= 33333 && taxableIncome < 66667) {
        tax = 2500 + (taxableIncome - 33333) * 0.25;
    } else if (taxableIncome >= 66667 && taxableIncome < 166667) {
        tax = 10833 + (taxableIncome - 66667) * 0.30;
    } else if (taxableIncome >= 166667 && taxableIncome < 666667) {
        tax = 40833.33 + (taxableIncome - 166667) * 0.32;
    } else {
        tax = 200833.33 + (taxableIncome - 666667) * 0.35;
    }

    return tax;
}

}
    
