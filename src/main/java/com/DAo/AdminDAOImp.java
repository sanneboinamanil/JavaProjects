package com.DAo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImp implements AdminDAO {
	private static final String url="jdbc:mysql://localhost:3306/teca_63?user=root&password=12345" ;

	private static final String admin_login="select * from admin where Admin_EmailId = ? and Admin_Password = ?";
	@Override
	public boolean getAdminDetailByUsingEmailidAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		
		try {
			Connection  con= DriverManager.getConnection(url);

			PreparedStatement ps=con.prepareStatement(admin_login);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet result = ps.executeQuery();
			if (result.next()) {
			    System.out.println("ResultSet contains data.");
			    return true;
			} else {
			    return false;
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
