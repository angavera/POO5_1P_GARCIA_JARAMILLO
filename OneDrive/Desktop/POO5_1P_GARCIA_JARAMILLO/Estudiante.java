import java.util.Scanner;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
//import io.github.cdimascio.dotenv.Dotenv;
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
        Scanner sc =new Scanner(System.in);
        int opcion;
        do{
            System.out.println("\n===== Menu Estudiante =====");
            System.out.println("1. Reservar Espacio");
            System.out.println("2. Consultar Reserva");
            System.out.println("3. Cerrar Sesion");
            System.out.println("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1 -> this.reservar();
                case 2 -> this.consultarReserva();
                case 3 -> System.out.println("Cerrando Sesion");
                default -> System.out.println("Opcion no valida. Intente de nuevo");
            }
        } while (opcion != 3);
    }

    @Override
    public void reservar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("==========Reservar espacio==========");
        System.out.println("Ingrese la fecha de reserva (yyyy-mm-dd): ");
        String fechaUsr = sc.nextLine();
        Date fechaReserva = convertirFecha(fechaUsr);
        if(fechaReserva !=  null){
            System.out.println("Fecha valida: "+ fechaReserva);
        }

        System.out.println("Espacios disponibles para estudiantes: ");
        for(Espacio espacio : Sistema.espacios){
            if(espacio.getRolPermitido().equalsIgnoreCase("ESTUDIANTE") || espacio.getRolPermitido().equalsIgnoreCase("AMBOS")){
                if(espacio.getEstado().equalsIgnoreCase("DISPONIBLE")){
                    System.out.println(espacio.getCodigoUnico() + " - " + espacio.getNombre() + "(Tipo: " + espacio.getTipo() + ", Capacidad: " + espacio.getCapacidad() + ")");
                }
            }
            }

            System.out.println("Ingrese el codigo el espacio a reservar: ");
            String codigoEspacio = sc.nextLine();
            Espacio espacioSeleccionado = null;
            for(Espacio espacio : Sistema.espacios){
                if(espacio.getCodigoUnico().equals(codigoEspacio)){
                    espacioSeleccionado = espacio;
                    break;
                }
            }

            if(espacioSeleccionado == null){
                System.out.println("Espacio no encontrado. Intente de nuevo.");
                return;
            }

            System.out.println("Ingreseel motivo de la reserva: ");
            String motivo = sc.nextLine();

            System.out.println("Desea confirmar esta reserva? (S/N): ");
            String conf = sc.nextLine();
            if(!conf.equalsIgnoreCase("S")){
                System.out.println("Reserva cancelada.");
                return;
            }
            
            Reserva newReserva =  new Reserva(this.getCodigoUnico(),this.getCedula(), fechaReserva, espacioSeleccionado.getCodigoUnico(), espacioSeleccionado.getTipo(), "PENDIENTE", motivo);
            Sistema.reservas.add(newReserva);
            espacioSeleccionado.setEstado("RESERVADO");

            System.out.println("Reserva creada. Un administrador revisara su solicitud");
        }
        

    @Override
    public void consultarReserva(){
        Scanner sc = new Scanner(System.in);
        System.out.println("======= Consultar Reserva =======");

        System.out.println("Ingrese la fecha de la reserva a consultar (yyyy-mm-dd): ");
        String fechaUsr = sc.nextLine();
        Date fechaConsulta = convertirFecha(fechaUsr);
        
        boolean reservaEncontrada = false;
        for(Reserva reserva : Sistema.reservas){
            if(reserva.getCodigoUsuario().equals(this.getCodigoUnico()) && reserva.getFecha().equals(fechaConsulta)){
                System.out.println("Reserva encontrada: ");
                System.out.println("Codigo: " + reserva.getCodigoReserva());
                System.out.println("Fecha: " + reserva.getFecha());
                System.out.println("Espacio: " + reserva.getTipoEspacio() + " - " + reserva.getCodigoEspacio());
                System.out.println("Estado: " + reserva.getEstado());
                System.out.println("Motivo: " + reserva.getMotivo());
                reservaEncontrada = true;
            }
        }

        if(!reservaEncontrada){
            System.out.println("No se encontraron reservas para esa fecha.");
        }
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