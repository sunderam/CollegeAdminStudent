package dao;

import java.util.Date;
import java.util.List;

import model.Fees;
import model.StudentFees;

public interface FeesDao {
	public boolean addFees(Fees fees);
	public Fees getFeesByCourse(String course);
	public List<Fees> getAllCourseFees();
	public boolean deleteCurseFees(int id);
	public StudentFees getStudentFeesByUsername(String username);
	public boolean updateStudentFees(String username,double fees,Date dateofpaid);
}
