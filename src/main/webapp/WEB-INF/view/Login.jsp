<%--
  Created by IntelliJ IDEA.
  User: Bobas
  Date: 2018-02-06
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div id="container" style="
        background-color: cornflowerblue;
        height: 100%">


    <div align="center" style="padding-top: 100px">
        <form:form action="/app/MembersArea" method="get" modelAttribute="user">
            <table>
                <tr>
                    <td colspan="2" align="center"><h2>Login</h2></td>
                </tr>
                <tr>
                    <td>UserName:</td>
                    <td><form:input path="userName"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password"/></td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <input type="submit" value="Login"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>


    <div align="center" style="padding-top: 100px">
        <form:form action="/app/Register" method="get">
            <table>
                <tr >
                    <td colspan="2" align="center"><h2>Register</h2></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Register"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>