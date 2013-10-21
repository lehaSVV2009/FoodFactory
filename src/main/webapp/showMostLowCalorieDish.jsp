<%@ page import="com.kadet.foodFactory.entity.Product" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.kadet.foodFactory.controller.ShowController" %>
<%@page language="java" contentType="text/html; charset=utf-8" %>
<html>
<head>

</head>

<body>

<h2>Список самых низко-калорийных продуктов</h2>
<br>
<br>
<br>

<%Map<Product, Integer> map = (Map<Product, Integer>) request.getAttribute(ShowController.MOST_LOW_CALORIE_PRODUCTS);%>

<table>
    <th>Название рецепта</th>
    <th>Калорийность</th>

    <%for (Product product: map.keySet()) { %>
    <tr>

        <td>
            <%=product.getName()%>
        </td>
        <td>
            <%=map.get(product)%>
        </td>

    </tr>
    <%}%>
</table>

<br>

<form action="index.jsp" method="GET">
    <input type="submit" value="Main"/>
</form>

</body>
</html>