package com.learn.trial1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Trial1
 */
public class Trial1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Trial1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 PrintWriter pw=response.getWriter();
		 
		    String name = request.getParameter("name");
		    String acNumberParam = request.getParameter("ACnumber");
		    String Address = request.getParameter("Address");
		    String type = request.getParameter("type");
		    String balanceParam = request.getParameter("balance");

		    int ACnumber = 0;
		    int balance = 0;

		    if (acNumberParam == null || acNumberParam.isEmpty()) {
		        pw.println("Invalid Account Number<br>");
		        return;
		    }
		    if (balanceParam == null || balanceParam.isEmpty()) {
		        pw.println("Invalid Balance<br>");
		        return;
		    }

		    try {
		        ACnumber = Integer.parseInt(acNumberParam);
		        balance = Integer.parseInt(balanceParam);
		    } catch (NumberFormatException e) {
		        pw.println("Invalid number format!<br>");
		        return;
		    }
	   
		BankApp al=new BankApp();
	     al.insert(name, ACnumber, Address, type, balance);
	     response.setContentType("text/html");
	     
	    
	     pw.println("<h2>Accountcreated Succesfully! </h2>");
	     pw.println("<p>Account Holder name</p>"+name);
	     pw.println("<p>Account Number</p>"+ACnumber);
	     pw.println("<p>Address </p>"+Address);
	     pw.println("<p>Type of Account </p>"+type);
	     pw.println("<p>Balance</p>"+balance);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
