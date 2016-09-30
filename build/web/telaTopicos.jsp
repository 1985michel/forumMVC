<%-- 
    Document   : telaLogin
    Created on : 26/09/2016, 22:45:22
    Author     : michel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="C" uri="http://java.sun.com/jstl/core_rt" %>
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
                            
                            
                            
                        </div>
                    </div>

                    <%
                        if (request.getAttribute("erro") != null) {
                            out.println("<div style='background-color:#DE5448; padding:10px;' class='text-center'>"
                                    + "<b><p1 >" + request.getAttribute("erro") + "</p1></b>"
                                    + "</div>");
                        }

                    %>



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
