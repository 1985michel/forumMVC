

<%@page import="model.ComentarioDAO"%>
<%@page import="model.Comentario"%>
<%@page import="model.ListadoraDeTopicos"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Topico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jstl/core_rt" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
        <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Lobster'>
        <link rel="stylesheet" type="text/css" href="myCss.css">


        <title>Exibe Tópico</title>
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


                            <div class="panel panel-default">
                                <!-- Default panel contents -->
                                <div class="panel-heading">                            
                                    <h3 class="text-center"><sub><b class=""><a href="">${titulo} <h5>por ${criador}</h5></a></b></sub><small><br><b class="text-uppercase"></b></small></h3>
                                </div>
                                <div class="panel-body">
                                    <table style="color:black" class="text-center">
                                        <tr class="text-center">
                                            <th>Usuário</th>
                                            <th>Comentário</th>

                                        </tr>
                                        <tr>



                                            <%
                                                List<Comentario> lista = new ArrayList<Comentario>();
                                                if (request.getAttribute("lista") != null) {
                                                    lista = (List<Comentario>) request.getAttribute("lista");
                                                }

                                                for (Comentario c : lista) {
                                                    if (c != null) {
                                                        out.println("<tr class='text-center'><td>" + c.getLogin() + "</td>"
                                                                + "<td>" + c.getComentario() + "</td></tr>");
                                                    }
                                                }


                                            %>







                                        </tr>

                                    </table>
                                    <div class="form-group" style="background-color:#124989; padding:10px;">

                                        <form class="center-block" method="post" action="comentar">
                                            <h5 class=""><sub><b class="lobster">Comentar</a></b></sub><small><br><b class="text-uppercase"></b></small></h5>

                                            ​<textarea id="comentario" rows="10" cols="70" name="comentario" placeholder="Deixe aqui seu comentário" class="form-control text-center"></textarea>
                                            <input type="submit" value="Enviar comentário" class="btn btn-primary btn-lg btn-block" />
                                        </form>

                                    </div>
                                </div>

                            </div>
                            <div class="btn-group btn-group-justified" role="group" style="background-color:#124989; padding:10px;">

                                <div class="btn-group" role="group">
                                    <a href="telaInsereComentario.jsp"><input type="button" value="Comentar" class="btn btn-primary " /></a>
                                </div>
                                <div class="btn-group" role="group">
                                    <a href="telaTopicos.jsp"><input type="button" value="Ranking" class="btn btn-default " /></a>
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
