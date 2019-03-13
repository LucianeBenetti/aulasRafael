<%-- 
    Document   : exercicio4
    Created on : 21/02/2019, 09:53:12
    Author     : luciane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ler arquivo</title>
    </head>
    <body>
        <h1>Leitura de Arquivo</h1>
        
         <%
         String p1=request.getParameter("file");
         if(p1==null){
             %>
             <span style="color: red">Arquivo não informado</span><br>
             <%
         }else{
            
         }
         %>
            <form action="Exercicio4" method="POST"> 
                <input type="hidden" name="file" value="<% out.println(p1); %>"  /><br><br>
            
            Nome do Arquivo:
            <input type="text" name="fileInput" value="<% out.println(p1); %>" /><br><br>
           
            <input type="submit" value="Ler Arquivo"><br><br><hr>
        </form>    
       
        
              <%
                if( request.getAttribute("conteudo")== null){
                    out.println("Arquivo sem conteudo.");
                }else{
                    String conteudo=(String)request.getAttribute("conteudo");
                    out.println(conteudo);
                    
                    
                        }
            %>
        
        
    </body>
</html>
