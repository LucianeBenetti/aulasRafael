<%-- 
    Document   : exercicio8
    Created on : 28/02/2019, 13:03:26
    Author     : 80130917
--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style7.css">
        <title>Filto no CSV</title>
    </head>
    <body>
        <h1>Ordenamento de dados em arquivo CSV</h1>

        <form action="exercicio8" method="POST"> 
            <h2>Ordenar pela data/hora</h2><br />
            <h3>Digite -1 para ordenar decrescente ou 1 para crescente: </h3><br />
            <input type="text" name="ordenar">
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

                        String[] login = (String[]) request.getAttribute(i + "valores1");
                        String[] data = (String[]) request.getAttribute(i + "valores2");
                        String titulo = (String) request.getAttribute(i + "valores3");
                        String comentarios = (String) request.getAttribute(i + "valores4");

                        Arrays.sort(login);
                        for (int k = 0; k < linhas - 1; k++) {
                            for (int j = 0; j < linhas - 1 - i; j++) {
                                if (login[j].compareTo(login[j + 1]) > 0) {
                                    String auxiliar = login[j];
                                    login[j] = login[j + 1];
                                    login[j + 1] = auxiliar;
                                }
                            }
                        }
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
