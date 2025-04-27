package com.learn.upi.payment;

public class UPIFactory {

	public static UPI getApp(String type)
	{
		if(type.equalsIgnoreCase("GooglePay"))
		{
			return new GooglePay();
		}
			else if(type.equalsIgnoreCase("paytm"))
			{
				return new Paytm();
			}
			else if(type.equalsIgnoreCase("PhonePay"))
			{
				return new PhonePay();
			}
			else
			{
				return null;
			}
		
	}	

}
