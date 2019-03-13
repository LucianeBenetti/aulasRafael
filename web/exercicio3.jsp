<%-- 
    Document   : exercicio3
    Created on : 21/02/2019, 09:20:51
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
       <h1>Grava Arquivo</h1>
                       
        <%
         String p1=request.getParameter("file");
         if(p1==null){
             %>
             <span style="color: red">Arquivo não informado</span>
             <%
         }else{
             %>
             <b>Arquivo:</b> <u><% out.println(p1); %></u>
             <%
         }
         %>
                     
        <form action="exercicio3" method="POST"> 
            <input type="hidden" name="file" value="<% out.println(p1); %>"  />
            Digite o conteudo do Arquivo:<br>
            <input type="text" name="conteudo" value="<% out.println(p1); %>"  /><br><br><hr><br><br>
            Digite o nome do Arquivo:<br>
            <input type="text" name="fileInput" value="<% out.println(p1); %>" />
           
            <input type="submit" value="Gerar Arquivo">
        </form>
        
                     
            <%
                if( request.getAttribute("caminho")== null){
                    out.println("Arquivo ainda não existente no servidor");
                }else{
                    String fullPath=(String)request.getAttribute("caminho");
                    out.println("Arquivo gravado servidor: "+fullPath);
                    }
            %>
            
                                      
    </body>
</html>
