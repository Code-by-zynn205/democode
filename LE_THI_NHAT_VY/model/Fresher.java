package model;

public class Fresher extends Employee {

    private String Graduation_date;
    private String Graduation_rank;
    private String Education;

    public Fresher(String fullName, String birthDay, String phone, String email, String employee_type,
            String graduation_date, String graduation_rank, String education) {
        super(fullName, birthDay, phone, email, employee_type);
        this.Graduation_date = graduation_date;
        this.Graduation_rank = graduation_rank;
        this.Education = education;
    }

    public String getGraduation_date() {
		return Graduation_date;
	}

	public void setGraduation_date(String graduation_date) {
		Graduation_date = graduation_date;
	}

	public String getGraduation_rank() {
		return Graduation_rank;
	}

	public void setGraduation_rank(String graduation_rank) {
		Graduation_rank = graduation_rank;
	}

	public String getEducation() {
		return Education;
	}

	public void setEducation(String education) {
		Education = education;
	}

	public void showInfo() {
        super.showInfo();
        System.out.println("Graduation Date: " + Graduation_date);
        System.out.println("Graduation Rank: " + Graduation_rank);
        System.out.println("Education: " + Education);
    }
}
