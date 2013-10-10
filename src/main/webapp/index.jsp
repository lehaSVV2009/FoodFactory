<%@page language="java" contentType="text/html; ISO-8859-1" %>
<html>
<head>

</head>

<body>

    Main
    <br>

    <form action="/showDishesRecipes" method="GET">
        <input type="submit" value="Show Dishes and Recipes"/>
    </form>

    <form action="/showMostLowCalorieDish" method="GET">
        <input type="submit" value="Show Most Low-Caorie Dish"/>
    </form>

    <form action="/showPriceList" method="GET">
        <input type="date" name="price_list.date" value="2013-10-11"/>
        <input type="submit" value="Show Price List"/>
    </form>

    <form action="product.jsp" method="GET">
        <input type="submit" value="Operations With Products"/>
    </form>

    <form action="provider.jsp" method="GET">
        <input type="submit" value="Operations With Providers"/>
    </form>

    <form action="recipe.jsp" method="GET">
        <input type="submit" value="Operations With Recipes"/>
    </form>

</body>
</html>