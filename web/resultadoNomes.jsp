<%-- 
    Document   : resultadoNomes
    Created on : 21/02/2019, 09:08:37
    Author     : luciane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style2.css">
        <title>Resultado dos Nomes</title>
    </head>
    <body>
       <h1>Lista de nomes ordenados</h1>
        
            <%
                if(request.getAttribute("listaNomes")!=null){
                    String[] array =  (String[]) request.getAttribute("listaNomes");
            %>
            
            <table border="1">
                <thead>
                    <tr>
                        <th>Nomes ordenados</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <% for (int i=0; i < array.length; i++){%>
                        <tr>
                            <td><%out.print(array[i]); %></td>
                        </tr>
                        <%}%>
            
                </tbody>
            </table>
        <%}%>
    </body>
</html>
