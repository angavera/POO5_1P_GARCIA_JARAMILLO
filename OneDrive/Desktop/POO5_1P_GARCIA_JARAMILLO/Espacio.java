public class Espacio{
    private String codigoUnico;
    private String tipo;
    private String nombre;
    private int capacidad;
    private String estado;
    private String rolPermitido;

    public Espacio(String codigoUnico, String tipo, String nombre, int capacidad, String estado, String rolPermitido){
        this.codigoUnico = codigoUnico;
        this.tipo = tipo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
        this.rolPermitido = rolPermitido;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRolPermitido() {
        return rolPermitido;
    }

    public void seetRolPermitido(String rolPermitido) {
        this.rolPermitido = rolPermitido;
    }

}