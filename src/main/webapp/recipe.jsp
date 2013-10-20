<%@page language="java" contentType="text/html; charset=utf-8" %>
<html>
<head>

</head>

<body>

    Recipe
    <br>

    <form action="/addRecipe" method="POST">
        <input type="submit" value="Add Recipe"/>
    </form>

    <form action="/getRecipe" method="GET">
        <input type="submit" value="Get Recipe"/>
    </form>

    <form action="/removeRecipe" method="POST">
        <input type="submit" value="Remove Recipe"/>
    </form>

    <form action="/updateRecipe" method="POST">
        <input type="submit" value="Update Recipe"/>
    </form>

    <form action="index.jsp" method="GET">
        <input type="submit" value="Main"/>
    </form>



</body>
</html>