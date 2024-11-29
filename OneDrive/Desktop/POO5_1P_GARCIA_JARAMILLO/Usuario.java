<<<<<<< HEAD
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
=======
>>>>>>> 46d3ee324f3477c376bae4675dbd643eb126beaa

public abstract class Usuario {
    private String codigoUnico;
    private String cedula;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private String correo;
    private String rol;

    public Usuario(String codigoUnico, String cedula, String nombre, String apellido, String usuario, String password, String correo, String rol){//, String correo, String rol){
        this.codigoUnico = codigoUnico;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
        this.rol = rol;

    }

    public static Date convertirFecha(String fechaUsr){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        formatter.setLenient(false);
        try{
            return formatter.parse(fechaUsr);
        } catch (ParseException e){
            System.out.println("Fecha invalida: "+ fechaUsr);
            return null;
        }
    }

    public abstract void mostrarMenu();
    
    public abstract void reservar();

    public abstract void consultarReserva();

    //public abstract void enviarCorreo(Reserva reserva);

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
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
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public abstract void enviarCorreo(Reserva reserva);
} 
