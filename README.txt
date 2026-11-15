Project Name: Student Marksheet Management System
Developer: [Your Name]

--- OVERVIEW ---
This project is a Java-based application that allows users to view student marks 
and calculate grades/results after logging in.

--- DATABASE SETUP ---
1. Ensure your MySQL server is running.
2. Open your MySQL command-line tool or any SQL client.
3. Create a database named 'sms' by running: CREATE DATABASE sms;
4. Import the provided 'student_database.sql' file into the 'sms' database.

--- HOW TO RUN ---
1. Ensure the MySQL Connector/J driver is added to your project classpath.
2. Compile the Java file: javac ViewMarksheet.java
3. Run the application: java ViewMarksheet

--- NOTES ---
- The database credentials used in the code are:
  Username: root
  Password: 12345
- The application uses the 'sms' database.