<%-- 
    Document   : exercicio7
    Created on : 25/02/2019, 09:34:32
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style7.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Leitura de Arquivo CSV</h1>


        <form action="exercicio7" method="POST"> 
            <input type="submit" name="conteudo" value="Ler arquivo CSV">
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th>Login</th>
                    <th>Data/Hora</th>
                    <th>Título</th>
                    <th>Comentario</th>
                </tr>
            </thead>
            <tbody>

                <%
                    int linhas = 0;
                    if (request.getAttribute("linhas") != null) {
                        linhas = ((Integer) (request.getAttribute("linhas"))).intValue();
                    }
                %>

                <% for (int i = 0; i < linhas; i++) {

                        String login = (String) request.getAttribute(i + "valores1");
                        String data = (String) request.getAttribute(i + "valores2");
                        String titulo = (String) request.getAttribute(i + "valores3");
                        String comentarios = (String) request.getAttribute(i + "valores4");
                %>
                <tr>
                    <td class = "login"><%out.print(login); %></td>
                    <td class = "dataHora"><%out.print(data); %></td>
                    <td class = "titulo"><%out.print(titulo); %></td>
                    <td class = "comentario"><%out.print(comentarios); %></td>
                </tr>

                <%}%>
            </tbody>
        </table>

    </body>
</html>
