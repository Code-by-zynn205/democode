package view;

import java.util.Scanner;

import DATABASE.database;
import control.Company;

public class main {

	public static void main(String[] args) {
	    database Database = new database();
	    Scanner scanner = new Scanner(System.in);
	    boolean exit = false;

	    while (!exit) {
	        System.out.println("Company Management System");
	        System.out.println("1. Add Employee");
	        System.out.println("2. Remove Employee");
	        System.out.println("3. Display Employees");
	        System.out.println("4. Exit");
	        System.out.print("Enter your choice: ");
	        int choice = scanner.nextInt();
	        scanner.nextLine(); 

	        switch (choice) {
	            case 1:
	                System.out.print("Enter file path: ");
	                String addFilePath = scanner.nextLine();
	                Database.addEmployeesFromFile(addFilePath);
	                break;
	            case 2:
	                
	                break;
	            case 3:
	                System.out.print("Enter file path: ");
	                String displayFilePath = scanner.nextLine();
	                Database.readEmployeesFromFile(displayFilePath);
	                break;
	            case 4:
	                exit = true;
	                break;
	            default:
	                System.out.println("Enter retype");
	        }
	    }

	    scanner.close();
	}
}