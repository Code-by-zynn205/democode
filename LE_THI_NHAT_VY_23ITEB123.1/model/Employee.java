package model;

public class Employee implements IEmployee {

    public int ID;
    private String FullName;
    private String BirthDay;
    private String Phone;
    private String Email;
    private String Employee_type;
    private static int Employee_count = 0;

    public Employee(String fullName, String birthDay, String phone, String email, String employee_type) {
        this.FullName = fullName;
        this.BirthDay = birthDay;
        this.Phone = phone;
        this.Email = email;
        this.Employee_type = employee_type;
        Employee_count++;
    }

    public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(String birthDay) {
		BirthDay = birthDay;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getEmployee_type() {
		return Employee_type;
	}

	public void setEmployee_type(String employee_type) {
		Employee_type = employee_type;
	}

	public static int getEmployee_count() {
		return Employee_count;
	}

	public static void setEmployee_count(int employee_count) {
		Employee_count = employee_count;
	}

	public void showInfo() {
        System.out.println("ID: " + ID);
        System.out.println("Full Name: " + FullName);
        System.out.println("Birthday: " + BirthDay);
        System.out.println("Phone: " + Phone);
        System.out.println("Email: " + Email);
        System.out.println("Employee Type: " + Employee_type);
    }

	
	
}
