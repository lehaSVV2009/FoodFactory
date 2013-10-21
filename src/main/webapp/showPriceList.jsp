<%@ page import="java.util.List" %>
<%@ page import="com.kadet.foodFactory.entity.Bill" %>
<%@ page import="com.kadet.foodFactory.controller.ShowController" %>
<%@ page import="com.kadet.foodFactory.entity.Provider" %>
<%@page language="java" contentType="text/html; charset=utf-8" %>
<html>
<head>

</head>

<body>

<h2>Прайс-лист</h2>
<br>
<br>
<br>

<%List<Bill> priceList = (List<Bill>) request.getAttribute(ShowController.PRICE_LIST);%>

<%Provider provider = (Provider)request.getAttribute("PROVIDER");%>
Поставщик <br>
Имя: <i><%=provider.getName()%></i> <br>
Код: <i><%=provider.getCode()%></i> <br>
Адрес: <i><%=provider.getAddress()%></i> <br>
Телефон: <i><%=provider.getPhone()%></i> <br>

<br>
<table>
    <th>Ингредиент</th>
    <th>Цена</th>
    <th>Дата подписания договора</th>

    <%for (Bill bill : priceList) { %>
    <tr>

        <td>
            <%=bill.getIngredient().getName()%>
        </td>
        <td>
            <%=bill.getPrice()%>
        </td>
        <td>
            <%=bill.getReceiptDate()%>
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