import java.util.Date;

public class Reserva {
    private int cantReservas;
    private String codigoUsuario;
    private String cedula;
    private Date fecha;
    private int codigoEspacio;
    private String tipoEspacio;
    private String estado;
    private String motivo;

    public int getCantReservas() {
        return cantReservas;
    }

    public void setCantReservas(int cantReservas) {
        this.cantReservas = cantReservas;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodigoEspacio() {
        return codigoEspacio;
    }

    public void setCodigoEspacio(int codigoEspacio) {
        this.codigoEspacio = codigoEspacio;
    }

    public String getTipoEspacio() {
        return tipoEspacio;
    }

    public void setTipoEspacio(String tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


}
