package com.learn.upi.payment;

import java.util.*;

public class MainMethod {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter which application you want to use");
		String app=sc.next();
		
		System.out.println("Enter name you want to send amount");
		String name=sc.next();
		
		 if (!name.matches("[a-zA-Z]+")) {
	            System.out.println(" Invalid name. Only letters are allowed.");
	            return;
		 }
		System.out.println("Enter the amount you want to send");
		int a=sc.nextInt();
	
		UPI upi=UPIFactory.getApp(app);
		upi.makePayment(a,name);
		upi.viewBalance();
		upi.viewHistory();
		
		if(upi instanceof GooglePay)
		{
			((GooglePay)upi).ticketBooking();
		}
		else if(upi instanceof PhonePay)
		{
			((PhonePay)upi).recharge();
		}
		else if(upi instanceof Paytm)
		{
			((Paytm)upi).MutualFunds();
		}

	}


}
