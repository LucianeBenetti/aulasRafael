package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Exercicio1 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ArrayList<Integer> listaNumeros = new ArrayList<Integer>();

        listaNumeros.add(Integer.parseInt(request.getParameter("numero1")));
        listaNumeros.add(Integer.parseInt(request.getParameter("numero2")));
        listaNumeros.add(Integer.parseInt(request.getParameter("numero3")));
        listaNumeros.add(Integer.parseInt(request.getParameter("numero4")));
        listaNumeros.add(Integer.parseInt(request.getParameter("numero5")));
        listaNumeros.add(Integer.parseInt(request.getParameter("numero6")));
        listaNumeros.add(Integer.parseInt(request.getParameter("numero7")));
        listaNumeros.add(Integer.parseInt(request.getParameter("numero8")));
        listaNumeros.add(Integer.parseInt(request.getParameter("numero9")));
        listaNumeros.add(Integer.parseInt(request.getParameter("numero10")));

        for (int i = 0; i < listaNumeros.size(); i++) {
            for (int j = 0; j < 9; j++) {
                if (listaNumeros.get(j) > listaNumeros.get(j + 1)) {
                    int aux = listaNumeros.get(j);
                    listaNumeros.set(j, listaNumeros.get(j + 1));
                    listaNumeros.set(j + 1, aux);
                }
            }
        }
        request.setAttribute("listaNumeros", listaNumeros);
        request.getRequestDispatcher("resultadoNumeros.jsp").forward(request, response);

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
