<%-- 
    Document   : EliminarRegistro
    Created on : 6 may. 2023, 05:39:14
    Author     : marce
--%>

<%@page import="sv.edu.formas.proyectodatos.dao.daoRegistro"%>
<%@page import="sv.edu.formas.proyectodatos.entidad.Registro"%>
<%@page import="sv.edu.formas.proyectodatos.conexion.Operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Operaciones op = new Operaciones();
            int id = Integer.parseInt(request.getParameter("id"));
            daoRegistro dao = new daoRegistro();
            dao.eliminar(id);
            response.sendRedirect("ListarRegistro.jsp");
        %>
    </body>
</html>
