<%-- 
    Document   : GuardarRegistro
    Created on : 5 may. 2023, 18:39:05
    Author     : marce
--%>

<%@page import="sv.edu.formas.proyectodatos.entidad.Registro"%>
<%@page import="sv.edu.formas.proyectodatos.dao.daoRegistro"%>
<%@page import="sv.edu.formas.proyectodatos.dao.daoRegistro"%>
<%@page import="sv.edu.formas.proyectodatos.conexion.Operaciones"%>
<%@page import="sv.edu.formas.proyectodatos.conexion.Operaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
        try {
                    String nombre = request.getParameter("txtnombre");
                    String apellido = request.getParameter("txtapellido");
                    String residencia = request.getParameter("txtresidencia");
                    String telefono = request.getParameter("txttelefono");
                    String edad = request.getParameter("txtedad");
                    Operaciones op = new Operaciones();
                    daoRegistro dr = new daoRegistro();
                    Registro reg = new Registro(nombre, apellido, residencia, telefono, edad);
                    dr.insertar(reg);                  
                } catch (Exception e) {
                 out.print("Ha ocurrido un error. Contacte al Administrador.  "+ e);
                }
        %>
        <h1>Registro guardado correctamente</h1><p>
        <a class="btn btn-success btn-lg" href='ListarRegistro.jsp'>Consultar todos los registros</a>
    </body>
</html>
