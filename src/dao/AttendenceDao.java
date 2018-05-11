package dao;

import java.util.Date;
import java.util.List;

import model.Attendence;

public interface AttendenceDao {

	public boolean addAttendence(Attendence attendence);
	public Attendence getAttendenceByStudentId(int id,Date dateOfAttendence);
	public List<Attendence> getAttendenceByMonth(String username,String from,String to);
}
