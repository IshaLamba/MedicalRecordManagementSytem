package com.hospital;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class 
 */
@WebServlet("/pchoosetime")
public class pchoosetime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pchoosetime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		Object str=request.getSession().getAttribute("username");
		String username=request.getParameter("dname");
		String str1=request.getParameter("time");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			Statement st=con.createStatement();
			ResultSet rs;
			System.out.println("1");
			int i=st.executeUpdate("insert into appointment(pname,dname,time)values('"+str+"','"+username+"','"+str1+"');");
			System.out.println("2");
			if(i>0)
			{	
				out.println("Appointment successfully taken....");
				RequestDispatcher rd=request.getRequestDispatcher("/ploginmenu.jsp");
				rd.include(request,response);
				
			}
			else
			{
				out.println("Appointment failed....");
				RequestDispatcher rd=request.getRequestDispatcher("/appointment.jsp");
				rd.include(request,response);
			}
			
			
		} catch (Exception e) {}
	
	}

}
