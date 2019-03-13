<%-- 
    Document   : exercicio5GET
    Created on : 21/02/2019, 11:24:06
    Author     : 80130917
--%>

<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Leitura de Arquivo</h1>
        
         <%
         String p1=request.getParameter("file");
         if(p1==null){
             %>
             <span style="color: red">Arquivo não informado</span><br><br>
             <%
         }else{
            
         }
         %>
                     
        <form action="exercicio5Resposta" method="GET"> 
            <input type="hidden" name="file" value="<% out.println(p1); %>"  /><br><br>
            <input type="text" name="fileInput" value="<% out.println(p1); %>" /><br><br>
           
            <input type="submit" value="Ler arquivo"><br><br><hr>
        </form>
                
            
        <br /><br /><br />
        
        
              <%
                if( request.getAttribute("conteudo")== null){
                    out.println("Arquivo sem conteudo.");
                }else{
                 String   conteudo=(String)request.getAttribute("conteudo");
                    out.println(conteudo);
                                 
                }
            %>
        
        
    </body>
</html>
