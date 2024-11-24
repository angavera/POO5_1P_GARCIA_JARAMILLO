import java.util.List;
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

}