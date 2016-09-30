/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Topico;
import model.TopicoDAO;

/**
 *
 * @author michel
 */
@WebServlet("/exibeTopicos")
public class exibeTopicosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //coletando o parameto
        int id_topico = Integer.parseInt(request.getParameter("topico"));
        
        //int id_topico =4;
        System.out.println("chegou aqui");
        
        //recuperando o topico
        TopicoDAO dao = new TopicoDAO();
        Topico t = dao.recuperar(id_topico);
        request.setAttribute("titulo", t.getTitulo());
        request.setAttribute("login", t.getLogin());

        //passar o controller para o view
        request.getRequestDispatcher("TelaExibeTopico.jsp").forward(request, response);

    }

}
