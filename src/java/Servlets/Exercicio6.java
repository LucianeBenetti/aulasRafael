package Servlets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 80130917
 */
@WebServlet(name = "Exercicio6", urlPatterns = {"/exercicio6"})
public class Exercicio6 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String dir = "C:\\SENAC\\Exercicio6";
        File file = new File(dir);

        for (String arq : file.list()) {
            if (arq.endsWith(".txt")) {

                try {
                    System.out.println(leitura(dir + "\\" + arq));
                    request.setAttribute("conteudo", (leitura(dir + "\\" + arq)));

                } catch (Exception ex) {
                }
            }

        }
        request.getRequestDispatcher("exercicio6.jsp").forward(request, response);
    }

    private static String leitura(String dir) throws Exception {
        String linha = "", conteudo = "";
        BufferedReader br = new BufferedReader(new FileReader(new File(dir)));
        while ((linha = br.readLine()) != null) {
            if (!linha.isEmpty()) {
                conteudo = new StringBuilder(conteudo).append(linha.concat("\n")).toString();
            }
        }
        br.close();
        return conteudo;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
