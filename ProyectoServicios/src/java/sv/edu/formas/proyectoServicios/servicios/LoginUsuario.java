
package sv.edu.formas.proyectoServicios.servicios;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.edu.formas.proyectodatos.dao.daoUsuario;
import sv.edu.formas.proyectodatos.entidad.Usuario;

@Path("login")
public class LoginUsuario {
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validar(Usuario us){
        daoUsuario du = new daoUsuario();
        boolean status = du.validar(us.getUsername(), us.getPassword());
        if (status){
            String secret = "miClave";
            long tiempo = System.currentTimeMillis();
            String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .setSubject("Veronica Guzman")
                    .setIssuedAt(new Date(tiempo))
                    .setExpiration(new Date(tiempo+900000))
                    .claim("email", "correo@algo.com")
                    .compact();
            JsonObject json = Json.createObjectBuilder().add("JWT",jwt).build();
            return Response.status(Response.Status.CREATED).entity(jwt).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
