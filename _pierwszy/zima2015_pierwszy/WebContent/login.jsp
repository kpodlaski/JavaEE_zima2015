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
<script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/sha256.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script>

$( document ).ready(function() {

	$( "form" ).submit(function( event ) {
		  var pass = $('#passwd').val();
		  var token = $('#token').val();
		  var hash = CryptoJS.SHA256(pass+":"+token);
		  $('#passwd').val(hash);
		});
	});	
	

</script>
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

<form id="loginForm" method="post" action="login.jsp">
<input type="hidden" name="token" id="token" value="<%="token_value"%>"/>
Login : <input type="text" name="username"/></br>
Hasło : <input id="passwd" type="password" name="password"/></br>
<input type="submit" value="Login"/>
</form>
</body>
</html>