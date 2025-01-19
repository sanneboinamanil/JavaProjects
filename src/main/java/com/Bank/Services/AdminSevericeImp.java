package com.Bank.Services;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.Bank.Exception.AdminException;
import com.BankUserDetails.BankUserDetails;
import com.DAo.AdminDAO;
import com.DAo.AdminDAOImp;
import com.DAo.BankDAO;
import com.DAo.BankUserDAOImp;

public class AdminSevericeImp implements AdminService {

	Scanner sc= new Scanner(System.in);
	AdminDAO ad=new AdminDAOImp();
	BankDAO bd=new BankUserDAOImp();
	@Override
	public void adminLogin() {
		boolean status = true;
		while(status)
		{
			System.out.println("enter the Admin EmailId: ");
			String email=sc.next();
			System.out.println("Enter the Password: ");
			String pass=sc.next();
			
			try {
				
				
				if(ad.getAdminDetailByUsingEmailidAndPassword(email, pass))
				{
					status=false;
					System.out.println("Enter \n1.To Get All User Details \n2.To Get ALl Request Details");
					switch(sc.nextInt())
					{
					case 1:
						System.out.println("fetching the all user Details");
						break;
					case 2:
						System.out.println("fetching all Requestes accounts");
						allAccountRequestDetailslist();
						break;
					default:
						System.out.println("Invalid option");
					}
				}
				else
				{
					throw new AdminException("invalid admin");
				}
			}
			catch(AdminException e)
			{
				System.out.println(e.getMsg());
			}
		}
		
	}
	int count=1;
	@Override
	public void allAccountRequestDetailslist() {
		List<BankUserDetails> getAllBankUerDetails = bd.getAllBankUserDetails();
		
		List<BankUserDetails> list=
		getAllBankUerDetails.stream().filter(user->user.getStatus().equalsIgnoreCase("Pending")).collect(Collectors.toList());
		list.forEach((user)->{
			System.out.println("s.no : "+count++);
			System.out.println("User Name: "+user.getName());
			System.out.println("User moblie Number: "+user.getMobilenumber());
			System.out.println("User Aadhar Number "+ user.getAadharnumber());
			System.out.println("User Status : "+user.getStatus());
		});
		boolean status=true;
		while(true)
		{
		System.out.println("Entet S.no to Select The User: ");
		BankUserDetails bankUserDetails = list.get(sc.nextInt()-1);
		System.out.println(bankUserDetails);
		
		System.out.println("Enter \n1.To Accept \n2.TO Reject");
		
		switch (sc.nextInt()) {
		case 1:
			System.out.println("Accpted");
			acceptRequest(bankUserDetails.getAadharnumber());
			
			break;
		case 2:
			System.out.println("Rejected");
			int result=bd.deleteRejectedUserByAadharNum(bankUserDetails.getAadharnumber());
			if(result!=0)
			{
				System.out.println("data deleted");
			}
		default:
			break;
		}
		}
		
		
	}
	@Override
	public void acceptRequest(long aadharnumber) {
		Random random=new Random();
		int pin=random.nextInt(10000);
		if(pin<1000)
			pin+=1000;
		int accountnumber=random.nextInt(10000000);
		if(accountnumber<1000000)
			accountnumber+=1000000;
		
		int update =bd.updatePinAndAccountNumAndStatus(pin, accountnumber, aadharnumber);
		if(update!=0)
		{
			System.out.println("Accepted");
			System.out.println("Account NUmber: "+accountnumber);
			System.out.println("pin : "+pin);
		}
		else
		{
			System.out.println("Server 404");
		}
		
	}
	
	

}
