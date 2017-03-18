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
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class dlogin
 */
@WebServlet("/dlogin")
public class dlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dlogin() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String query="select * from doctor where dname='"+username+"' and password='"+password+"'";
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","root");
			Statement st=con.createStatement();
			ResultSet rs;
			rs=st.executeQuery(query);
			if(rs.next())
			{
				out.print("Succesfull");
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				Object str=session.getAttribute("username");
				out.print("<html><head>");
				out.print("<br>Session ID:"+str);
				out.print("</body></head></html>");
				RequestDispatcher rd=request.getRequestDispatcher("/dloginmenu.jsp");
				rd.include(request,response);
			}
			else
			{
				out.print("Sorry, Username/Password not found.");
				RequestDispatcher rd=request.getRequestDispatcher("/doctorlogin.jsp");
				rd.include(request, response);
			}
			
		} catch (Exception e) {}
	}

}
