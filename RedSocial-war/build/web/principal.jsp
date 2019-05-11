<%-- 
    Document   : principal
    Created on : 04-abr-2019, 13:56:26
    Author     : Senan
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="redsocial.entity.Usuario"%>
<!DOCTYPE html>

<%
    Usuario us = (Usuario) request.getAttribute("usuario");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal <%= us.getNombre() %></title>
    </head>
    <body>
        <h1>Bienvenido <%= us.getNombre() %></h1>
        <form action="CambiarContraseniaServlet">
            <input type="hidden" name="id" value="<%= us.getIdUsuario() %>" /> <br/>
            Nombre: <%= us.getNombre() %> <br/>
            Apellidos: <%= us.getApellidos() %> <br/>
            Nick: <%= us.getNick() %> <br/>
            Email: <%= us.getEmail() %> <br/>
            Sexo: <%= us.getSexo() %> <br/>
            Edad: <%= us.getEdad() %> <br/>
            <button>Cambiar contraseña</button> <br/>
        </form>
        
        <form action="buscarUsuarioServlet">
            Buscar usuario por Nick: <input type="text" name="usuario">
            <input type="submit" name="Buscar">
        </form>
        
            <form action="index.jsp">
            <button>Cerrar sesión</button>
        </form>
            <a href="ChatsServlet?id=<%=us.getIdUsuario()%>">Chats</a>
    </body>
</html>
