<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.Registration"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p><a href='' >HELLO</a>&nbsp;|&nbsp;<a href='goodbye' >GOODBYE</a></p>
<p><table>
<% List<Registration> regs=(List<Registration>)request.getAttribute("registrations"); 
   for(Registration reg: regs ) {
%>
<tr>
<td><%= reg.getFirst() %></td><td><%= reg.getLast() %>.</td>
</tr>
<% }%>
</table></p>
</body >
</html>