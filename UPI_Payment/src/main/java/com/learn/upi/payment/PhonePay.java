package com.learn.upi.payment;

public class PhonePay extends UPIabstract{
	

	@Override
	public void makePayment(int amount,String name) {
		super.makePayment(amount,name);
		
	}

	@Override
	public void viewBalance() {
		super.viewBalance(balance);
		System.out.println("Showing balance using PhonePay"+balance);
		
	}
	  public void recharge() 
	    {
	        System.out.println("PhonePay: Mobile recharge done");
	    }



}
