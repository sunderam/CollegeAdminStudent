package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import model.Attendence;
import services.ConnectionManager;

public class AttendenceDaoImp implements AttendenceDao {

	@Override
	public boolean addAttendence(Attendence attendence) {
		Connection currentCon = ConnectionManager.getConnection();
		String addAttendenceQuery = "insert into studentattendence(dateofattendence,presence,studId) values(?,?,?)";
		try {
			PreparedStatement ps = currentCon.prepareStatement(addAttendenceQuery);
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			ps.setDate(1, sqlDate);
			ps.setString(2, attendence.getPresence());
			ps.setInt(3, attendence.getStudentId());
			
			int i = ps.executeUpdate();
			
			if(i>0)
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Attendence getAttendenceByStudentId(int id,
			Date dateOfAttendence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attendence> getAttendenceByMonth(String username, String from,
			String to) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date fromDate=null;
		Date toDate=null;
		try {
			fromDate = format.parse(from);
			toDate = format.parse(to);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Connection con = ConnectionManager.getConnection();
		int id;
		List<Attendence> attendenceList = new ArrayList<Attendence>();
		try {
			PreparedStatement ps = con.prepareStatement("select studId from studentlogin where username = ?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				id = rs.getInt("studId");
				try{
				PreparedStatement ps1 = con.prepareStatement("select * from studentattendence where dateofattendence BETWEEN ? AND ? AND studId = ?");
				ps1.setDate(1, new java.sql.Date(fromDate.getTime()));
				ps1.setDate(2, new java.sql.Date(toDate.getTime()));
				ps1.setInt(3, id);
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()){
					Attendence att = new Attendence();
					att.setDateOfAttendence(rs1.getDate("dateofattendence"));
					att.setPresence(rs1.getString("presence"));
					attendenceList.add(att);
					
				}
				return attendenceList;
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return null;
	}

}
