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
import model.CadastradoraDeTopicos;

/**
 *
 * @author michel
 */
@WebServlet("/criarTopico")
public class cadastrarTopicoServlet extends HttpServlet {

    public static final String ERRO_AO_CADASTRAR = "Erro. Tópico não cadastrado.";
    public static final String SUCESSO = "Cadastro Realizado com Sucesso!";
    public static final String ERRO_CAMPO_VAZIO = "Erro. Todos os campos do formulário devem ser informados.";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String titulo = request.getParameter("titulo");
        String conteudo = request.getParameter("conteudo");
        String login = request.getSession().getAttribute("loginAtivo").toString();
       
               
        if(titulo==null || conteudo==null || login==null){
            request.setAttribute("erro", ERRO_CAMPO_VAZIO);
            request.getRequestDispatcher("falhaNoLogin.jsp").forward(request, response);
            return;
        }
        if(titulo.isEmpty() || conteudo.isEmpty() || login.isEmpty()){
            request.setAttribute("erro", ERRO_CAMPO_VAZIO);
            request.getRequestDispatcher("falhaNoLogin.jsp").forward(request, response);
            return;
        }
        //Primeiro verifico se já tem um usuário com aquele login
        
        
        try{
           CadastradoraDeTopicos.cadastrarTopico(conteudo, titulo, login);
           //CadastradoraDeTopicos.cadastrarTopico("MICHEL", "titulo2", "MICHEL");
           request.getRequestDispatcher("telaTopicos.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Falha: " + e);
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("falhaNoLogin.jsp").forward(request, response);
        }

    }

}
