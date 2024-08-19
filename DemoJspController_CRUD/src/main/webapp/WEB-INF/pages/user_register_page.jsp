<%@ page isELIgnored="false"%>

<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="frm"%> --%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<head>
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .form-container {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-container h2 {
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input, .form-group select, .form-group textarea {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #218838;
        }
    </style>
</head>

<body>

<div class="form-container">

    <h2>Registration Form</h2>
    <font color="green">${succ}</font>
    <font color="red">${failed}</font>
    <form:form action="save" method="post" modelAttribute="emp" >
        <div class="form-group">
            <label for="name">Name:</label>
            
           <form:input path="name"/> 
            <form:errors path="name" style="color:red;"></form:errors>
        </div>
        <div class="form-group">
            <label for="dob">Date of Birth:</label>
            <form:input type="date" id="dob" path="dob"/>
        </div>
        <div class="form-group">
            <label for="address">Address:</label>
            <form:textarea id="address" path="address" rows="3"/>
        </div>
        <div class="form-group">
            <label for="mobile">Mobile:</label>
            <form:input type="text" id="mobile" path="mobile"/>
        </div>
        <div class="form-group">
            <label for="gender">Gender:</label>
            <form:select id="gender" path="gender">
                <form:option value="">Select</form:option>
                <form:option value="male">Male</form:option>
                <form:option value="female">Female</form:option>
                <form:option value="other">Other</form:option>
            </form:select>
        </div>
        <div class="form-group">
            <form:button type="submit">Submit</form:button>
        </div>
    </form:form>
    <a href="report">view page</a>
</div>

</body>

