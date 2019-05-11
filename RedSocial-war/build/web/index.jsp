<%-- 
    Document   : index
    Created on : 04-abr-2019, 15:54:54
    Author     : Senan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Iniciar sesion</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form method="get" action="IniciarSesionServlet">
            Email: <input type ="text" name="email"> <br/>
            Contraseña: <input type="text" name="password"> <br/>
            <button>Iniciar sesion</button>
        </form>
        <form action="registro.jsp">
            <button>Registrarse</button>
        </form>
    </body>
</html>
