package control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import model.Employee;
import model.Experience;
import model.Fresher;
import model.Intern;

public class Company {

    private List<Employee> employees;

    public Company() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Scanner scanner) {
        System.out.println("Enter employee information:");
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();
        System.out.print("BirthDay: ");
        String birthDay = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Employee Type (Experience/Fresher/Intern): ");
        String employeeType = scanner.nextLine();

        Employee newEmployee;
        switch (employeeType.toLowerCase()) {
            case "experience":
                System.out.print("Experience in Years: ");
                int expInYear = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Professional Skill: ");
                String proSkill = scanner.nextLine();
                newEmployee = new Experience(fullName, birthDay, phone, email, employeeType, expInYear, proSkill);
                break;
            case "fresher":
                System.out.print("Graduation Date: ");
                String graduationDate = scanner.nextLine();
                System.out.print("Graduation Rank: ");
                String graduationRank = scanner.nextLine();
                System.out.print("Education: ");
                String education = scanner.nextLine();
                newEmployee = new Fresher(fullName, birthDay, phone, email, employeeType, graduationDate, graduationRank, education);
                break;
            case "intern":
                System.out.print("Majors: ");
                String majors = scanner.nextLine();
                System.out.print("Semester: ");
                String semester = scanner.nextLine();
                System.out.print("University Name: ");
                String universityName = scanner.nextLine();
                newEmployee = new Intern(fullName, birthDay, phone, email, employeeType, majors, semester, universityName);
                break;
            default:
                System.out.println("Invalid employee type.");
                return;
        }

        employees.add(newEmployee);
        System.out.println("Employee added successfully.");
    }

    public void removeEmployee(Scanner scanner) {
        System.out.print("Enter employee ID to remove: ");
        int idToRemove = scanner.nextInt();
        scanner.nextLine(); 

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.ID == idToRemove) {
                iterator.remove();
                System.out.println("Employee removed successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + idToRemove + " not found.");
    }

    public void displayEmployees() {
        System.out.println("Company employees:");
        for (Employee emp : employees) {
            emp.showInfo();
            System.out.println();
        }
    }
    
}
