package model;

import java.util.Date;

public class Attendence {

	private int id;
	private String presence;
	private Date dateOfAttendence;
	private int studentId;
	
	public Attendence(){
		
	}

	public Attendence(int id, String presence, Date dateOfAttendence,int studentId) {
		super();
		this.id = id;
		this.presence = presence;
		this.dateOfAttendence = dateOfAttendence;
		this.studentId = studentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPresence() {
		return presence;
	}

	public void setPresence(String presence) {
		this.presence = presence;
	}

	public Date getDateOfAttendence() {
		return dateOfAttendence;
	}

	public void setDateOfAttendence(Date dateOfAttendence) {
		this.dateOfAttendence = dateOfAttendence;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
}
