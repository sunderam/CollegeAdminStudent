package model;

import java.math.BigDecimal;
import java.util.Date;

public class StudentFees {

	private int id;
	private double totalFees;
	private double paidFees;
	private double remainingFees;
	private Date feesPaidDate;
	private int studId;
	
	public StudentFees(){
		
	}

	public StudentFees(int id, double totalFees, double paidFees,
			double remainingFees, Date feesPaidDate, int studId) {
		super();
		this.id = id;
		this.totalFees = totalFees;
		this.paidFees = paidFees;
		this.remainingFees = remainingFees;
		this.feesPaidDate = feesPaidDate;
		this.studId = studId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(double totalFees) {
		this.totalFees = totalFees;
	}

	public double getPaidFees() {
		return paidFees;
	}

	public void setPaidFees(double paidFees) {
		this.paidFees = paidFees;
	}

	public double getRemainingFees() {
		return remainingFees;
	}

	public void setRemainingFees(double remainingFees) {
		this.remainingFees = remainingFees;
	}

	public Date getFeesPaidDate() {
		return feesPaidDate;
	}

	public void setFeesPaidDate(Date feesPaidDate) {
		this.feesPaidDate = feesPaidDate;
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}
	
}
