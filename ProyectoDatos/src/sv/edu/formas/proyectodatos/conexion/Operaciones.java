package sv.edu.formas.proyectodatos.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Operaciones {
    private Conexion cn;
    public Operaciones(){
        try {
            this.cn = new Conexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Object[]> consultar(String sql){
        List<Object[]> lst = new ArrayList<>();
        Statement sentencia;
        ResultSet rs = null;
        int colas;
        Object[] filas;
        try {
            sentencia = this.cn.getConexion().createStatement();
            rs = sentencia.executeQuery(sql);
            colas = rs.getMetaData().getColumnCount();
            while (rs.next()){
                filas= new Object[colas];
                for (int i=0; i <colas; i++) {
                    filas[i]= rs.getObject(i+1);
                }
                lst.add(filas);
            }
            this.cn.cerrar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lst;
     }
    public int ejecutar(String sql){
        int nr=0;
        try {
            PreparedStatement ps = this.cn.getConexion().prepareStatement(sql);
            nr = ps.executeUpdate();
            this.cn.cerrar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return nr;
    }
}
