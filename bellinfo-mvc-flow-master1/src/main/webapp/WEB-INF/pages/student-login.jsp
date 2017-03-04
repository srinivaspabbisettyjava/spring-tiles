<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Login</title>
</head>
<body>
<center><h1>Student Information Page</h1></center>
 <div >
 
   
    <form:form action="${pageContext.request.contextPath}/student" method="post" modelAttribute="student">
       Student Name*: <form:input  path="name" placeholder="Please enter the name" /><br>
       <form:errors path="name" cssStyle="color:red"></form:errors><br>
       Course*: <select name="Course" id="singleCourse" >
				<option value="">SelectOption</option>
				<option value="java">Java</option>
				<option value="android">Android</option>
				<option value="AJS">Angular Java Script</option>
				<option value="MVC">Spring MVC</option>
			</select>
			<br>
			<form:errors path="course" cssStyle="color:red"></form:errors><br>
       Fee*: <input type="number" title="Please enter the Fee" placeholder="Please enter the Fee" name="Fee" /> <br>
        <form:errors path="fee" cssStyle="color:red"></form:errors><br>
     Year*: <input type="number"  title="Please enter the Year" placeholder="Please enter the Year" name="Year" path="year" /> <br>
       <div>
        <form:errors path="year" cssStyle="color:red"></form:errors><br>
       </div>
       <button type="submit"> Submit</button>    
    </form:form>
  
 </div>

</body>
</html>