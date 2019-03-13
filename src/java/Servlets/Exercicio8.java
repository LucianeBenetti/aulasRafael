package Servlets;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
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

        File f = new File("C:\\SENAC\\Exercicio7\\Exercicio7.csv");
        String p = request.getParameter("p");

        FileInputStream fin = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fin);
        byte[] dados = new byte[fin.available()];
        dis.read(dados);
        String conteudoArquivo = new String(dados);
        ArrayList<Comentario> lista = new ArrayList<Comentario>();
        String[] registros = conteudoArquivo.split("\n");
        for (int i = 1; i < registros.length; i++) {
            String registro = registros[i];
            String[] campos = registro.split(";");
            String login = campos[0];
            String dataTxt = campos[1];
            String titulo = campos[2];
            String comentario = campos[3];
            Comentario c = new Comentario(login, dataTxt, titulo, comentario);
            lista.add(c);
        }

        for (int i = 0; i < lista.size(); i++) {
            for (int j = i + 1; j < lista.size(); j++) {
                boolean condicao;
                if (p.equals("1")) {
                    condicao = lista.get(i).getDt().before(lista.get(j).getDt());
                } else {
                    condicao = lista.get(i).getDt().after(lista.get(j).getDt());
                }
                if (condicao) {
                    Comentario temp = lista.get(i);
                    lista.set(i, lista.get(j));
                    lista.set(j, temp);
                }
            }

        }

        System.out.println("Tamanho: " + lista.size());
        request.setAttribute("lista", lista);

        RequestDispatcher rd = request.getRequestDispatcher("exercicio8.jsp");
        rd.forward(request, response);

        //response.sendRedirect("apresentacao_arquivo.jsp");
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
