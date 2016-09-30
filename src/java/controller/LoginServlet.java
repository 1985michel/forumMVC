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
import model.*;

/**
 *
 * @author michel
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public static final String ERRO_AO_LOGAR = "Não foi possível logar. Verifique os dados informados e tente novamente.";
    public static final String LOGIN_REALIZADO_COM_SUCESSO = "Login Realizado com Sucesso!";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        try {
            if (Logadora.autenticar(login, senha)) {
                //colocando o login ativo na sessão
                request.getSession().setAttribute("loginAtivo", login);
                request.getRequestDispatcher("telaInsereTopico.jsp").forward(request, response);
            } else {
                request.setAttribute("erro", ERRO_AO_LOGAR);
                request.getRequestDispatcher("telaLogin.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println("Falha: " + e);
            request.getRequestDispatcher("falhaNoLogin.jsp").forward(request, response);
        }
    }

}
