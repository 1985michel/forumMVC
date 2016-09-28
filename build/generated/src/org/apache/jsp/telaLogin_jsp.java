package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class telaLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>\n");
      out.write("        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Lobster'>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"myCss.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container-fluid\" style=\"padding-top: 3%;\">\n");
      out.write("            <div id=\"logoMaster\" class=\"container-fluid text-center\" style=\"\">\n");
      out.write("                <h1><sub><b class=\"lobster\"><a href=\"\">Fórum MVC</a></b></sub><small><br><b class=\"text-uppercase\"><sup>My First Java Web Project</sup></b></small></h1>\n");
      out.write("            </div>\n");
      out.write("            <p></p>\n");
      out.write("            <div class=\"row\" style=\"padding-top: 10%;\">\n");
      out.write("                <div class=\"col-md-4\"></div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <div class=\"form-group\" style=\"background-color:#124989; padding:10px;\">\n");
      out.write("                        <form class=\"center-block\" method=\"post\" action=\"login\">\n");
      out.write("                            <input type=\"text\" name=\"login\" placeholder=\"login\" class=\"form-control text-center\" />\n");
      out.write("                            <input type=\"password\" name=\"senha\" placeholder=\"senha\" class=\"form-control text-center\" />\n");
      out.write("                            <input type=\"submit\" value=\"Logar\" class=\"btn btn-primary btn-lg btn-block\" />\n");
      out.write("                        </form>\n");
      out.write("                        <form class=\"text-center\">\n");
      out.write("                            <input type=\"submit\" value=\"Novo Usuário\" class=\"btn btn-default btn-lg btn-block\" />\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        if (request.getAttribute("erro") != null) {
                            out.println("<div style='background-color:#DE5448; padding:10px;' class='text-center'>"
                                    + "<b><p1 >" + request.getAttribute("erro") + "</p1></b>"
                                    + "</div>");
                        }

                    
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
