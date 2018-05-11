package model;


public class Student {

	private int studId;
	private String name;
	private String email;
	private String std;
	private String div;
	private StudentAddress studentAdress;

	public Student() {
	
	}

	public Student(int studId, String name, String email, String std,
			String div, StudentAddress studentAdress) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.std = std;
		this.div = div;
		this.studentAdress = studentAdress;
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public StudentAddress getStudentAdress() {
		return studentAdress;
	}

	public void setStudentAdress(StudentAddress studentAdress) {
		this.studentAdress = studentAdress;
	}

	
}
