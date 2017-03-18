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
@WebServlet("/submitresponse")
public class submitresponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitresponse() {
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
		String sname=request.getParameter("sname");
		String respons=request.getParameter("respons");
		String rating="Waiting";
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			Statement st=con.createStatement();
			ResultSet rs;
			int i=st.executeUpdate("update forum set response='"+respons+"'where pname='"+sname+"'");
			if(i>0)
			{
				out.println("Response is successfully recorded.\n\n\n");
				RequestDispatcher rd=request.getRequestDispatcher("/dloginmenu.jsp");
				rd.include(request,response);
			}
			else
			{
				out.println("Re-enter the response.\n\n");
				RequestDispatcher rd=request.getRequestDispatcher("/showquery.jsp");
				rd.include(request,response);
			}
			
			
		} catch (Exception e) {}
	}

}
