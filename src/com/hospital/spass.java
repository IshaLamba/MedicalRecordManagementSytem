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

/**
 * Servlet implementation class dlogin
 */
@WebServlet("/spass")
public class spass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public spass() {
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
		String password=request.getParameter("password");
		PrintWriter out=response.getWriter();
		try {
			
			if(password.equals("1234"))
			{
				out.print("You can Proceed Successfully.");
				RequestDispatcher rd=request.getRequestDispatcher("/doctormenu.jsp");
				rd.include(request,response);
			}
			else
			{
				out.print("Sorry,Password is wrong.");
				RequestDispatcher rd=request.getRequestDispatcher("/staffpass.jsp");
				rd.include(request, response);
			}
			
		} catch (Exception e) {}
	}

}
