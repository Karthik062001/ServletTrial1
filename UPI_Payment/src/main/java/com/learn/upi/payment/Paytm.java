package com.learn.upi.payment;

public class Paytm extends UPIabstract{

	@Override
	public void makePayment(int amount,String name) {
		super.makePayment(amount,name);
		
	}

	@Override
	public void viewBalance() {
		super.viewBalance(balance);
		System.out.println("Showing balance using Paytm"+balance);
		
	}
	   public void MutualFunds() 
	    {
	        System.out.println("Paytm: Mutual Funds available");
	    }


}
