package sv.edu.formas.proyectoServicios.servicios;

import io.jsonwebtoken.Jwts;
import java.util.Base64;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.edu.formas.proyectodatos.dao.daoRegistro;
import sv.edu.formas.proyectodatos.entidad.Registro;

@Path("registro")
public class ServicioRegistro {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarTodo(@HeaderParam("Authorization") String token){
        //@HeaderParam("Authorization") String token
        //String token ="";
        if (token != null){
            String _token = token.substring(7, token.length());
            System.out.println("Token " + _token);
            String datos[] = _token.split("\\.");
            Base64.Decoder decodificador = Base64.getUrlDecoder();
            try {
            Jwts.parser().setSigningKey("miClave").parseClaimsJws(_token);
            System.out.println("Esta autorizado");
            System.out.println("Payload " + new String(decodificador.decode(datos[1])));    
                daoRegistro dr = new daoRegistro();
                return  Response.status(Response.Status.OK).entity(dr.getAll()).build();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return  Response.status(Response.Status.UNAUTHORIZED).build();
            }
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarIdPath(@PathParam("id") int id){
        daoRegistro dr = new daoRegistro();
        Registro reg = new Registro();        
            return Response.status(Response.Status.OK).entity(reg).build();
        
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response agregarRegistro(@FormParam("nom") String nom, @FormParam("ape") String ape, @FormParam("resi") String resi,
            @FormParam("tel") String tel, @FormParam("edad") String edad){
        Registro re = new Registro();
        re.setNombre(nom);
        re.setApellido(ape);
        re.setResidencia(resi);
        re.setTelefono(tel);
        re.setEdad(edad);
        daoRegistro dr = new daoRegistro();
        if (dr.insertar(re)>0) {
            return  Response.status(Response.Status.CREATED).build();
        }
        else
            return Response.status(Response.Status.GONE).build();
    }
    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificarRegistro(@FormParam("id") int id, @FormParam("nom") String nom, @FormParam("ape") String ape, @FormParam("resi") String resi,
            @FormParam("tel") String tel, @FormParam("edad") String edad){
        Registro re = new Registro();
        re.setNombre(nom);
        re.setApellido(ape);
        re.setResidencia(resi);
        re.setTelefono(tel);
        re.setEdad(edad);
        daoRegistro dr = new daoRegistro();
        if (dr.modificar(id, re)>0)
           return  Response.status(Response.Status.OK).build();
        else
            return  Response.status(Response.Status.GONE).build();
    }
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarRegistro(@FormParam("id") int id){
       daoRegistro dr = new daoRegistro();
       if(dr.eliminar(id)>0)
           return  Response.status(Response.Status.OK).build();
        else
            return  Response.status(Response.Status.GONE).build();
    }
}
//Operaciones de escritura
