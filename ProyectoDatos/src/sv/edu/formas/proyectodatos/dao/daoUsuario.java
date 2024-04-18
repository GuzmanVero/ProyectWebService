package sv.edu.formas.proyectodatos.dao;

import java.util.List;
import sv.edu.formas.proyectodatos.conexion.Operaciones;

public class daoUsuario {
    public boolean validar(String us, String pw){
        boolean r=false;
        String sql = "SELECT username FROM usuario WHERE username='" + us + "' AND password=MD5('" + pw+ "')";
        Operaciones op = new Operaciones();
        List<Object[]> lst = op.consultar(sql);
        if (lst.size()>0)
            r = true;
        return r;
    }

}
