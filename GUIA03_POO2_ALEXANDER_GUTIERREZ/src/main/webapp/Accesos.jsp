<%-- 
    Document   : Accesos
    Created on : 08-24-2016, 08:36:12 PM
    Author     : Alexander José
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accesos</title>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <nav class="teal lighten-2">
            <div class="nav-wrapper">
                <a href="index.jsp" class="brand-logo right">GUIA 3 - POO2</a>
                <ul id="nav-mobile" class="left hide-on-med-and-down">
                    <li><a href="#">Accesos</a></li>
                </ul>
            </div>
        </nav>
        <br/>
        <br/>
        <br/>
        <br/>
        <div class="container">
            <center><h2 class="teal-text text-lighten-2">Mantenimiento de accesos</h2></center>
            <br/>
            <center><h3 class="teal-text text-lighten-2">${mensAlert}</h3></center>
            <br/>
            <div class="row">
                <form name="DatosForm" method="POST" action="AcceServ" class="col s12">                    
                    <input type="hidden" name="codiAcce" value="${codiAcce}"/>
                    <jsp:useBean id="beanAcceCtrl" class="com.sv.udb.controlador.LugaAcceCtrl" scope="page"/>
                    <div class="input-field col s12">
                        <input name="Nombre" type="text" class="validate" value="${Nombre}" required>
                        <label for="Nombre">Nombre</label>
                    </div>                    
                    <div class="col s12">
                        <br/>
                        <center>
                            <c:choose>
                                <c:when test="${opConsulta == 1}">
                                    <input class="btn waves-effect waves-light disabled" type="submit" name="cursBton" value="Guardar"/>
                                    <input class="btn waves-effect waves-light" type="submit" name="cursBton" value="Modificar"/>
                                    <input class="btn waves-effect waves-light" type="submit" name="cursBton" onclick="return confirm('¿Desea borrar el dato?')" value="Eliminar"/>
                                    <input class="btn waves-effect waves-light" type="submit" name="cursBton" value="Cancelar"/>                                      
                                </c:when>
                                <c:otherwise>
                                    <input class="btn waves-effect waves-light" type="submit" name="cursBton" value="Guardar"/>
                                    <input class="btn waves-effect waves-light disabled" type="submit" name="cursBton" value="Modificar"/>
                                    <input class="btn waves-effect waves-light disabled" type="submit" name="cursBton" onclick="return confirm('¿Desea borrar el dato?')" value="Eliminar"/>
                                    <input class="btn waves-effect waves-light disabled" type="submit" name="cursBton" value="Cancelar"/>                                     
                                </c:otherwise>
                            </c:choose>
                        </center>
                        <br/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
