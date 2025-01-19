package com.Bank;

import java.util.Scanner;

import com.Bank.Services.AdminService;
import com.Bank.Services.AdminSevericeImp;
import com.Bank.Services.BankServiceImp;
import com.Bank.Services.BankServices;
public class App 
{
    public static void main( String[] args )
    {	
    	BankServices bs=new BankServiceImp();
    	AdminService as=new AdminSevericeImp();
    	Scanner sc=new Scanner(System.in);
    	bs.forSleep("***** welcome*******");
    	System.out.println();
    	System.out.println("1.for create a account");
		System.out.println("2.user login");
		System.out.println("3.admin login");
		
		switch(sc.nextInt())
		{
			case 1:
			{
				bs.forSleep("*******Register for bank*********");
				bs.registeration();
				break;
			}
			case 2:
			{
				bs.forSleep("*****Use login******");
				bs.userLogin();
				break;
			}
			case 3:
			{
				bs.forSleep("******admin Login******");
				as.adminLogin();
				break;
			}
			default:
				System.out.println("Invalid opotion");
		}
    	boolean  loop=true;
    	while(loop)
    	{
    		System.out.println("Do you want to Contiuse ");
    		System.out.println("Yes");
    		System.out.println("No");
    		
    		switch(sc.next())
    		{
    		case "Yes":
    		{
    			boolean inloop=true;
    			while(inloop)
    			{

    		    	System.out.println("1.for create a account");
    				System.out.println("2.user login");
    				System.out.println("3.admin login");
	    			switch(sc.nextInt())
	    			{
	    				case 1:
	    				{
	    					bs.forSleep("******User Register for bank*******");
	    					bs.registeration();
	    					inloop=false;
	    					break;
	    				}
	    				case 2:
	    				{
	    					bs.forSleep("*******Use login*******");
	    					bs.userLogin();
	    					inloop=false;
	    					break;
	    				}
	    				case 3:
	    				{
	    					bs.forSleep("*******admin Login*******");
	    					as.adminLogin();
	    					inloop=false;
	    					break;
	    				}
	    				default:
	    					System.out.println("Invalid opotion");
	    			}
    			}
    			break;
    		}
    		case "No":
    		{
    			bs.forSleep("*****Thank You Visit Again*****");
    			loop=false;
    			break;
    		}
    		default:
    			System.out.println("Invalid option");
    		}
    		
    	}
    }
}
