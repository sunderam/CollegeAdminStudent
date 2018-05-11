package model;

public class Fees {

	private int id;
	private String course;
	private double amount;
	
	public Fees(){
		
	}

	public Fees(int id, String course, double amount) {
		super();
		this.id = id;
		this.course = course;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
