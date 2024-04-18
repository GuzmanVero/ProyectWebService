<%-- 
    Document   : ListarRegistro
    Created on : 5 may. 2023, 22:08:49
    Author     : marce
--%>

<%@page import="sv.edu.formas.proyectodatos.conexion.Conexion"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.PreparedStatement;"%>
<%@page import="sv.edu.formas.proyectodatos.entidad.Registro"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="sv.edu.formas.proyectodatos.dao.daoRegistro"%>
<%@page import="sv.edu.formas.proyectodatos.conexion.Operaciones"%>
<%@page import="sv.edu.formas.proyectodatos.conexion.Operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Lista registro</title>
    </head>
    <body>
        <div class="container">
        <h1>Lista de registros</h1>
        <hr>
        <a class="btn btn-success btn-lg" href="Ingresar.jsp">Nuevo Registro</a>
        <hr>
        <table class="table table-bordered">
            <tr>
                <th class="text-center">Id</th>
                <th class="text-center">Nombre</th>
                <th class="text-center">Apellido</th>
                <th class="text-center">Residencia</th>
                <th class="text-center">Telefono</th>
                <th class="text-center">Edad</th>
                <th class="text-center">Acciones</th>
            </tr>
            <%
                Operaciones op = new Operaciones();
                daoRegistro dao = new daoRegistro();
                List<Registro> lista = dao.getAll();
                for(Registro reg : lista) {                  
            %>
            <tr>
                <td class="text-center"><%= reg.getIdUsuario()%></td>
                <td class="text-center"><%= reg.getNombre()%></td>
                <td class="text-center"><%= reg.getApellido()%></td>
                <td class="text-center"><%= reg.getResidencia()%></td>
                <td class="text-center"><%= reg.getTelefono()%></td>
                <td class="text-center"><%= reg.getEdad()%></td>               
                <td class="text-center">
                    <a href="EditarRegistro.jsp?id=<%= reg.getIdUsuario()%>" class="btn btn-warning btn-sm">Editar</a>
                    <a href="EliminarRegistro.jsp?id=<%= reg.getIdUsuario()%>" class="btn btn-danger btn-sm">Eliminar</a>
                </td>
            </tr>
            <%}%>
        </table>
        </div>
    </body>
</html>
