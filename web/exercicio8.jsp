<%-- 
    Document   : exercicio8
    Created on : 28/02/2019, 13:03:26
    Author     : 80130917
--%>

<%@page import="Servlets.Comentario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style8.css">
        <title>Filto no CSV</title>
    </head>
    <body>
        <h1>Ordenamento de dados em arquivo CSV</h1>

        <form action="exercicio8" method="POST"> 
            <h2>Ordenar pela data/hora</h2><br />
            <h3>Digite -1 para ordenar decrescente ou 1 para crescente: </h3><br />
            <input type="text" name="p">
            <input type="submit" name="conteudo" value="Ler arquivo CSV">
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th>Login</th>
                    <th>Data</th>
                    <th>Titulo</th>
                    <th>Comentario</th>
                </tr>
            </thead>
            <%
                Object obj = request.getAttribute("lista");
                if (obj != null) {
                    ArrayList<Comentario> lista = (ArrayList<Comentario>) obj;
                    for (int i = 0; i < lista.size(); i++) {
                        Comentario c = lista.get(i);
            %>
            <tr>
                <td class = "login">
                    <% out.print(c.getLogin()); %>
                </td>
                <td class = "dataHora">
                    <% out.print(c.getData()); %>
                </td>
                <td class = "titulo">
                    <% out.print(c.getTitulo()); %>                           
                </td>
                <td class = "comentario">
                    <% out.print(c.getComentario()); %>
                </td>
            </tr>

            <%
                    }
                } else {
                    out.print("Esta tela não deve se acessada diretamente.");
                }
            %>
        </table>
    </body>
</html>
