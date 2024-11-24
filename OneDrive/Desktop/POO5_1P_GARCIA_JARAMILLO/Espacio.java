public class Espacio{
    private int codigoUnico;
    private String tipo;
    private String nombre;
    private int capacidad;
    private String estado;
    private String rolPermitido;

    public int getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(int codigoUnico) {
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