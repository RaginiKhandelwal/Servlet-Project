<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
     String chk = (String)request.getAttribute("check");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
 
if(chk.equals("ins"))
{
	out.println(request.getAttribute("insert"));
	 
}

if(chk.equals("del"))
{
	out.println(request.getAttribute("delete"));
}

if(chk.equals("sel"))
{
	String[] s= new String[5];
	s =(String[])request.getAttribute("select");
	out.println("Id:"+s[0]+"<br>");
	out.println("Name:"+s[1]+"<br>");
	out.println("Address:"+s[2]+"<br>");
	out.println("Email:"+s[3]+"<br>");
	out.println("qualification:"+s[4]);
	
}
if(chk.equals("upd"))
{
	out.println(request.getAttribute("update"));
}

%>
<br><br>
<a href="Form1.html">Home</a>

</body>
</html>