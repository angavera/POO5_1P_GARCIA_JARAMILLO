
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

public class Reserva{
    private static int cantReservas = 0;
    private String codigoReserva;
    private String codigoUsuario;
    private String cedulaUsuario;
    private Date fecha;
    private String codigoEspacio;
    private String tipoEspacio;
    private String estado;
    private String motivo;

    public Reserva(String codigoUsuario, String cedulaUsuario, Date fecha, String codigoEspacio, String tipoEspacio, String estado, String motivo){
        this.codigoReserva = String.format("%05d", ++cantReservas);
        this.codigoUsuario = codigoUsuario;
        this.cedulaUsuario = cedulaUsuario;
        this.fecha = fecha;
        this.codigoEspacio = codigoEspacio;
        this.tipoEspacio = tipoEspacio;
        this.estado = estado;
        this.motivo = motivo;
    }

    public static int getCantReservas() {
        return cantReservas;
    }

    public static void setCantReservas(int cantReservas) {
        cantReservas += 1;
    }

    public String getCodigoReserva(){
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva){
        this.codigoReserva = codigoReserva;
    }
    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCedulaUsuario() {
        return cedulaUsuario;
    }

    public void setCedulaUsuario(String cedulaUsuario) {
        this.cedulaUsuario = cedulaUsuario;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodigoEspacio() {
        return codigoEspacio;
    }

    public void setCodigoEspacio(String codigoEspacio) {
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
