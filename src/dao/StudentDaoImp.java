package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import model.StudentAddress;
import services.ConnectionManager;
import services.PasswordGenerator;

public class StudentDaoImp implements StudentDao {

	static Connection currentCon = null;
	static ResultSet rs = null;
	@Override
	public boolean addStudent(Student student) {
		Connection con = ConnectionManager.getConnection();

		try {

			con = ConnectionManager.getConnection();
			String insertStudentquery = "insert into students(name,email,std,division) values(?,?,?,?)";
			PreparedStatement st = con.prepareStatement(insertStudentquery,
					PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(1, student.getName());
			st.setString(2, student.getEmail());
			st.setString(3, student.getStd());
			st.setString(4, student.getDiv());
			int i = st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				String addQuery = "insert into studentaddress(street,area,city,state,zip,studId)values(?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(addQuery);

				ps.setString(1, student.getStudentAdress().getStreet());
				ps.setString(2, student.getStudentAdress().getArea());
				ps.setString(3, student.getStudentAdress().getCity());
				ps.setString(4, student.getStudentAdress().getState());
				ps.setString(5, student.getStudentAdress().getZip());
				ps.setInt(6, id);
				
				int j = ps.executeUpdate();
				if (j > 0) {
					String studentLoginQuery = "insert into studentlogin (username,password,studid,role) values(?,?,?,?)";
					try{
						
						PreparedStatement ps1 = con.prepareStatement(studentLoginQuery);
						ps1.setString(1, student.getEmail());
						ps1.setString(2, PasswordGenerator.getPassword());
						ps1.setInt(3, id);
						ps1.setString(4, "STUDENT");
						int k = ps1.executeUpdate();
						if(k>0)
							addTotalFees(student.getStd(),id);
							return true;
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}

	@Override
	public boolean updateStudent(Student student) {
		currentCon = ConnectionManager.getConnection();
		String updateQuery = "update students set name = ?,email = ?, std = ?, division = ? where studId =?";
		try {
			PreparedStatement ps = currentCon.prepareStatement(updateQuery);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getStd());
			ps.setString(4, student.getDiv());
			ps.setInt(5, student.getStudId());
			int i = ps.executeUpdate();
			if(i != 0){
				String addressUpdateQuery = "update studentaddress set street = ?, area = ?, city = ?, state = ?, zip = ? where studId = ?"; 
				Connection con = ConnectionManager.getConnection();
				PreparedStatement ps1 = con.prepareStatement(addressUpdateQuery);
				
				ps1.setString(1, student.getStudentAdress().getStreet());
				ps1.setString(2, student.getStudentAdress().getArea());
				ps1.setString(3, student.getStudentAdress().getCity());
				ps1.setString(4, student.getStudentAdress().getState());
				ps1.setString(5, student.getStudentAdress().getZip());
				ps1.setInt(6, student.getStudId());
				int j = ps1.executeUpdate();
				if(j !=0 ){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void deleteStudent(int studentId) {
		currentCon = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = currentCon.prepareStatement("delete from students where studId=?");
			ps.setInt(1, studentId);
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println("deleted");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<Student>();
		Student s = null;
		StudentAddress sa = null;
		
		int sid = 0;
		String name = "";
		String email = "";
		String std = "";
		String div = "";
		
		ResultSet rs = null;
		Connection con = ConnectionManager.getConnection();
		String studQuery = "select * from students";
		String addQuery = "select * from studentaddress where studId = ?";

		try {
			PreparedStatement ps = con.prepareStatement(studQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				sid = rs.getInt("studId");
				name = rs.getString("name");
				email = rs.getString("email");
				std = rs.getString("std");
				div = rs.getString("division");
				
				PreparedStatement pst = con.prepareStatement(addQuery);
				pst.setInt(1, sid);
				ResultSet rs1 = pst.executeQuery();
				
				while(rs1.next()){
					int addId = rs1.getInt("addressId");
					String street = rs1.getString("street");
					String area = rs1.getString("area");
					String city = rs1.getString("city");
					String state = rs1.getString("state");
					String zip = rs1.getString("zip");
					
					sa = new StudentAddress(addId,street,area,city,state,zip);
					s = new Student(sid,name,email,std,div,sa);
					studentList.add(s);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return studentList;
		
	}

	@Override
	public Student getStudentById(int studentId) {
		StudentAddress sa = null;
		int sid = 0;
		String name = "";
		String email = "";
		String std = "";
		String div = "";

		ResultSet rs = null;
		Connection con = ConnectionManager.getConnection();
		String studQuery = "select * from students where studId = ?";
		String addQuery = "select * from studentaddress where studId = ?";

		try {
			PreparedStatement ps = con.prepareStatement(studQuery);
			ps.setInt(1, studentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				sid = rs.getInt("studId");
				name = rs.getString("name");
				email = rs.getString("email");
				std = rs.getString("std");
				div = rs.getString("division");
				
				PreparedStatement pst = con.prepareStatement(addQuery);
				pst.setInt(1, sid);
				ResultSet rs1 = pst.executeQuery();
				
				while(rs1.next()){
					int addId = rs1.getInt("addressId");
					String street = rs1.getString("street");
					String area = rs1.getString("area");
					String city = rs1.getString("city");
					String state = rs1.getString("state");
					String zip = rs1.getString("zip");
					sa = new StudentAddress(addId,street,area,city,state,zip);	
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return new Student(sid,name,email,std,div,sa);
		
	}

	@Override
	public Student getStudentByUsername(String username) {
		Connection con = ConnectionManager.getConnection();
		String userQuery = "select studId from studentlogin where username=?";
		try {
			PreparedStatement ps = con.prepareStatement(userQuery);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("studId");
				return getStudentById(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}

	@Override
	public void addTotalFees(String course,int studId) {
		Connection con = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select amount from fees where course=?");
			ps.setString(1, course);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				BigDecimal amount = rs.getBigDecimal("amount");
				PreparedStatement ps1 = con.prepareStatement("insert into feespaid(totalfees,studId) values(?,?)");
				ps1.setBigDecimal(1, amount);
				ps1.setInt(2, studId);
				ps1.executeUpdate();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
