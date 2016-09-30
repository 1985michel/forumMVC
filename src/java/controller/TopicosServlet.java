
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ListadoraDeTopicos;
import model.Topico;

/**
 *
 * @author michel
 */
@WebServlet("/topicos")
public class TopicosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      
        //chamar a regra de negócios
        List<Topico> topicosLista = ListadoraDeTopicos.getTodosTopicos();
        
        //colocando a resposta no escolo adequado
        request.setAttribute("topicosLista",topicosLista);
        
        //passar o controller para o view
        request.getRequestDispatcher("telaTopicos.jsp").forward(request, response);
        
    }

    

}
