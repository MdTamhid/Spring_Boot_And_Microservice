<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:red; text-align:Center">User Details</h1>

<c:choose>

<c:when test="${!empty userList}">


<table border="1" align="center" bgcolor="yellow">


<tr><th>id</th><th>name</th><th>dob</th><th>gender</th><th>mobile</th><th>address</th></tr>



<c:forEach var="user" items="${userList}">
<tr>

<td>${user.id}</td>
<td>${user.name}</td>
<td>${user.dob}</td>
<td>${user.gender}</td>
<td>${user.mobile}</td>
<td>${user.address}</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1 style="color:red; text-align:center">No Records found</h1>
</c:otherwise>
</c:choose>

<center><h1 style="color:maroon">${resultMsg}</h1></center>

<br><br>
<h1 style="text-align:center"><a href="register">Back to Registration</a></h1>



