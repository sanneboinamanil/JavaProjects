package com.DAo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BankUserDetails.BankUserDetails;

public class BankUserDAOImp implements BankDAO {
	
	private static final String url="jdbc:mysql://localhost:3306/teca_63?user=root&password=12345" ;
	private static final String insert="insert into bank_user_details(Name, EmailId, Aadhar_Number,"
			+ " Mobile_Number, Pan_Number, Address, Gender , Amount, Status) values(?,?,?,?,?,?,?,?,?)";
	
	private static final String select_all="select * from bank_user_details";
	
	public static final String update="update bank_user_details set Pin= ?, Acount_Number= ?,Status = ? where Aadhar_Number= ? ";
	
	public static final String delete="delete from bank_user_details where Aadhar_Number= ? ";
	
	public static final String userDeatils="select * from bank_user_details where EmailId = ? or Acount_Number= ? and Pin= ?";
	
	@Override
	public void insertBankUserDAO(BankUserDetails b) {
		try {
			Connection con=DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(insert);
			long aadhar=b.getAadharnumber();
			ps.setString(1, b.getName());
			ps.setString(2, b.getEmailid());
			
			ps.setLong(3,aadhar);
			ps.setLong(4,b.getMobilenumber());
			ps.setString(5, b.getPannumber());
			ps.setString(6, b.getAddress());
			ps.setString(7,b.getGender());
			ps.setDouble(8, b.getAmount());
			ps.setString(9, "Pending");
			int result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void getUserDetailsByUsingEmailAndPassword(String email, String password) {
		
		Connection con;
		try {
			con = DriverManager.getConnection(url);
			String query="select * from where EmailId= "+email+" and Pin = "+password;
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet result=ps.executeQuery();
			
			if(result.isBeforeFirst())
			{
				while(result.next())
				{
					
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<BankUserDetails> getAllBankUserDetails() {
		try
		{
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(select_all);
			ResultSet result=ps.executeQuery();
			List<BankUserDetails> list=new ArrayList<BankUserDetails>();
			if(result.isBeforeFirst())
			{
				while(result.next())
				{
					BankUserDetails bankUserDetails=new BankUserDetails();
					bankUserDetails.setAadharnumber(result.getLong("Aadhar_Number"));
					bankUserDetails.setMobilenumber(result.getLong("Mobile_Number"));
					bankUserDetails.setPannumber(result.getString("Pan_Number"));
					bankUserDetails.setEmailid(result.getString("EmailId"));
					bankUserDetails.setStatus(result.getString("Status"));
					bankUserDetails.setName(result.getString("Name"));
					bankUserDetails.setId(result.getInt("Id"));
					bankUserDetails.setAddress(result.getString("Address"));
					bankUserDetails.setGender(result.getString("Gender"));
					bankUserDetails.setAmount(result.getDouble("Amount"));
					list.add(bankUserDetails);	
					
				}
				return list;
			}
			else
				return null;
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		return null;
		}
	}
	@Override
	public int updatePinAndAccountNumAndStatus(int pin, int accountnumber, long aadharnumber) {
		try {
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(update);
			ps.setInt(1, pin);
			ps.setInt(2, accountnumber);
			ps.setString(3, "Accpeted");
			ps.setLong(4, aadharnumber);
			return ps.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int deleteRejectedUserByAadharNum(long aadharnumber) {
		try {
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(delete);
			ps.setLong(1, aadharnumber);
			return ps.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public void getUserDetailsByUsingEmailIdAndPin(String emailoraccountnumber, int pin) {
		try {
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps=con.prepareStatement(userDeatils);
			ps.setString(1,emailoraccountnumber );
			ps.setString(2, emailoraccountnumber);
			ps.setInt(3, pin);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Login");
			}
			else {
				System.out.println("Invalid details");
			}
			
	}
	catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
	

