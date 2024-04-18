package sv.edu.formas.proyectodatos.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection conexion;
    public Conexion(){
        String driver, usuario, clave, url;
        Configuracion cnf = new Configuracion("conexionBD.txt");
        driver = System.getProperty("driver");
        usuario = System.getProperty("usuario");
        clave = System.getProperty("clave");
        url = System.getProperty("url");
        try {
            Class.forName(driver);
            this.conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Connection getConexion(){
        return this.conexion;
    }
    public void cerrar(){
        try {
            this.conexion.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
