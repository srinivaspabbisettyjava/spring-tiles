<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<body>

  <%
            String name ="";
            String course ="";
            String fee ="";
            String year ="";
            String curDate="";
        
          name = request.getAttribute("NameRet").toString();
          course = request.getAttribute("CourseRet").toString();
          fee = request.getAttribute("FreRet").toString();
          year = request.getAttribute("YearRet").toString();
          curDate = request.getAttribute("CurDateRet").toString();       
            %>
    <table border=5>
    <tr>
    <td>Name</td><td>Course</td> <td>Fee</td><td>Year</td> <td>RegistrationDate</td>
    </tr>
    
    <tr>
    <td><% out.println(name);%></td>
    <td><%out.println(course); %></td>
    <td><%out.println(fee); %></td>
    <td><%out.println(year); %></td>
    <td><%out.println(curDate); %></td>
    </tr>
    
    </table>
</body>
</html>