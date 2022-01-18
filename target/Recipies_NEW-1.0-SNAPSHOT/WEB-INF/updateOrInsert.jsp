<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 04.01.2022
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Updating/Inserting</title>
    <meta charset="UTF-8">
</head>
<body>
<form action="" method="POST" style="margin: 30px auto; text-align: center; background-color: beige">
    <label style="margin-bottom: 40px" for="title">Wpisz przepis, którego nowy opis ma dotyczyć:</label>
    <input name="title" id="title" style="line-height: 28px; margin: 5px 0" required></input><br>
    <label style="margin-bottom: 40px" for="description">Wpisz nowy opis, w jaki sposób przygotować potrawę:</label>
    <textarea name="description" id="description" style="line-height: 28px; margin: 5px 0" required></textarea><br>
    <input type="submit" style="line-height: 28px; margin: 5px 0; background-color: coral">
</form>

</body>
</html>