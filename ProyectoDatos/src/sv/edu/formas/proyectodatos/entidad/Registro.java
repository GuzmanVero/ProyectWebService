package sv.edu.formas.proyectodatos.entidad;

public class Registro {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String residencia;
    private String telefono;
    private String edad;

    public Registro() {
    }

    public Registro(String nombre, String apellido, String residencia, String telefono, String edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.residencia = residencia;
        this.telefono = telefono;
        this.edad = edad;
    }

    public Registro(int idUsuario, String nombre, String apellido, String residencia, String telefono, String edad) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.residencia = residencia;
        this.telefono = telefono;
        this.edad = edad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    @Override
   public String toString(){
       return nombre +" "+ apellido+" "+ residencia+" "+ telefono+" "+ edad;
   }
}
