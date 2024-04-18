<%-- 
    Document   : EditarRegistro
    Created on : 6 may. 2023, 05:38:32
    Author     : marce
--%>

<%@page import="java.util.List"%>
<%@page import="sv.edu.formas.proyectodatos.entidad.Registro"%>
<%@page import="sv.edu.formas.proyectodatos.dao.daoRegistro"%>
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
            Operaciones op = new Operaciones();
                daoRegistro dao = new daoRegistro();
                List<Registro> lista = dao.getAll();
                for(Registro reg : lista) {         
        %>
        <div class="container">
           <h1>Modificar un registro</h1>
           <hr>
           <form action="" method="POST" class="form-control" style="width: 500px; height: 540px">
            Id: <input type="text" readonly="" id="txtid" name="txtid" class="form-control" value="<%= reg.getIdUsuario()%>"><br><br>
            Nombre: <input type="text" id="txtnombre" name="txtnombre" class="form-control" value=<%= reg.getNombre()%>><br><br>
            Apellido: <input type="text" id="txtapellido" name="txtapellido" class="form-control" value=<%= reg.getApellido()%>><br><br>
            Residencia: <input type="text" id="txtresidencia" name="txtresidencia" class="form-control" value=<%= reg.getResidencia()%>><br><br>
            Telefono: <input type="text" id="txttelefono" name="txttelefono" class="form-control" value=<%= reg.getTelefono()%>><br><br>
            Edad: <input type="text" id="txtedad" name="txtedad" class="form-control" value=<%= reg.getEdad()%>><br><br>
            <input type="submit" value="Guardar" class="btn btn-primary btn-lg">
            <a href='ListarRegistro.jsp' class="btn btn-success btn-lg" >Regresar </a><p>
           </form>
           <%}%>
        </div>
    </body>
</html>
<%
    
            String idStr = request.getParameter("txtid");
            int id = 0;
            if (idStr != null && !idStr.isEmpty()) {
            id = Integer.parseInt(idStr);
            }
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            String residencia = request.getParameter("txtresidencia");
            String telefono = request.getParameter("txttelefono");
            String edad = request.getParameter("txtedad");
            Registro reg = new Registro(id, nombre, apellido, residencia, telefono, edad);
            dao.modificar(id,reg);                  

%>