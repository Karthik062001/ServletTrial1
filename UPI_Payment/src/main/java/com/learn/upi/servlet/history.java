package com.learn.upi.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import com.learn.upi.payment.DataConnect;

/**
 * Servlet implementation class history
 */
public class history extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public history() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    try {
	        ResultSet rs = DataConnect.getTransactionHistory();
	        out.println("<h2>Transaction History</h2>");
	        out.println("<table border='1'>");
	        out.println("<tr><th>ID</th><th>Receiver</th><th>Amount</th><th>Balance</th></tr>");

	        while (rs.next()) {
	            out.println("<tr>");
	            out.println("<td>" + rs.getInt("id") + "</td>");
	            out.println("<td>" + rs.getString("reciever_name") + "</td>");
	            out.println("<td>₹" + rs.getInt("Amount_sent") + "</td>");
	            out.println("<td>₹" + rs.getInt("balance") + "</td>");
	            out.println("</tr>");
	        }

	        out.println("</table>");
	    } catch (Exception e) {
	        e.printStackTrace();
	        out.println("<h3>Error fetching transaction history.</h3>");
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
