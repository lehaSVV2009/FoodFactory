<%@ page import="java.util.List" %>
<%@ page import="com.kadet.foodFactory.controller.ProviderController" %>
<%@ page import="com.kadet.foodFactory.entity.Provider" %>
<%@ page import="com.kadet.foodFactory.dao.daoImpl.ProviderDaoImpl" %>
<%@page language="java" contentType="text/html; charset=utf-8" %>
<html>
<head>

</head>

<body>

<h2>Операции с поставщиками</h2>
<br>
<br>

<%List<Provider> providers = new ProviderDaoImpl().findAll();%>


<%Integer succeed = (Integer) request.getAttribute(ProviderController.SUCCEED);%>
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

<form action="/addProvider" method="POST">
    <br>
    Введите имя поставщика:
    <br>
    <input type="text" name="addProvider.providerName">
    <br>
    Адрес:
    <br>
    <input type="text" name="addProvider.providerAddress">
    <br>
    Телефон:
    <br>
    <input type="text" name="addProvider.providerPhone">
    <br>
    <input type="submit" value="Добавить поставщика"/>
</form>

<br>
<br>

<form action="/removeProvider" method="POST">

    Выберите поставщика для удаления
    <br>
    <select name="removeProvider.providerId">
        <%for (Provider provider : providers) { %>
        <option value="<%=provider.getIdProvider()%>">
            <%=provider.getIdProvider()%>) <%=provider.getName()%>
        </option>
        <%}%>
    </select>
    <br>
    <input type="submit" value="Удалить поставщика"/>
</form>

<br>
<br>


<form action="/updateProvider" method="POST">

    Выберите поставщика для изменения данных
    <br>
    <select name="updateProvider.providerId">
        <%for (Provider provider : providers) { %>
        <option value="<%=provider.getIdProvider()%>">
            <%=provider.getIdProvider()%>) <%=provider.getName()%>
        </option>
        <%}%>
    </select>
    <br>
    Изменить имя:
    <br>
    <input type="text" name="updateProvider.providerName">
    <br>
    Изменить адрес:
    <br>
    <input type="text" name="updateProvider.providerAddress">
    <br>
    Изменить телефон:
    <br>
    <input type="text" name="updateProvider.providerPhone">
    <br>
    <input type="submit" value="Изменить данные о поставщике"/>
</form>


<table border="black">

    <th>idProvider</th>
    <th>code</th>
    <th>name</th>
    <th>address</th>
    <th>phone</th>

    <%for (Provider provider : providers) { %>
    <tr>
        <td>
            <%=provider.getIdProvider()%>
        </td>
        <td>
            <%=provider.getCode()%>
        </td>
        <td>
            <%=provider.getName()%>
        </td>
        <td>
            <%=provider.getAddress()%>
        </td>
        <td>
            <%=provider.getPhone()%>
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