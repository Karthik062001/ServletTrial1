package com.learn.upi.payment;


public abstract class UPIabstract implements UPI{

protected int balance=40000;
	

    public void makePayment( int amount, String RecieverName) 
    {
	   if(amount<=balance)
	   {
          balance = balance-amount;
          DataConnect.transaction(RecieverName, amount, balance);
          System.out.println(" Payment of  "+amount+"  to  "+RecieverName);
          DataConnect.transaction(RecieverName, amount, balance);
	    }
	    else
	    {
		   System.out.println("Insufficient Balance");
	    }
    }
    public void viewHistory()
    {
         DataConnect.getTransactionHistory();
     }

      public void viewBalance(int amount)
      {
   	     if(amount<=balance)
   	      {
   	         balance=balance-amount;
   	      }
      }

}
