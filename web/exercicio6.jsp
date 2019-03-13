<%-- 
    Document   : exercicio6
    Created on : 27/02/2019, 20:21:49
    Author     : luciane
--%>

<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style6.css">
        <title>Leitura arquivos</title>
    </head>
    <body>
        <div class="secao1">
            <h1>Leitura de vários arquivos .txt</h1>

            <form action="exercicio6.jsp" method="post">
                Digite a quantidade de arquivos (.txt) armazenados no diretório:<br/><br/>

                <input type="text" name="numero_de_arquivos" value="" />
                <input type="submit" name="submit" value="Ler Arquivos" /><br/><br/><hr/>

            </form>

            <%
                String[] dadosDoArquivo = null;
                String numeroDeArquivos = request.getParameter("numero_de_arquivos");

                if (numeroDeArquivos == null) {
                    numeroDeArquivos = "";
                    out.print("Número de arquivos ainda não foi informado!");
                } else if (numeroDeArquivos != "") {

                    try {
                        int n = Integer.parseInt(numeroDeArquivos);
                        dadosDoArquivo = new String[n];
                        for (int i = 1; i <= n; i++) {
                            FileReader encontrarArquivo = new FileReader("C:\\SENAC\\Exercicio6\\" + "Arq" + i + ".txt");
                            BufferedReader lerArquivo = new BufferedReader(encontrarArquivo);
                            dadosDoArquivo[i - 1] = lerArquivo.readLine();
                        }

                    } catch (Exception e) {
                        out.print("Erro na conversão do número de arquivos para inteiro");
                    }
                }

            %>
        </div>
        
        <div class="secao2">
            <h1>Informação obtida a partir de arquivo armazenado!</h1>   

            <%    if (dadosDoArquivo != null) {
                    for (int i = 0; i < dadosDoArquivo.length; i++) {
                        out.println(dadosDoArquivo[i] + "</ br>" + "<hr>");
                    }
                }
            %>   
        </div>
    </body>
</html>
