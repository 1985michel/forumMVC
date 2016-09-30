package controller;

import static controller.LoginServlet.ERRO_AO_LOGAR;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import model.CadastradoraDeUsuarios;
import model.Logadora;

/**
 *
 * @author michel
 */
@WebServlet("/cadastrar")
public class cadastrarUsuarioServlet extends HttpServlet {
    
    public static final String ERRO_AO_CADASTRAR = "Erro. Usuário não cadastrado.";
    public static final String SUCESSO = "Cadastro Realizado com Sucesso!";
    public static final String ERRO_CAMPO_VAZIO = "Erro. Todos os campos do formulário devem ser informados.";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        
        if(nome==null || email==null || login==null || senha==null){
            request.setAttribute("erro", ERRO_CAMPO_VAZIO);
            request.getRequestDispatcher("falhaNoLogin.jsp").forward(request, response);
            return;
        }
        if(nome.isEmpty() || email.isEmpty() || login.isEmpty() || senha.isEmpty()){
            request.setAttribute("erro", ERRO_CAMPO_VAZIO);
            request.getRequestDispatcher("falhaNoLogin.jsp").forward(request, response);
            return;
        }
        //Primeiro verifico se já tem um usuário com aquele login
        
        
        try{
           CadastradoraDeUsuarios.cadastrarUsuario(login, nome, email, senha);
           
           request.getRequestDispatcher("telaTopicos.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Falha: " + e);
            request.setAttribute("erro", e.getMessage());
            request.getRequestDispatcher("falhaNoLogin.jsp").forward(request, response);
        }

    }

}
