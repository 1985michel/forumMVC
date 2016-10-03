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
import model.Comentario;
import model.ComentarioDAO;

/**
 *
 * @author michel
 */
@WebServlet("/comentar")
public class CadastrarComentarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int id_topico = Integer.parseInt(request.getSession().getAttribute("id_topico").toString());
        String comentario = request.getParameter("comentario");
        String login = request.getSession().getAttribute("loginAtivo").toString();
        
        new ComentarioDAO().comentar(new Comentario(comentario, id_topico, login));
        
        request.getRequestDispatcher("/listaComentarios").forward(request, response);
        

    }

}
