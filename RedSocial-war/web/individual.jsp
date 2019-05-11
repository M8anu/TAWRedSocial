<%-- 
    Document   : individual
    Created on : 08-may-2019, 21:00:04
    Author     : Guille
--%>

<%@page import="redsocial.entity.Mensaje"%>
<%@page import="java.util.List"%>
<%@page import="redsocial.entity.Usuario"%>
<%@page import="redsocial.entity.Chat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    Chat chat = (Chat)request.getAttribute("chat");
    List<Mensaje> listaMensajes = chat.getMensajeList1();
    Usuario u = (Usuario)request.getAttribute("u");
    Usuario u2 = (Usuario)request.getAttribute("u2");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
    </head>
    <body>
        <table>
            <tr>
                <th>
                    <%=u.getNick() %>
                </th>
                <th>
                    <%=u2.getNick() %>
                </th>
            </tr>
            <%
            for (Mensaje m: listaMensajes) {
            %>
            <tr>
                <td>
                <%
                    if(m.getIdUsuario().getIdUsuario() == u.getIdUsuario()) {
                %>
            
                <%=m.getContenido() %><br>
                <% } %>
                </td>
                <td>
                    <% if (m.getIdUsuario().getIdUsuario() == u2.getIdUsuario()) {%>
                    <%=m.getContenido() %><br>
                    <% } %>
                </td>
            </tr>
            <% }   %>
        </table>
        <form action="enviarMensajeServlet">
            <input type="hidden" name="id" value="<%=u.getIdUsuario() %>">
            <input type="hidden" name="id2" value="<%=u2.getIdUsuario() %>">
            <input type="hidden" name="chat" value="<%=chat.getIdChat() %>">
            <input type="hidden" name="idm" value="<%=listaMensajes.size() %>">
            <input type="text" name="mensaje" size="100">
            <button>Enviar mensaje</button>
        </form>
    </body>
</html>
