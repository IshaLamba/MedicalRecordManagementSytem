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
 * Servlet implementation class pregister
 */
@WebServlet("/pregister")
public class pregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pregister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String contact=request.getParameter("contact");
		String department=request.getParameter("department");
		String email=request.getParameter("email");
		String link,temp,temp1,temp2;
		link="preg.jsp?temp="+email+"&temp1="+username+"&temp2="+password;
		System.out.println(link);
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			Statement st=con.createStatement();
			ResultSet rs;
			System.out.println("1");
			int i=st.executeUpdate("insert into patient(pname,password,sex,contact,department,email)values('"+username+"','"+password+"','"+sex+"','"+contact+"','"+department+"','"+email+"');");
			System.out.println("2");
			if(i>0)
			{	
					//link="preg.jsp?temp="+email+"&temp1="+username+"&temp2="+password;
					response.sendRedirect(link);
					//response.sendRedirect("patientlogin.jsp");
				
			}
			else
			{
				out.println("Registration Failed, Please try again.");
				RequestDispatcher rd=request.getRequestDispatcher("/patientregister.jsp");
				rd.include(request,response);
			}
			
			
		} catch (Exception e) {}
	
	}

}
