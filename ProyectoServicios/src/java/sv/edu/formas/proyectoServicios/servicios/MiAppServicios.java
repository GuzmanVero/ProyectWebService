package sv.edu.formas.proyectoServicios.servicios;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("webapi")
public class MiAppServicios extends Application{
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> recursos = new HashSet<>();
        recursos.add(ServicioRegistro.class);
        recursos.add(LoginUsuario.class);
        return recursos;
    }
}
