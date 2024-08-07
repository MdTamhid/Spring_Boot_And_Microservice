<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:red; text-align:Center">Report Page</h1>

<c:choose>

<c:when test="${!empty empList}">


<table border="1" align="center" bgcolor="yellow">


<tr><th>emono</th><th>empname</th><th>empjob</th><th>empsal</th><th>empdepart</th><th>opetations</th></tr>



<c:forEach var="emp" items="${empList}">
<tr>

<td>${emp.empno}</td>
<td>${emp.empName}</td>
<td>${emp.job}</td>
<td>${emp.sal}</td>
<td>${emp.departNo}</td>
<td> <a href="edit?id=${emp.empno}"> <img src="images/edit.jpg" width="25px" height="25px"></a>
&nbsp;&nbsp;
<a href="delete?id=${emp.empno}" onclick="return confirm('Are you sure to delete employee')"> <img src="images/delete.jpg" width="25px" height="25px"></a>
</td>


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

<h1 style="text-align:center"><a href="./">home<img src="images/home.jpg" width="80px"height="80px"/></a></h1>
<br><br>
<h1 style="text-align:center"><a href="register">Register Employee<img src="images/add.jpg" width="80px"height="80px"/></a></h1>



