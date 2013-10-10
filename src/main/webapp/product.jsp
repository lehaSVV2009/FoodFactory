<%@page language="java" contentType="text/html; ISO-8859-1" %>
<html>
<head>

</head>

<body>

    Product
    <br>

    <form action="/addProduct" method="POST">
        <input type="submit" value="Add Product"/>
    </form>

    <form action="/getProduct" method="GET">
        <input type="submit" value="Get Product"/>
    </form>

    <form action="/removeProduct" method="POST">
        <input type="submit" value="Remove Product"/>
    </form>

    <form action="/updateProduct" method="POST">
        <input type="submit" value="Update Product"/>
    </form>

    <form action="index.jsp" method="GET">
        <input type="submit" value="Main"/>
    </form>



</body>
</html>