/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luciane
 */
@WebServlet(name = "Exercicio2", urlPatterns = {"/exercicio2"})
public class Exercicio2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String listaNomes[] = new String[10];

        listaNomes[0] = request.getParameter("nome1");
        listaNomes[1] = request.getParameter("nome2");
        listaNomes[2] = request.getParameter("nome3");
        listaNomes[3] = request.getParameter("nome4");
        listaNomes[4] = request.getParameter("nome5");
        listaNomes[5] = request.getParameter("nome6");
        listaNomes[6] = request.getParameter("nome7");
        listaNomes[7] = request.getParameter("nome8");
        listaNomes[8] = request.getParameter("nome9");
        listaNomes[9] = request.getParameter("nome10");

        int tamanho = listaNomes.length;
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (listaNomes[j].compareTo(listaNomes[j + 1]) > 0) {
                    String auxiliar = listaNomes[j];
                    listaNomes[j] = listaNomes[j + 1];
                    listaNomes[j + 1] = auxiliar;
                }
            }
        }

        request.setAttribute("listaNomes", listaNomes);
        request.getRequestDispatcher("resultadoNomes.jsp").forward(request, response);
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
