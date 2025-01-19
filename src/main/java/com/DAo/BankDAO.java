package com.DAo;

import java.util.List;

import com.BankUserDetails.BankUserDetails;

public interface BankDAO {
	
	void insertBankUserDAO(BankUserDetails b);
	void getUserDetailsByUsingEmailAndPassword(String email,String password);
	List<BankUserDetails> getAllBankUserDetails();
	int updatePinAndAccountNumAndStatus(int pin,int accountnumber,long aadharnumber);
	int  deleteRejectedUserByAadharNum(long aadharnumber);
	void getUserDetailsByUsingEmailIdAndPin(String emailoraccountnumber,int pin);

}
