<%@page language="java" contentType="text/html; ISO-8859-1" %>
<html>
<head>

</head>

<body>

    Provider
    <br>

    <form action="/addProvider" method="POST">
        <input type="submit" value="Add Provider"/>
    </form>

    <form action="/getProvider" method="GET">
        <input type="submit" value="Get Provider"/>
    </form>

    <form action="/removeProvider" method="POST">
        <input type="submit" value="Remove Provider"/>
    </form>

    <form action="/updateProvider" method="POST">
        <input type="submit" value="Update Provider"/>
    </form>

    <form action="index.jsp" method="GET">
        <input type="submit" value="Main"/>
    </form>



</body>
</html>