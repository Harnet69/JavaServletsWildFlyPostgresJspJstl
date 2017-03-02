<%@ page import="java.util.List" %>
<%@ page import="myBooks.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <title>I want to study JavaEE in EPAM</title>
</head>
<body>
<div style="width: 90%; margin: 0 auto">
    <h1>Site for<b>Java</b>!!</h1>
    <h2>My own server hosted in Amsterdam working on :</h2>
    <p>Operation system : <i>Ubuntu 16.04</i></p>
    <p>Java version : <i>Oracle JDK 8</i></p>
    <p>Server : <i>WildFly 10.0.0.Final. JBoss Enterprise Application Platform 7. Java EE7 Full & Web Distribution</i>
    </p>
    <p><i>This is simple example of realization bundles : SERVLET-JSP-JSTL. Without Spring, Hibernate and Maven</i></p>
    <h2>Showing books from my collection :</h2>
    <ul>
        <c:forEach items="${BookList}" var="book">
            <li>Id : ${book.id}, name : ${book.name}</li>
        </c:forEach>
    </ul>
    <%--<h2>Sign in</h2>
    <form action="welcome.jsp">
        <%
            String error = request.getParameter("error");
            if (error != null) {
                out.println(request.getParameter("error"));
            }
        %>
        <input type="text" name="uname" value='Enter your name' required
               onblur="if (this.value == '') {this.value = 'Enter your name';}"
               onfocus="if (this.value == 'Enter your name') {this.value = '';}">
        <input type="submit" value="Submit"><br/>
    </form>--%>
</div>
</body>
</html>