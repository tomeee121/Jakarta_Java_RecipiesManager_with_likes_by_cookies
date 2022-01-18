<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 03.01.2022
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Deleting</title>
  <meta charset="UTF-8">
</head>
<body>
<form action="" method="POST" style="margin: 30px auto; text-align: center; background-color: beige">
  <label style="margin-bottom: 40px" for="title">Wpisz tytuł przepisu który chcesz usunąć z bazy:</label>
  <input name="title" id="title" style="line-height: 28px; margin: 5px 0" required><br>
  <input type="submit" style="line-height: 28px; margin: 5px 0; background-color: coral">
</form>

</body>
</html>
