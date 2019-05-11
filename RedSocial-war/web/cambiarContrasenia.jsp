<%-- 
    Document   : cambiarContrasenia
    Created on : 05-abr-2019, 18:24:19
    Author     : Senan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="redsocial.entity.Usuario"%>
<%@page import="redsocial.dao.UsuarioFacade"%>

<!DOCTYPE html>

<%
    String id = (String) request.getAttribute("id");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cambiar contraseña</title>
    </head>
    <body>
        <h1>Cambiar contraseña</h1>
        <form action="ConfirmarCambioContraseniaServlet">
            <input type="hidden" name="id" value="<%= id %>">
            Nueva contraseña: <input type="text" name="nuevaPass"> <br/>
            <button>Confirmar contraseña</button>
        </form>
    </body>
</html>
