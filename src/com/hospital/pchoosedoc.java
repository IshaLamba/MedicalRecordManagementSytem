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
 * Servlet implementation class pchoosedoc
 */
@WebServlet("/pchoosedoc")
public class pchoosedoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pchoosedoc() {
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
		String dname=request.getParameter("dname");
		String query=request.getParameter("query");
		Object str= request.getSession().getAttribute("username");
		String resp="Waiting";
		String rating="Waiting";
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			Statement st=con.createStatement();
			ResultSet rs;
			int i=st.executeUpdate("insert into forum(dname,pname,query,response,rating)values('"+dname+"','"+str+"','"+query+"','"+resp+"','"+rating+"');");
			if(i>0)
			{
				out.println("Query has been succesfully sent to respected doctor.\n\n\n");
				RequestDispatcher rd=request.getRequestDispatcher("/ploginmenu.jsp");
				rd.include(request,response);
			}
			else
			{
				out.println("Query sending has failed, please try again later.");
				RequestDispatcher rd=request.getRequestDispatcher("/ploginmenu.jsp");
				rd.include(request,response);
			}
			
			
		} catch (Exception e) {}
	}

}
