<%-- 
    Document   : exercicio5
    Created on : 21/02/2019, 11:23:35
    Author     : 80130917
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.DataOutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Grava Arquivo</h1>
                     
        <%
         String p1=request.getParameter("file");
         if(p1==null){
             %>
             <span style="color: red">Arquivo não informado</span><br>
             <%
         }else{
             
         }
         %>
            
        <form action="exercicio5" method="GET"> 
            <input type="hidden" name="file" value="<% out.println(p1); %>"  />
            Nome do Arquivo:
            <input type="text" name="fileInput" value="<% out.println(p1); %>" /><br><br><hr>
            
            Conteudo do Arquivo:
            <input type="text" name="conteudo" value="<% out.println(p1); %>"  /><br><br>
           
            <input type="submit" value="Gerar Arquivo">
               
        </form>
            
                 
                               
            <%
                if( request.getAttribute("caminho")== null){
                    out.println("Arquivo ainda não existente no servidor");
                }else{
                   String fullPath=(String)request.getAttribute("caminho");
                    out.println("Arquivo no servidor: "+fullPath);
                    }
            %>
          
                                    
    </body>
</html>
