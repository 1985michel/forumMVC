<%-- 
    Document   : ranking
    Created on : 26/09/2016, 22:45:22
    Author     : michel
--%>

<%@page import="model.Usuario"%>
<%@page import="model.ListadoraDeTopicos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Topico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:useBean id="dao" class="model.UsuarioDAO"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Lobster'>
        <link rel="stylesheet" type="text/css" href="myCss.css">


        <title>Cadastrar Tópico</title>
    </head>
    <body>
        <div class="container-fluid" style="padding-top: 1%;">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div id="logoMaster" class="container-fluid text-center" style="padding-right: 50px;">
                        <h3><sub><b class="lobster"><a href="">Fórum MVC</a></b></sub><small><br><b class="text-uppercase"><sup>My First Java Web Project</sup></b></small></h3>
                        <br>
                        <br>
                    </div>
                    <p></p>
                    <div style="padding-top: 30%;">


                        <div class="form-group center-block" style="background-color:#124989; padding:10px;">

                            <h5 class="text-center"><sub><b class="lobster"><a href="">Tópicos</a></b></sub><small><br><b class="text-uppercase"></b></small></h5>

                            <table style="color:white" class="text-center">
                                <tr class="text-center">
                                    <th>Colocação</th>
                                    <th>Nome</th>
                                    <th>Login</th>
                                    <th>Quantidade de Pontos</th>
                                </tr>                               

                                <%
                                    // ...
                                    List<Usuario> ranking = dao.ranking();
                                    int i = 1;
                                    for (Usuario u : ranking) {
                                        
                                        out.println("<tr><td >" + i + "</td> "
                                                + "<td>" + u.getNome() + "</td>"
                                                + "<td>" + u.getLogin() + "</td>"
                                                + "<td>" + u.getPontos() + "</td>"
                                                + "</tr>");
                                        i++;
                                    }
                                %>


                            </table>
                            <div class="btn-group btn-group-justified" role="group" style="background-color:#124989; padding:10px;">

                                <div class="btn-group" role="group">
                                    <a href="telaTopicos.jsp"><input type="button" value="Ver Tópicos" class="btn btn-primary " /></a>
                                </div>
                                
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </div>









        <script>
            if (document.location.search.match(/type=embed/gi)) {
                window.parent.postMessage("resize", "*");
            }
        </script>

    </body>
</html>
