<%@ page isELIgnored="false"%>

<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="frm"%> --%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>


<h1 style="color:red; text-align:center">Employee Regitration Page</h1>

<frm:form modelAttribute="emp">

<table align="center" bgcolor="cyan">

<%--  <tr> 
<td> Employee Number</td>
<td> <frm:input path="empno"/></td>
</tr> --%>

<tr> 
<td> Employee Name</td>
<td> <frm:input path="empName"/></td>
</tr>

<tr> 
<td> Employee Job</td>
<td> <frm:input path="job"/></td>
</tr>

<tr> 
<td> Employee Salary</td>
<td> <frm:input path="sal"/></td>
</tr>

<tr> 
<td> Employee Department</td>
<td> <frm:input path="departNo"/></td>
</tr>

<tr> 
<td> <input type="submit" value="register"/></td>
<td> <input type="reset" value="cancle"/></td>
</tr>

</table>
<h1 style="text-align:center"><a href="report">Back to report</a></h1>
</frm:form>