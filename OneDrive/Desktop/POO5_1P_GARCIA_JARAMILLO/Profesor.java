
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Properties;
public class Profesor extends Usuario{
    private String facultad;
    private List<String> materias;

    public Profesor(String codigo, String cedula, String nombre, String apellido, String usuario, String password, String correo, String rol,  String facultad, List<String> materias ){
        super(codigo, cedula, nombre, apellido, usuario, password, correo, rol);
        this.facultad = facultad;
        this.materias = materias;
    }

    @Override
    public void mostrarMenu(){
        System.out.println("1. Reservar");
        System.out.println("2. Consultar Reserva");
    }

    @Override
    public void reservar(){
        System.out.println("Reservar espacio como profesor");
    }

    @Override
    public void consultarReserva(){
        System.out.println("Consultar reserva como profesor");
    }


    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public List<String> getMaterias() {
        return materias;
    }

    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }
    @Override
     public void enviarCorreo(Reserva reserva){
        String ln1="El profesor"+this.getNombre()+" y apellido"+this.getApellido()+" Ha realizado una reserva con codigo"+reserva.getCodigoReserva()+" para la fecha "+reserva.getFecha()+" en la"+reserva.getTipoEspacio()+"para la materia"+this.getMaterias;
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

}