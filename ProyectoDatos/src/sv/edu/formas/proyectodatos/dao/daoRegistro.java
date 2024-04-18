package sv.edu.formas.proyectodatos.dao;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sv.edu.formas.proyectodatos.conexion.Conexion;
import sv.edu.formas.proyectodatos.conexion.Operaciones;
import sv.edu.formas.proyectodatos.entidad.Registro;

public class daoRegistro {
    private Conexion oConex;
    private List<Registro> lista;
    public daoRegistro(){
        this.lista = new ArrayList<>();
    }
    public List<Registro> getAll(){
        String sql = "SELECT idUsuario, nombre, apellido, residencia, telefono, edad FROM registro";
        Operaciones op = new Operaciones();
        List<Object[]> lst = op.consultar(sql);
        for (int i=0; i< lst.size(); i++){
            Registro re = new Registro();
            re.setIdUsuario(Integer.parseInt(lst.get(i)[0].toString()));
            re.setNombre(lst.get(i)[1].toString());
            re.setApellido(lst.get(i)[2].toString());
            re.setResidencia(lst.get(i)[3].toString());
            re.setTelefono(lst.get(i)[4].toString());
            re.setEdad(lst.get(i)[5].toString());
            this.lista.add(re);
        }
        return this.lista;
    }
    
    public Registro getId(int id){
        String sql = "SELECT idUsuario, nombre, apellido, residencia, telefono, edad FROM registro WHERE idUusuario=" +id;
        Operaciones op = new Operaciones();
        List<Object[]> lst = op.consultar(sql);
        Registro re = new Registro();
        if(lst.size()>0){
         re.setIdUsuario(Integer.parseInt(lst.get(0)[0].toString()));
            re.setNombre(lst.get(0)[1].toString());
            re.setApellido(lst.get(0)[2].toString());
            re.setResidencia(lst.get(0)[3].toString());
            re.setTelefono(lst.get(0)[4].toString());
            re.setEdad(lst.get(0)[5].toString());
        }
        return re;
    }
    public int insertar(Registro reg){
        int r=0;
      String sql = "INSERT INTO registro(nombre,apellido,residencia,telefono,edad) VALUES"
                + "('"+ reg.getNombre()+"','"+ reg.getApellido()+"','"+ reg.getResidencia()+"','"+ reg.getTelefono()+"','"+reg.getEdad()+"')";  
      Operaciones op = new Operaciones();
      r = op.ejecutar(sql);
      return r;
    }
    public int modificar(int id, Registro reg){
        int r=0;
        String sql = "UPDATE registro SET nombre='"+ reg.getNombre()+ "', apellido='"+ reg.getApellido()+ "', residencia='"+ reg.getResidencia()+"', "
                + "telefono='"+reg.getTelefono()+"', edad='"+reg.getEdad()+"' WHERE idUsuario="+ id;
        Operaciones op = new Operaciones();
        r = op.ejecutar(sql);
        return r;
    }
    public int eliminar(int id){
        int r=0;
        String sql ="DELETE FROM registro where idUsuario="+id;
        Operaciones op = new Operaciones();
        r = op.ejecutar(sql);
        return r;
    }
}