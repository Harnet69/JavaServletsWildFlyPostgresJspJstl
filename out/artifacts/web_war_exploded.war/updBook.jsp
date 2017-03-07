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
    <title>Update item</title>
</head>
<body>
<h1>Update item</h1>
<c:forEach items="${BookList}" var="book">
    <form action="${pageContext.request.contextPath}/getBooks" method="post">
        <label>Name</label><input type="text" name="name" value="${book.name}" autofocus required>
        <label>Author</label><input type="text" name="author" value="${book.author}" required>
        <label>Year</label><input type="number" name="year" value="${book.year}" required>
        <input type="submit">
    </form>
</c:forEach>
</body>
</html>