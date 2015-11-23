<%@page import="data.UserAuthorization"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="user" class="model.User" scope="session">
</jsp:useBean>
<jsp:setProperty property="*" name="user"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	if (user==null || user.getUsername()==null || user.getUsername().trim().equals("")){
		out.write("ZALOGUJ SIĘ");
		
	}
	else {
		out.write("Login :"+user.getUsername());
		if (UserAuthorization.checkUser(user)){
			String site = new String("division.jsp");
			response.sendRedirect(site);
			//response.setStatus(response.SC_MOVED_TEMPORARILY);
			//response.setHeader("Location", site); 
			
			
		}
		else {
			out.write("ZŁE HASŁO LUB USERNAME");
		}
	}
%>

<form method="post" action="login.jsp">
Login : <input type="text" name="username"/></br>
Hasło : <input type="password" name="password"/></br>
<input type="submit" value="Login"/>
</form>
</body>
</html>