package com.Bank.Services;

import java.util.List;
import java.util.Scanner;

import com.Bank.Exception.BankUserException;
import com.BankUserDetails.BankUserDetails;
import com.DAo.BankDAO;
import com.DAo.BankUserDAOImp;

public class BankServiceImp  implements BankServices{

	Scanner sc=new Scanner(System.in);
	BankDAO b=new BankUserDAOImp();
	@Override
	public void forSleep(String value) {
		for(int i=0;i<value.length()-1;i++)
		{
			System.out.print(value.charAt(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	
	@Override
	public void registeration() {
		BankUserDetails bankUserDetails=new BankUserDetails();
		System.out.println("Enter your Name: ");
		String name=sc.next();
		bankUserDetails.setName(name);
		boolean emailStatus=true;
		while(emailStatus)
		{
			try
			{
				System.out.println("enter  Your EmailId: ");
				String emailid=sc.next();
				if(validateEmail(emailid))
				{
					emailStatus=false;
					bankUserDetails.setEmailid(emailid);
				}
				else
				{
					throw new BankUserException("invalid email");
				}
			}
			catch(BankUserException e)
			{
				System.out.println(e.getMsg());
			}
		}
			
		boolean status=true;
		while(status)
		{
			try
			{
			System.out.println("Enter Your AadharNumber: ");
			Long aadhar=sc.nextLong();
			if(aadharValidation(aadhar))
			{
				status=false;
				bankUserDetails.setAadharnumber(aadhar);
			}
			else
				throw new BankUserException("invalid andhar number");
			}
			catch(BankUserException e)
			{
				System.out.println(e.getMsg());
			}
		}
			
		boolean status1=true;
		while(status1)
		{
			try {
				System.out.println("Enter Your MoblieNumber");
				Long moblie=sc.nextLong();
				if(validateMobile(moblie))
				{	
					status1=false;
					bankUserDetails.setMobilenumber(moblie);
				}
				else
					throw new BankUserException ("moblie number  is Invalid");
			}
			catch(BankUserException e)
			{
				System.out.println(e.getMsg());
			}
		
		}
		boolean panStatus=true;
		while(panStatus)
		{
			try
			{
				System.out.println("Enter Yout PanNumber: ");
				String pan=sc.next();
				if(validatePan(pan))
				{
					panStatus=false;
					bankUserDetails.setPannumber(pan);
				}
				else
					throw new BankUserException ("pan card  is Invalid");
			}
			catch(BankUserException e)
			{
				System.out.println(e.getMsg());
			}
		}
		System.out.println("Enter Your Address: ");
		String address=sc.next();
		bankUserDetails.setAddress(address);
		System.out.println("Enter Your Gender: ");
		String gender=sc.next();
		bankUserDetails.setGender(gender);
		System.out.println("Enter Your Amount: ");
		double amount=sc.nextDouble();
		bankUserDetails.setAmount(amount);
		b.insertBankUserDAO(bankUserDetails);
		
		
	}

	@Override
	public boolean aadharValidation(long aadhar) {
		boolean isValidate=true;
		List<BankUserDetails> allBankUserDetails =b.getAllBankUserDetails();
		  
		int count =0;
		long temp=aadhar;
		
		while(aadhar>0)
		{
			count++; 
			aadhar/=10;
		}
		if(count==12)
		{
			if (allBankUserDetails == null || allBankUserDetails.isEmpty()) {
			     
		        return isValidate=true;
		    }
			//int adharCount=0;
//			for(BankUserDetails bankUserDetails : allBankUserDetails)
//			{
//				if(bankUserDetails.getAadharnumber()==temp)
//				{
//					adharCount++;
//				}
//				if(adharCount>0)
//				{
//					throw new BankUserException("Already Exiting");
//				}
			long aadharcount = allBankUserDetails.stream().filter(bankUser->bankUser.getAadharnumber()==temp).count();
			if(aadharcount==0)
					isValidate=true;
			else
				throw new BankUserException("Already Exiting");
				
		}
		else
		{
			isValidate=false;
		}
		return isValidate;
			
	}
	

	@Override
	public boolean validateMobile(long num) {
		List<BankUserDetails> allBankUserDetails =b.getAllBankUserDetails();
		
		boolean isvalid=true;
		
	
		if(num>=6000000000l && num<=9999999999l)
		{
			 if (allBankUserDetails == null || allBankUserDetails.isEmpty()) {
			     
			        return isvalid=true;
			    }
			long count= allBankUserDetails.stream().filter(user->user.getMobilenumber()==num).count();
			
				if(count==0)
				{
					isvalid=true;
				}
				else
					throw new BankUserException("Already Exiting");
			
		}
		else
		{
			isvalid=false;
		}
		return isvalid;
	}
	
	public boolean validatePan(String pan)
	{
		List<BankUserDetails> allBankUserDetails =b.getAllBankUserDetails();
	    boolean isValidate=false;
		String firsAlpha="";
		String num="";
		String lastAlp="";
		for(int i=0;i<pan.length();i++)
		{
			char ch=pan.charAt(i);
			if(i>=0 & i<=4 & ch>='A' & ch<='Z')
				firsAlpha=firsAlpha+ch;
			else if (i>=5 & i<=8 & ch>= '1' & ch<='9')
			{
				num=num+ch;
			}
			else
			{
				lastAlp=lastAlp+ch;
			}
		
			if(firsAlpha.length()==5 && lastAlp.length()==1 & num.length()==4)
			{
				if (allBankUserDetails == null || allBankUserDetails.isEmpty()) {
				     
			        return isValidate=true;
				}
				int panCount=0;
				for(BankUserDetails bankUserDetails : allBankUserDetails)
				{
					if(bankUserDetails.getPannumber().equals(pan))
					{
						panCount++;
					}
					if(panCount>0)
					{
						throw new BankUserException("Already Exiting");
					}
				}
			   
			    isValidate=true;
			}
			else
			    isValidate=false;
		}
		return isValidate;
	}
	
	public  boolean validateEmail(String s)
    {
		List<BankUserDetails> allBankUserDetails =b.getAllBankUserDetails();
        int count=0;
        boolean isValide=false;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='@')
            {
                count++;
            }
        }
        if(count==1)
        {
            String[] s1=s.split("@");
            String s2=s1[1];
            if(s2.contains("gmail.com"))
            {
            	if (allBankUserDetails == null || allBankUserDetails.isEmpty()) {
				     
			        return isValide=true;
				}
            	int emailCount=0;
				for(BankUserDetails bankUserDetails : allBankUserDetails)
				{
					if(bankUserDetails.getEmailid().equals(s))
					{
						emailCount++;
					}
					if(emailCount>0)
					{
						throw new BankUserException("Already Exiting");
					}
				}
                isValide=true;
            }
            else
            	isValide=false;
        }
		return isValide;
        
    }

	@Override
	public void userLogin() {
		System.out.println("Enter Yout EmailId or Account Number");
		String emailoraccountnumber = sc.next();
		System.out.println("Enter Your Pin");
		int pin=sc.nextInt();
		b.getUserDetailsByUsingEmailIdAndPin(emailoraccountnumber, pin);
		
	}

}
