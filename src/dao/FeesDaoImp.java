package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Fees;
import model.StudentFees;
import services.ConnectionManager;

public class FeesDaoImp implements FeesDao {

	private Connection currentCon = null;
	@Override
	public boolean addFees(Fees fees) {
		currentCon = ConnectionManager.getConnection();
		String addFeesQuery = "insert into fees(course,amount) values(?,?)";
		
		try {
			PreparedStatement ps = currentCon.prepareStatement(addFeesQuery);
			ps.setString(1, fees.getCourse());
			BigDecimal a = new BigDecimal(fees.getAmount());
			ps.setBigDecimal(2, a);
			int stat = ps.executeUpdate();
			if(stat>0){
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			if(currentCon != null)
				try {
					currentCon.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}

	@Override
	public Fees getFeesByCourse(String course) {
		currentCon = ConnectionManager.getConnection();
		String getFeesByCourseQuery = "select * from fees where course = ?";
		try {
			PreparedStatement ps = currentCon.prepareStatement(getFeesByCourseQuery);
			ps.setString(1, course);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String courses = rs.getString("course");
				double amount = rs.getDouble("amount");
				Fees fees = new Fees(id,courses,amount);
				return fees;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(currentCon != null)
				try {
					currentCon.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return null;
	}

	@Override
	public List<Fees> getAllCourseFees() {
		currentCon = ConnectionManager.getConnection();
		List<Fees> feesList = new ArrayList<Fees>();
		String getFeesByCourseQuery = "select * from fees";
		try {
			PreparedStatement ps = currentCon.prepareStatement(getFeesByCourseQuery);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String courses = rs.getString("course");
				double amount = rs.getDouble("amount");
				Fees fees = new Fees(id,courses,amount);
				feesList.add(fees);
				
			}
			return feesList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(currentCon != null)
				try {
					currentCon.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}

	@Override
	public boolean deleteCurseFees(int id) {
		currentCon = ConnectionManager.getConnection();
		String deleteFeesByIdQuery = "delete from fees where id=?";
		try {
			PreparedStatement ps = currentCon.prepareStatement(deleteFeesByIdQuery);
			ps.setInt(1, id);
			int stat = ps.executeUpdate();
			if(stat>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(currentCon != null)
				try {
					currentCon.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return false;
	}

	@Override
	public StudentFees getStudentFeesByUsername(String username) {
	
		Connection con = ConnectionManager.getConnection();
		
		try {
			PreparedStatement ps= con.prepareStatement("select studId from studentlogin where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int studentId = rs.getInt("studId");
				System.out.println("student Id :"+studentId);
				try{
					PreparedStatement ps1 = con.prepareStatement("select * from feespaid where studId = ?");
					ps1.setInt(1, studentId);
					ResultSet rs1 = ps1.executeQuery();
					while(rs1.next()){
						
						double total =rs1.getDouble("totalfees");
						double paid = rs1.getDouble("paidfees");
						Date date = rs1.getDate("feespaiddate");
						double remaining = total-paid;
						StudentFees sf = new StudentFees();
						sf.setTotalFees(total);
						sf.setPaidFees(paid);
						sf.setRemainingFees(remaining);
						sf.setFeesPaidDate(date);
						return sf;
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateStudentFees(String username,double fees, Date dateofpaid) {
		Connection con = ConnectionManager.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("select studId from studentlogin where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int studentId = rs.getInt("studId");
				PreparedStatement ps1 = con.prepareStatement("update feespaid set paidfees = ?, feespaiddate = ? where studId = ?");
				ps1.setBigDecimal(1, new BigDecimal(fees));
				java.sql.Date sqlDate = new java.sql.Date(dateofpaid.getTime());
				ps1.setDate(2, sqlDate);
				ps1.setInt(3, studentId);
				int i = ps1.executeUpdate();
				if(i>0)
					return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	
}
