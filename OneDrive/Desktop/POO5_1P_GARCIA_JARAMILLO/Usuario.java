
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

    public abstract void mostrarMenu();
    
    public abstract void reservar();

    public abstract void consultarReserva();

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
