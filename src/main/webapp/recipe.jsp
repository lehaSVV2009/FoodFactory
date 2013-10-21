<%@ page import="com.kadet.foodFactory.entity.Recipe" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kadet.foodFactory.dao.daoImpl.RecipeDaoImpl" %>
<%@ page import="com.kadet.foodFactory.controller.RecipeController" %>
<%@ page import="com.kadet.foodFactory.dao.daoImpl.ProductDaoImpl" %>
<%@ page import="com.kadet.foodFactory.dao.ProductDao" %>
<%@ page import="com.kadet.foodFactory.entity.Product" %>
<%@page language="java" contentType="text/html; charset=utf-8" %>
<html>
<head>

</head>

<body>

<h2>Операции с рецептами</h2>
<br>
<br>

<%List<Recipe> recipes = new RecipeDaoImpl().findAll();%>


<%Integer succeed = (Integer) request.getAttribute(RecipeController.SUCCEED);%>
<%if (succeed != null) {%>
<%if (succeed != -1) {%>
<br>
Операция выполнена успешно
<br>
<%} else {%>
<br>
Извините, произошла ошибка. Попробуйте снова!
<br>
<%}%>
<%}%>

<form action="/addRecipe" method="POST">
    <br>
    Введите название рецепта:
    <br>
    <input type="text" name="addRecipe.recipeName">
    <br>
    Описание:
    <br>
    <input type="text" name="addRecipe.recipeDescription">
    <br>
    <%
        ProductDao productDao = new ProductDaoImpl();
        List<Product> products = productDao.findAll();
    %>
    Выберите продукт, для которого будет создан рецепт:
    <br>
    <select name="addRecipe.productId">
        <%
            for (Product product : products) {
        %>
        <option value="<%=product.getIdProduct()%>">
            <%=product.getName()%>
        </option>
        <%
            }
        %>
    </select>

    <br>
    <input type="submit" value="Добавить рецепт"/>
</form>

<br>
<br>

<form action="/removeRecipe" method="POST">

    Выберите рецепт для удаления
    <br>
    <select name="removeRecipe.recipeId">
        <%for (Recipe recipe : recipes) { %>
        <option value="<%=recipe.getIdRecipe()%>">
            <%=recipe.getIdRecipe()%>) <%=recipe.getName()%>
        </option>
        <%}%>
    </select>
    <br>
    <input type="submit" value="Удалить рецепт"/>
</form>

<br>
<br>


<form action="/updateRecipe" method="POST">

    Выберите рецепта для изменения данных
    <br>
    <select name="updateRecipe.recipeId">
        <%for (Recipe recipe : recipes) { %>
        <option value="<%=recipe.getIdRecipe()%>">
            <%=recipe.getIdRecipe()%>) <%=recipe.getName()%>
        </option>
        <%}%>
    </select>
    <br>
    Изменить имя:
    <br>
    <input type="text" name="updateRecipe.recipeName">
    <br>
    Изменить описание:
    <br>
    <input type="text" name="updateRecipe.recipeDescription">
    <br>
    <input type="submit" value="Изменить"/>
</form>


<table border="black">

    <th>idRecipe</th>
    <th>Product_id</th>
    <th>number</th>
    <th>name</th>
    <th>description</th>

    <%for (Recipe recipe : recipes) { %>
    <tr>
        <td>
            <%=recipe.getIdRecipe()%>
        </td>
        <td>
            <%=recipe.getProduct_id()%>
        </td>
        <td>
            <%=recipe.getNumber()%>
        </td>
        <td>
            <%=recipe.getName()%>
        </td>
        <td>
            <%=recipe.getDescription()%>
        </td>

    </tr>
    <%}%>

</table>


<br>
<br>


<form action="index.jsp" method="GET">
    <input type="submit" value="Main"/>
</form>


</body>
</html>