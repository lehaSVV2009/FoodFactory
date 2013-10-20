<%@ page import="java.util.List" %>
<%@ page import="com.kadet.foodFactory.entity.Product" %>
<%@ page import="com.kadet.foodFactory.controller.ShowController" %>
<%@ page import="com.kadet.foodFactory.entity.Recipe" %>
<%@page language="java" contentType="text/html; charset=utf-8" %>
<html>
<head>

</head>

<body>

Продукты и рецепты
<br>
<br>
<br>

<%List<Product> productsWithRecipes = (List<Product>) request.getAttribute(ShowController.PRODUCTS_PARAM);%>
<%for (Product product : productsWithRecipes) {%>

Имя продукта:
<br>
<i><%=product.getName()%></i>
<br>
<br>
Рецепты:
<table>
    <th>Название рецепта</th>
    <th>Описание рецепта</th>

    <%List<Recipe> recipes = product.getRecipes();%>
    <%for (Recipe recipe : recipes) { %>
    <tr>

        <td>
            <%=recipe.getName()%>
        </td>
        <td>
            <%=recipe.getDescription()%>
        </td>

    </tr>
    <%}%>
</table>

<%}%>
<br>

<form action="index.jsp" method="GET">
    <input type="submit" value="Main"/>
</form>

</body>
</html>