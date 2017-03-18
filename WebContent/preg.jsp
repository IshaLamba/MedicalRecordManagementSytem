<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="mystylesheet.css"/>
</head>
<body>
<br><button type="button" name="back" onclick="history.back()">Go Back</button><br><br>
<%
Properties properties= System.getProperties();
properties.put("mail.smtp.host","smtp.gmail.com");
properties.put("mail.smtp.socketFactory.port","465");
properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
properties.put("mail.smtp.auth","true");
properties.put("mail.smtp.port","465");
String str=request.getParameter("temp");
String str1=request.getParameter("temp1");
String str2=request.getParameter("temp2");
System.out.println(str);
System.out.println(str1);
System.out.println(str2);
String mail="Your username is: '"+str1+"' and password is: '"+str2+"'";
try
{
	Session ses=Session.getInstance(properties,new javax.mail.Authenticator(){
		protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication("shadowlordcorp@gmail.com","9643063858");
		}});
	Message message=new MimeMessage(ses);
	message.setFrom(new InternetAddress("shadowlordcorp@gmail.com"));
	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(str));
	message.setSubject("Thanks for registering with ShadowLord Corp. ");
	message.setText(mail);
	Transport.send(message);
}catch(Exception e){e.printStackTrace();}
%>
<%
	PrintWriter p=response.getWriter();
	RequestDispatcher rd=request.getRequestDispatcher("/patientlogin.jsp");
	rd.include(request,response);
	p.println("\n\n\nRegistration Succesfull, An email has been sent to your email address regarding your account details");
%>
</body>
</html>