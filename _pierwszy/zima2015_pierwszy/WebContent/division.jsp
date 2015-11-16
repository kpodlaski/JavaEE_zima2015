<%@page import="model.Division"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="data" scope="application" class="data.CompanyData"></jsp:useBean>
<jsp:useBean id="act_div" scope="request" class="model.Division"></jsp:useBean>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
	String id = request.getParameter("id");
	model.Division temp;
	if (id==null || id.equals("")){
		temp = data.getMainDivision();
	}
	else {
		temp = data.getDivisions().get(  
					Integer.parseInt( id ));
	}
	act_div.setChildDivisons(temp.getChildDivisons());
	act_div.setMembers(temp.getMembers());
	act_div.setHead(temp.getHead());
	act_div.setName(temp.getName());
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
th {
	color: blue;
	font-style: italic;
	font-size: 30px;	
}

td.name {
	color: black;
	font-style:normal;
	font-weight:bold;
	font-size:15px;
}

td.value {
	color: black;
	font-style:normal;
	font-size:15px;
}

</style>
<body>

<table>
<tr>
	<th colspan="2">
		${act_div.name} 
	</th>
</tr>
<tr>
	<td class="name">${act_div.head.role.name}:</td>
	<td class="value">${act_div.head.name} ${act_div.head.surname}</td>
</tr>
<tr>
</tr>
<tr>
	<td colspan="2" class="name">
		Members:
	</td>
</tr>
<c:forEach items="${act_div.members}" var="mem"> 
<tr>
	<td class="name">${mem.role.name}:</td>
	<td class="value">${mem.name} ${mem.surname}</td>
</tr>
</c:forEach>
<tr>
	<td colspan="2" class="name">
		Divisions:
	</td>
</tr>
<c:forEach items="${act_div.childDivisons}" var="division"> 
<tr>
	<td class="name">Subdivision Name:</td>
	<td class="value"><a href="division.jsp?id=${division.id}" >${division.name}</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>