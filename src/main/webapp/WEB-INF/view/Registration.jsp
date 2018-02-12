<%--
  Created by IntelliJ IDEA.
  User: Bobas
  Date: 2018-02-06
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>
<body>

<form:form action="registration" method="POST" modelAttribute="user">
<table>
    <tr>
        <td>User Name:</td>
        <td><form:input path="userName" /></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><form:input path="password" /></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><button type="submit">Submit</button></td>
    </tr>


</table>
</form:form>

</body>
</html>