package com.BankUserDetails;

public class BankUserDetails {
	
	private int id;
	private String name;
	private String emailid;
	private long mobilenumber;
	private long aadharnumber;
	private String pannumber;
	private String address;
	private String gender;
	private double amount;
	private int pin;
	private int accountnumber;
	private String status;
	
	public BankUserDetails()
	{
	}
	public BankUserDetails(int id, String name, String emailid, long mobilenumber, long aadharnumber, String pannumber,
			String address, String gender, double amount, int pin, int accountnumber, String status) {
		super();
		this.id = id;
		this.name = name;
		this.emailid = emailid;
		this.mobilenumber = mobilenumber;
		this.aadharnumber = aadharnumber;
		this.pannumber = pannumber;
		this.address = address;
		this.gender = gender;
		this.amount = amount;
		this.pin = pin;
		this.accountnumber = accountnumber;
		this.status = status;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public long getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(long aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BankUserDetails [id=" + id + ", name=" + name + ", emailid=" + emailid + ", mobilenumber="
				+ mobilenumber + ", aadharnumber=" + aadharnumber + ", pannumber=" + pannumber + ", address=" + address
				+ ", gender=" + gender + ", amount=" + amount + ", pin=" + pin + ", accountnumber=" + accountnumber
				+ ", status=" + status + "]";
	}
	
	
	
	

}
