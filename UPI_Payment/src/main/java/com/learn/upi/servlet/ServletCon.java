package com.learn.upi.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.learn.upi.payment.GooglePay;
import com.learn.upi.payment.Paytm;
import com.learn.upi.payment.PhonePay;
import com.learn.upi.payment.UPI;
import com.learn.upi.payment.UPIFactory;

/**
 * Servlet implementation class ServletCon
 */
public class ServletCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCon() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String app=request.getParameter("app");
		String name=request.getParameter("name");
		String amountStr = request.getParameter("amount");
		 
		 response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		 
		 if (!name.matches("[a-zA-Z]+")) {
	            System.out.println(" Invalid name. Only letters are allowed.");
	            return;
		 }
	       
		 int amount = Integer.parseInt(amountStr);
		 
		 UPI upi = UPIFactory.getApp(app);

	        if (upi == null) {
	            pw.println("<h3>Invalid UPI Application Selected</h3>");
	            return;
	        }
	        
	        upi.makePayment(amount, name);
	        upi.viewBalance();
	        upi.viewHistory();

	        
	        if (upi instanceof GooglePay) {
	            ((GooglePay) upi).ticketBooking();
	        } else if (upi instanceof PhonePay) {
	            ((PhonePay) upi).recharge();
	        } else if (upi instanceof Paytm) {
	            ((Paytm) upi).MutualFunds();
	        }

	        // Success message
	        pw.println("<h2>✅ Payment done Successfully!</h2>");
	        pw.println("<a href='index.jsp'>Make another payment</a>");
	        
	        
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
