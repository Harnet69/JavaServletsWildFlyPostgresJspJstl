<%@ page import="java.util.List" %>
<%@ page import="myBooks.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <style>
        table {
            border: 1px solid red;
            border-collapse: collapse;
        }

        table th, td {
            border: 1px solid green;
        }

        #main {
            width: 90%;
            margin: 0 auto;
            background: deepskyblue;
        }
    </style>
    <title>I want to study JavaEE</title>
</head>
<body>
<div id="main">
    <h1>Site for<b>JavaEE</b>!!</h1>
    <h2>My own server hosted in Amsterdam working on :</h2>
    <p>Operation system : <i>Ubuntu 16.04</i></p>
    <p>Java version : <i>Oracle JDK 8</i></p>
    <p>Server : <i>WildFly 10.0.0.Final. JBoss Enterprise Application Platform 7. Java EE7 Full & Web Distribution</i>
    </p>
    <p><i>This is simple example of realization bundles : SERVLET-JSP-JSTL. Without Spring, Hibernate and Maven</i></p>
    <h2>Showing books from my collection :</h2>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Author</th>
            <th>Year</th>
        </tr>
        <tr>
            <c:forEach items="${BookList}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.year}</td>
        <td><a href="updateBook?id=${book.id}">Изменить</a></td>
        </tr>
        </c:forEach>
        </tr>
    </table>

    <form action="${pageContext.request.contextPath}/getBooks" method="post">
        <label>Name</label> <input type="text" name="name" autofocus required>
        Author <input type="text" name="author" required>
        Year <input type="number" name="year" required>
        <input type="submit">
    </form>
</div>
</body>
</html>