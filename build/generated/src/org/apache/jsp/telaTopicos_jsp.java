package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.ListadoraDeTopicos;
import java.util.ArrayList;
import java.util.List;
import model.Topico;

public final class telaTopicos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      model.Topico dao = null;
      synchronized (_jspx_page_context) {
        dao = (model.Topico) _jspx_page_context.getAttribute("dao", PageContext.PAGE_SCOPE);
        if (dao == null){
          dao = new model.Topico();
          _jspx_page_context.setAttribute("dao", dao, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\n');
      model.ListadoraDeTopicos listadora = null;
      synchronized (_jspx_page_context) {
        listadora = (model.ListadoraDeTopicos) _jspx_page_context.getAttribute("listadora", PageContext.PAGE_SCOPE);
        if (listadora == null){
          listadora = new model.ListadoraDeTopicos();
          _jspx_page_context.setAttribute("listadora", listadora, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>\n");
      out.write("        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Lobster'>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"myCss.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <title>Cadastrar Tópico</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\" style=\"padding-top: 1%;\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-4\"></div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <div id=\"logoMaster\" class=\"container-fluid text-center\" style=\"padding-right: 50px;\">\n");
      out.write("                        <h3><sub><b class=\"lobster\"><a href=\"\">Fórum MVC</a></b></sub><small><br><b class=\"text-uppercase\"><sup>My First Java Web Project</sup></b></small></h3>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                    <p></p>\n");
      out.write("                    <div style=\"padding-top: 30%;\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"form-group center-block\" style=\"background-color:#124989; padding:10px;\">\n");
      out.write("\n");
      out.write("                            <h5 class=\"text-center\"><sub><b class=\"lobster\"><a href=\"\">Cadastrar Tópico</a></b></sub><small><br><b class=\"text-uppercase\"></b></small></h5>\n");
      out.write("\n");
      out.write("                            <table>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>Tópico nº</th>\n");
      out.write("                                    <th>Título do Tópico</th>\n");
      out.write("                                    <th>Criador</th>    \n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    ");

                                        // ...
                                        List<Topico> listaTopicos = listadora.getTodosTopicos();
                                        for (Topico t : listaTopicos) {
                                            out.println("<tr>"
                                                    + "<td >"+t.getId_topico()+"</td> "
                                                    + "<td>"+t.getTitulo()+"</td> "
                                                    + "<td>"+t.getLogin()+"</td> "
                                                    + "</tr>");
                                        }
                                    
      out.write("\n");
      out.write("\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            if (document.location.search.match(/type=embed/gi)) {\n");
      out.write("                window.parent.postMessage(\"resize\", \"*\");\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
