package DATABASE;

import model.Employee;
import model.Experience;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;


public class database {
	private static final Statement DatabaseConnection = null;
	public static Connection getCon() {
	    try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://DESKTOP-OR781KT\\SQLEXPRESS:1433;databaseName=KTKy2Java";
	        String userName = "sa";
	        String password = "123456789";
	        Connection con = DriverManager.getConnection(url, userName, password);
	        System.out.println("Kết nối thành công");
	        return con;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	public void readEmployeesFromFile(String filePath) {
        try (Connection connection = getCon()) {
            String sql = "SELECT * FROM employees";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.executeUpdate();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");

                    String fullName = data[0];
                    String birthday = data[1];
                    String phone = data[2];
                    String email = data[3];
                    String employeeType = data[4];
                    int expInYear = Integer.parseInt(data[5]);
                    String proSkill = data[6];
                    System.out.println("Full Name: " + fullName);
                    System.out.println("Birthday: " + birthday);
                    System.out.println("Phone: " + phone);
                    System.out.println("Email: " + email);
                    System.out.println("Employee Type: " + employeeType);
                    System.out.println("Experience in Years: " + expInYear);
                    System.out.println("Professional Skill: " + proSkill);
                    System.out.println();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Employees read successfully from the file.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	 public void addEmployeesFromFile(String filePath) {
	        try (Connection connection = getCon()) {
	            String sql = "INSERT INTO employees (full_name, birthday, phone, email, employee_type, exp_in_year, pro_skill) VALUES (?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement statement = connection.prepareStatement(sql);

	            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    String[] data = line.split(",");

	                    statement.setString(1, data[0]);
	                    statement.setString(2, data[1]);
	                    statement.setString(3, data[2]);
	                    statement.setString(4, data[3]);
	                    statement.setString(5, data[4]);
	                    statement.setInt(6, Integer.parseInt(data[5]));
	                    statement.setString(7, data[6]);

	                    statement.executeUpdate();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	            System.out.println("Employees added successfully from the file.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

 
