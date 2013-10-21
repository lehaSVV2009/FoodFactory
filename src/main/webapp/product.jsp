<%@ page import="com.kadet.foodFactory.dao.ProductGroupDao" %>
<%@ page import="com.kadet.foodFactory.dao.daoImpl.ProductGroupDaoImpl" %>
<%@ page import="com.kadet.foodFactory.entity.ProductGroup" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kadet.foodFactory.controller.ProductController" %>
<%@ page import="com.kadet.foodFactory.entity.Product" %>
<%@ page import="com.kadet.foodFactory.dao.daoImpl.ProductDaoImpl" %>
<%@page language="java" contentType="text/html; charset=utf-8" %>
<html>
<head>

    <link rel="stylesheet" type="text/css" media="screen"
          href="http://localhost:8080/web-resources/bootstrap/css/bootstrap.css"/>
    <%--<link rel="stylesheet" type="text/css" media="screen" href="http://localhost:8080/web-resources/css/dark.css"/>--%>

</head>

<body>

<h2>Операции с продуктами</h2>
<br>
<br>

<%List<Product> products = new ProductDaoImpl().findAll();%>


<%Integer succeed = (Integer) request.getAttribute(ProductController.SUCCEED);%>
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

<form action="/addProduct" method="POST">
    <%
        ProductGroupDao productGroupDao = new ProductGroupDaoImpl();
        List<ProductGroup> productGroups = productGroupDao.findAll();
    %>
    Выберите группу продуктов для данного продукта:
    <br>
    <select name="addProduct.productGroupId">
        <%
            for (ProductGroup productGroup : productGroups) {
        %>
        <option value="<%=productGroup.getIdProductGroup()%>">
            <%=productGroup.getName()%>
        </option>
        <%
            }
        %>
    </select>

    <br>
    Введите имя продукта:
    <br>
    <input type="text" name="addProduct.productName">
    <br>
    <input type="submit" value="Добавить продукт"/>
</form>

<%--

<form action="/getProduct" method="GET">

    <input type="submit" value="Get Product"/>
</form>
--%>

<br>
<br>

<form action="/removeProduct" method="POST">

    Выберите продукт для удаления
    <br>
    <select name="removeProduct.productId">
        <%for (Product product : products) { %>
            <option value="<%=product.getIdProduct()%>">
                <%=product.getIdProduct()%>) <%=product.getName()%>
            </option>
        <%}%>
    </select>
    <br>
    <input type="submit" value="Удалить продукт"/>
</form>

<br>
<br>


<form action="/updateProduct" method="POST">

    Выберите продукт для изменения
    <br>
    <select name="updateProduct.productId">
        <%for (Product product : products) { %>
        <option value="<%=product.getIdProduct()%>">
            <%=product.getIdProduct()%>) <%=product.getName()%>
        </option>
        <%}%>
    </select>
    <br>
    Изменить имя:
    <br>
    <input type="text" name="updateProduct.productName">
    <br>
    <input type="submit" value="Изменить продукт"/>
</form>

<br>
<br>


<table border="black">

    <th>idProduct</th>
    <th>name</th>
    <th>ProductGroup_id</th>

    <%for (Product product : products) { %>
    <tr>
        <td>
            <%=product.getIdProduct()%>
        </td>
        <td>
            <%=product.getName()%>
        </td>
        <td>
            <%=product.getProductGroup_Id()%>
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