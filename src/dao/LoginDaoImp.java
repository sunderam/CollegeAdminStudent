package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import services.ConnectionManager;

public class LoginDaoImp implements LoginDao {

	@Override
	public String isAuthenticated(String username, String password) {
		Connection currentCon = null;
		currentCon = ConnectionManager.getConnection();
		String loginQuery = "select * from studentlogin where username = ? and password = ?";
		try {
			PreparedStatement ps = currentCon.prepareStatement(loginQuery);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				return rs.getString("role");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
