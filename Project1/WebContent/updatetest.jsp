<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
update test jsp par aaya
<form action="./StudentServlet1">
Update Id:<input type="number" name="id" 
value=<%=request.getAttribute("data1") %> > 
<br>

Update Name:<input type="text" name="name" 
value=<%=request.getAttribute("data2") %> >

<br>
Update Address:<input type="text" name="address" 
value=<%=request.getAttribute("data3") %> >

<br>
Update E-Mail:<input type="text" name="email" 
value=<%=request.getAttribute("data4") %> >

<br>
Update Qualification:<input type="text" name="qual" 
value=<%=request.getAttribute("data5") %> >
<br>
<input type="submit" name="a" value="proceed">

</form>
</body>
</html>