package model;

public class Experience extends Employee {

    private int ExpInYear;
    private String ProSkill;

    public Experience(String fullName, String birthDay, String phone, String email, String employee_type,
            int expInYear, String proSkill) {
        super(fullName, birthDay, phone, email, employee_type);
        this.ExpInYear = expInYear;
        this.ProSkill = proSkill;
    }

    public int getExpInYear() {
		return ExpInYear;
	}

	public void setExpInYear(int expInYear) {
		ExpInYear = expInYear;
	}

	public String getProSkill() {
		return ProSkill;
	}

	public void setProSkill(String proSkill) {
		ProSkill = proSkill;
	}

	public void showInfo() {
        super.showInfo();
        System.out.println("Experience in Years: " + ExpInYear);
        System.out.println("Professional Skill: " + ProSkill);
    }

}
