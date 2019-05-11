<%-- 
    Document   : registro
    Created on : 04-abr-2019, 13:19:24
    Author     : Senan
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro nuevo usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="RegistrarServlet">
            Nombre: <input name="nombre"> <br/>
            Apellidos: <input name="apellidos"> <br/>
            Nick: <input name="nick"> <br/>
            Email: <input name="email"> <br/>
            Contraseña: <input name="password"> <br/>
            Sexo: 
            <select name="sexo"> 
                <option value="h">Hombre</option>
                <option value="m">Mujer</option>
            </select>
            Edad: <input name="edad"> <br/>
            <input type="submit" value="Registrar">
        </form>
    </body>
</html>
