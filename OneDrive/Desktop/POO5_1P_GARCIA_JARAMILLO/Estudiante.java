public class Estudiante extends Usuario{
    private String matricula;
    private String carrera;

    public Estudiante(String codigo, String cedula, String nombre, String apellido, String usuario, String password, String correo, String rol, String matricula, String carrera){
        super(codigo, cedula, nombre, apellido, usuario, password, correo, rol);
        this.matricula = matricula;
        this.carrera = carrera;
    }

    @Override
    public void mostrarMenu(){
        System.out.println("1. Reservar");
        System.out.println("2. Consultar Reserva");
    }

    @Override
    public void reservar(){
        System.out.println("Reservar espacio como estudiante");
    }

    @Override
    public void consultarReserva(){
        System.out.println("Consultar reserva como estudiante");
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

}