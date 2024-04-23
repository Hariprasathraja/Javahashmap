User Data Manager:
  The UserDataManager program is a simple Java application that allows users to input and manage user data (username and email) using a HashMap and store it in a JSON file.

Features:
  Input User Data: Users can input multiple usernames and emails interactively through the console.
  Save Data to File: The entered user data is stored in a JSON file named UserData.json.
  Load Data from File: Upon program startup, existing user data from the JSON file is loaded into the program.
  Error Handling: The program handles file-related errors, such as file not found or I/O exceptions.

Usage:
  Compile the Program: Compile the UserDataManager.java file using a Java compiler.

Copy code: javac UserDataManager.java
Run the Program: Execute the compiled class file.

Copy code: java UserDataManager

Enter User Data: Follow the on-screen prompts to input the desired number of users, their usernames, and emails.
View Saved Data: The program will save the entered user data to the UserData.json file. You can view this file to see the stored user data.

File Structure:
 UserDataManager.java: Contains the main Java program.
 UserData.json: JSON file to store user data.

Dependencies:
Java Development Kit (JDK): Ensure that you have JDK installed to compile and run the Java program.

Notes:
If the UserData.json file does not exist or is empty, the program will create a new one.
The program uses a HashMap to store user data in memory and saves it to the JSON file when required.
