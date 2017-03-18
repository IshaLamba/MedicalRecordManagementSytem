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
@WebServlet("/alogin")
public class alogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alogin() {
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
		PrintWriter out=response.getWriter();
		try {
			
			if(password.equals("123")&&(username.equals("admin")))
			{
				out.print("Succesfull");
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				Object str=session.getAttribute("username");
				out.print("<html><head>");
				out.print("<br>Session ID:"+str);
				out.print("</body></head></html>");
				RequestDispatcher rd=request.getRequestDispatcher("/aloginmenu.jsp");
				rd.include(request,response);
			}
			else
			{
				out.print("Sorry, Username/Password not found.");
				RequestDispatcher rd=request.getRequestDispatcher("/adminlogin.jsp");
				rd.include(request, response);
			}
			
		} catch (Exception e) {}
	}

}
