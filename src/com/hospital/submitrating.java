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
 * Servlet implementation class dregister
 */
@WebServlet("/submitrating")
public class submitrating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitrating() {
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
		Object str= request.getSession().getAttribute("username");
		String rating=request.getParameter("rating");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			Statement st=con.createStatement();
			ResultSet rs;
			int i=st.executeUpdate("update forum set rating='"+rating+"'where pname='"+str+"'");
			if(i>0)
			{
				out.println("Successfully submitted\n\n\n");
				RequestDispatcher rd=request.getRequestDispatcher("/ploginmenu.jsp");
				rd.include(request,response);
			}
			else
			{
				out.println("Submit Failed, Please try again.");
				RequestDispatcher rd=request.getRequestDispatcher("/pquerystatus.jsp");
				rd.include(request,response);
			}
			
			
		} catch (Exception e) {}
	}

}
