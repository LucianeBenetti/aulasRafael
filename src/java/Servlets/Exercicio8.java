package Servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
@WebServlet(name = "Exercicio8", urlPatterns = {"/exercicio8"})
public class Exercicio8 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String p = request.getParameter("p");
        
        File arquivoCSV = new File("C:\\SENAC\\Exercicio7\\Exercicio7.csv");
        try {

            Scanner leitor = new Scanner(arquivoCSV);
            String linhas = new String();
            leitor.nextLine();
            int i = 0;
            while (leitor.hasNext()) {
                linhas = leitor.nextLine();
                String[] valores = linhas.split(";");

                request.setAttribute(i + "valores1", valores[0]);
                request.setAttribute(i + "valores2", valores[1]);
                request.setAttribute(i + "valores3", valores[2]);
                request.setAttribute(i + "valores4", valores[3]);

                i++;       

            }
            request.setAttribute("linhas", new Integer(i));

        } catch (FileNotFoundException e) {

        }

        request.getRequestDispatcher("exercicio8.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
