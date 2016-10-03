/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Comentario;
import model.ComentarioDAO;

/**
 *
 * @author michel
 */
@WebServlet("/listaComentarios")
public class listaComentariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_topico = Integer.parseInt(request.getSession().getAttribute("id_topico").toString());
        List<Comentario> lista = new ComentarioDAO().getTodosComentariosDeUmTopico(id_topico);
        
        request.setAttribute("criador", request.getSession().getAttribute("criador").toString());
        
        request.setAttribute("lista", lista );
        request.getRequestDispatcher("TelaExibeTopico.jsp").forward(request, response);
        
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_topico = Integer.parseInt(request.getSession().getAttribute("id_topico").toString());
        List<Comentario> lista = new ComentarioDAO().getTodosComentariosDeUmTopico(id_topico);
        
        request.setAttribute("criador", request.getSession().getAttribute("criador").toString());
        
        request.setAttribute("lista", lista );
        request.getRequestDispatcher("TelaExibeTopico.jsp").forward(request, response);
        
        
    }

}
