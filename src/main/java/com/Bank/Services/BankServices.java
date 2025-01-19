package com.Bank.Services;

public interface BankServices {
	void forSleep(String value);
	void registeration();
	boolean aadharValidation(long aadhar);
	boolean validateMobile(long num);
	boolean validatePan(String pan);
	void userLogin();

}
