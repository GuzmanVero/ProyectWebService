<%-- 
    Document   : Ingresar
    Created on : 5 may. 2023, 18:20:08
    Author     : marce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Ingresar registro</title>
    </head>
    <body>
        <div class="container">
           <h1>Ingrese el nuevo registro</h1>
           <hr>
           <form action="GuardarRegistro.jsp" method="POST" class="form-control" style="width: 500px; height: 540px">
            Nombre: <input type="text" id="txtnombre" name="txtnombre" class="form-control"><br><br>
            Apellido: <input type="text" id="txtapellido" name="txtapellido" class="form-control"><br><br>
            Residencia: <input type="text" id="txtresidencia" name="txtresidencia" class="form-control"><br><br>
            Telefono: <input type="text" id="txttelefono" name="txttelefono" class="form-control"><br><br>
            Edad: <input type="text" id="txtedad" name="txtedad" class="form-control"><br><br>
            <input type="submit" value="Guardar" class="btn btn-primary btn-lg">
            <a href='ListarRegistro.jsp' class="btn btn-success btn-lg" >Ver Registros</a><p>
           </form>
        </div>
    </body>
</html>
