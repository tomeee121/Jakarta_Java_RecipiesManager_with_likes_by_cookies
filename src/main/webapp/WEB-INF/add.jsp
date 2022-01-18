<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 03.01.2022
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="pl">
<head>
    <title>Adding</title>
    <meta charset="UTF-8">
</head>
<body>
<form action="" method="POST" style="margin: 30px auto; text-align: center; background-color: beige">
    <label style="margin-bottom: 40px" for="title">Wpisz tytuł przepisu:</label>
    <input name="title" id="title" style="line-height: 28px; margin: 5px 0" required><br>
    <label for="preptime">Wpisz czas przygotowania w minutach:</label>
    <input name="preptime" id="preptime" type="number" style="line-height: 28px; margin: 5px 0" required><br>
    <label for="ingredients">Wpisz składniki:</label>
    <input name="ingredients" id="ingredients" style="line-height: 28px; margin: 5px 0" required><br>
    <label for="description">Wpisz opis przygotowania:</label><br>
    <textarea name="description" id="description" rows="4" cols="50" placeholder="Wpisz opis: "></textarea><br>
    <input type="submit" style="line-height: 28px; margin: 5px 0; background-color: coral">
</form>

</body>
</html>
