<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Basic Web Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body style="background-color: lightcyan";>
<aside class="categories">
    <ul>
        <li><a href="${pageContext.request.contextPath}/add">Dodaj przepis</a></li>
        <li><a href="${pageContext.request.contextPath}/updateOrInsert">Uaktualnij sposób przygotowania</a></li>
        <li><a href="${pageContext.request.contextPath}/delete">Usuń przepis</a></li>
    </ul>
</aside>
<br><h class="without">Info o przepisach:</h>
<c:forEach items="${requestScope.recipies}" var="recipe">
    <h2 class="without"><c:out value="${recipe.title}"/></h2><br>
    <p><c:out value="Czas przygotowania: ${recipe.preptime}"/></p><br>
    <p><c:out value="Składniki: ${recipe.ingredients}"/></p><br>
    <p><c:out value="Opis: ${recipe.desciption}"/></p><br>
    <p style="opacity: 40%">--------------------------------------------------------</p>
    <a href="${pageContext.request.contextPath.concat('/vote?recipeId=').concat(recipe.id).concat('&type=UP')}" class="discovery-link upvote">
        <i class="fas fa-arrow-alt-circle-up discovery-upvote" style="background-color: ghostwhite;padding: 7px 7px;"></i>
    </a>
    <p class="discovery-votes">
        <c:choose>
            <c:when test="${not empty requestScope.counter}">
                ${requestScope.counter}
            </c:when>
            <c:otherwise>
                ${recipe.counter}
            </c:otherwise>
        </c:choose>
    </p>
    <a href="${pageContext.request.contextPath.concat('/vote?recipeId=').concat(recipe.id).concat('&type=DOWN')}" class="discovery-link downvote">
        <i class="fas fa-arrow-alt-circle-down discovery-downvote" style="background-color: ghostwhite;padding: 7px 7px;"></i>
    </a>

</c:forEach>

</body>
</html>