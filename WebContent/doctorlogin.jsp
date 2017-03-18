<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Login</title>
<link rel="stylesheet" type="text/css" href="mystylesheet.css"/>
</head>
<body>
<div class="image"></div>
<br><button type="button" name="back" onclick="history.back()">Go Back</button><br><br>
<form action="dlogin" method="post">
<div class="fieldSet">
<fieldset>
<legend>Doctor's Login</legend>
<p><label class="field">Username: </label><input type="text" name="username" required="required"><br><br></p>
<p><label class="field">Password: </label><input type="password" name="password" required="required"><br><br></p>
<p><label class="submit"><input type="submit" value="Login"></label></p>
</fieldset>
</div>
</form>
<div id="footer">
<a id="geez" href="aboutus.jsp">About Us</a>&nbsp&nbsp<a id="geez" href="contactus.jsp">Contact Us</a>&nbsp&nbsp<a id="geez" href="privacypolicy.jsp">Privacy Policy</a>
<br><br>
Copyright © 2015 ShadowLord Technologies Private Limited. All rights reserved.
</div>
</body>
</html>