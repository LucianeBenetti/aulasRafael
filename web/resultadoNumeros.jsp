<%-- 
    Document   : resultadoNumeros
    Created on : 21/02/2019, 09:07:51
    Author     : luciane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Lista ordenada</h1>
            <%
            out.println(request.getAttribute("listaNumeros"));
             %>
    </body>
</html>
