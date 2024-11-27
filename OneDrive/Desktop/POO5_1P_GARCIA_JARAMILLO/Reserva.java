
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Date;
import javax.mail.*;
import io.githhub.cdimascio.Dotenv.*;
import java.util.Properties;

public class Reserva extends Usuario{
    private static int cantReservas = 0;
    private String codigoReserva;
    private String codigoUsuario;
    private String cedulaUsuario;
    private Date fecha;
    private String codigoEspacio;
    private String tipoEspacio;
    private String estado;
    private String motivo;

    public Reserva(String codigoUnico, String cedula, String nombre, String apellido, String usuario, String password, String correo, String rol,String codigoUsuario, String cedulaUsuario, Date fecha, String codigoEspacio, String tipoEspacio, String estado, String motivo){
        super(codigoUnico, cedula, nombre, apellido, cedulaUsuario, password, correo, rol);
        this.codigoReserva = String.format("%05d", ++cantReservas);
        this.codigoUsuario = codigoUsuario;
        this.cedulaUsuario = cedulaUsuario;
        this.fecha = fecha;
        this.codigoEspacio = codigoEspacio;
        this.tipoEspacio = tipoEspacio;
        this.estado = estado;
        this.motivo = motivo;
    }

    public int getCantReservas() {
        return cantReservas;
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

    //me falta el espacio 
    public void enviarCorreo(Reserva reserva){
        String ln1="El estudiante"+this.getNombre()+" y apellido"+this.getApellido()+" Ha realizado una reserva con codigo"+reserva.getCodigoReserva()+" para la fecha "+reserva.getFecha()+" en la"+reserva.get();
        String ln2 = "Ingrese al sistema para aprobar o rechazar la reserva";
String linea = ln1 + "\n"+ ln2;
        Dotenv dot = Dotenv.load();
        String host = dot.get("MAIL_HOST");
        String port = dot.get("MAIL_PORT");
        String user = dot.get("MAIL_USER");
        String pass = dot.get("MAIL_PASS");

        Properties prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);
   
        Session session = Session.getInstance(prop, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(user,pass);
}
});
try {
    Message mes = new MimeMessage(session);
    mes.setFrom(new InternetAddress(user, "APP RESERVAS"));
    mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.getCorreo()));
    mes.setSubject("Reserva realizada");
    mes.setText(linea);
    Transport.send(mes);
    } catch(Exception e){
    System.out.println(e.getMessage());
    
    }
}

    @Override
    public void mostrarMenu() {
    }

    @Override
    public void reservar() {
       
    }

    @Override
    public void consultarReserva() {
        
    }

}
