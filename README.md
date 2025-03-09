# MotorPH Employee Portal

The **MotorPH Employee Portal** is a Java-based application that allows employees to view their information, track their worked hours, and calculate their gross and net salaries. This application reads employee and attendance data from text files to ensure ease of access and data management.

## Project Structure

### Main Class: 
- **MotorPHEmployeePortal.java**

### Main Functionalities:
1. **Display Employee Details**: Provides employee-specific information such as name, salary, and employment details.
2. **View Hours Worked Per Week**: Shows the employee's attendance and total worked hours within a specified date range.
3. **Calculate Gross Weekly Salary**: Calculates the employee's gross salary based on the hours worked in a week.
4. **Calculate Net Weekly Salary**: Computes the net salary after deductions such as SSS, PhilHealth, Pagibig, and withholding tax.

## Requirements

- **Java Development Kit (JDK)**
- **NetBeans IDE** (or any Java-supported IDE)

## Data Files

This application relies on two `.txt` files for data input:
1. **MotorPHEmployeeData.txt**: Contains employee information including salary and allowances.
2. **Attendance.txt**: Logs employee attendance details such as the date, time-in, and time-out.

### Important:
The program will not work unless these two files are present in the specified directory. Make sure the paths to the files are correct in the source code.

Example:
```
C:\Users\vncbv\Desktop\MotorPHApp\MotorPHEmployeeData.txt
C:\Users\vncbv\Desktop\MotorPHApp\Attendance.txt
```

## How to Run

1. **Clone the Repository** or download the project files.
2. **Ensure the data files** (`MotorPHEmployeeData.txt` and `Attendance.txt`) are placed in the correct directory.
3. Open the project in **NetBeans** or your preferred Java IDE.
4. Run the `MotorPHEmployeePortal.java` file.
5. Follow the prompts to enter the employee number and access various functionalities.

## Usage

- Upon running, you will be asked to provide an **employee number**.
- After entering the number, the main menu will appear with several options to choose from, such as viewing employee details, calculating salary, and exiting the program.

## Notes

- The system uses basic input and output for interaction, so ensure the input is in the correct format when prompted (e.g., dates should be in `MM/DD/YYYY` format).
- When calculating hours worked or salary, the system will only process data based on the available attendance records within the specified date range.

---

