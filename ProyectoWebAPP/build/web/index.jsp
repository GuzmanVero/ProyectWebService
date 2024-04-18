<%@page import="sv.edu.formas.proyectodatos.entidad.Registro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Registros</h1>
        <%
            List<Registro> ls = (List) request.getAttribute("lista");
            if(ls== null){
            out.println("La peticion se hizo de manera incorrecta");
            }
            else{
                for (int i=0; i<ls.size(); i++) {
                    out.println(ls.get(i) + "<br>");
            }
            }
        %>
    </body>
</html>
