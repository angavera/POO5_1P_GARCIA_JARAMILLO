package src;
import java.util.ArrayList;
import  java.util.Scanner;

public class Administrador extends Usuario{
    private String cargo;

    public Administrador(String codigo, String cedula, String nombre, String apellido, String usuario, String password, String correo, String rol,  String cargo){
        super(codigo, cedula, nombre, apellido, usuario, password, correo, rol);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
/**
 * El metodo muestra el menu Gestionar Reservas exclusivo de los administradores
 * @param reservas Ingresa un ArrayList de las reservas
 * @param usuarios Ingresa un ArrayList de usuarios
 */
    public void gestionarReservas(ArrayList<Reserva> reservas, ArrayList<Usuario> usuarios){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n ===== Gestionar Reservas =====");
        System.out.println("Reservas pendientes: ");
        for (Reserva reserva : reservas){
            if(reserva.getEstado().equalsIgnoreCase("PENDIENTE")){
                System.out.println("Codigo: " + reserva.getCodigoReserva() + ", Fecha: " + reserva.getFecha() + ", Espacio: " + reserva.getTipoEspacio() + " - " + reserva.getCodigoEspacio() + ", Usuario: " + reserva.getCedulaUsuario());

            }
        }

        System.out.println("Ingrese el codigo de la reserva a gestionar: ");
        String codigoReserva = sc.nextLine();
        Reserva reservaSelec = null;
        for(Reserva reserva : reservas){
            if(reserva.getCodigoReserva().equals(codigoReserva)){
                reservaSelec = reserva;
                break;
            }
        }

        if(reservaSelec == null){
            System.out.println("No se encontro la reserva con el codigo ingresado: ");
            return;
        }

        System.out.println("Detalles de la reserva:");
        System.out.println("Código: " + reservaSelec.getCodigoReserva());
        System.out.println("Fecha: " + reservaSelec.getFecha());
        System.out.println("Espacio: " + reservaSelec.getTipoEspacio() + " - " + reservaSelec.getCodigoEspacio());
        System.out.println("Estado: " + reservaSelec.getEstado());

        System.out.print("¿Desea aprobar (A) o rechazar (R) esta reserva?: ");
        String decision = sc.nextLine();
        if (decision.equalsIgnoreCase("A")) {
            reservaSelec.setEstado("APROBADO");
            System.out.println("Reserva aprobada.");
        } else if (decision.equalsIgnoreCase("R")) {
            System.out.print("Ingrese el motivo del rechazo: ");
            String motivoRechazo = sc.nextLine();
            reservaSelec.setEstado("RECHAZADO");
            System.out.println("Reserva rechazada por: " + motivoRechazo);
        } else {
            System.out.println("Decisión no válida. Intente de nuevo.");
        }
    }
/**
 * El metodo muestra el menu de Administrador para consultar las reservas de otros usuarios
 * @param reservas Ingresa un ArrayList de reservas
 * @param usuarios Ingresa un ArrayList de usuarios
 */
    public void consultarReservaAdmin(ArrayList<Reserva> reservas, ArrayList<Usuario> usuarios){
        System.out.println("\n=== Consultar Reservas ===");
        System.out.println("Número total de reservas creadas: " + Reserva.getCantReservas());

        for(Reserva reserva : reservas){
            String infoUsr = "";
            for(Usuario usuario : usuarios){
                if(usuario.getCodigoUnico().equals(reserva.getCodigoUsuario())){
                    if(usuario instanceof Estudiante){
                        infoUsr = usuario.getNombre() + " " + usuario.getApellido() + "(Matricula: )" + ((Estudiante)usuario).getMatricula() + ")"; 
                    } else if(usuario instanceof Profesor){
                        infoUsr = usuario.getNombre() + " " + usuario.getApellido() + "(Materia: )" + reserva.getMotivo() + ")";
                    }
                    break;
                }
            }
            System.out.println("Código: " + reserva.getCodigoReserva() + ", Estado: " + reserva.getEstado() + ", Fecha: " + reserva.getFecha() + ", Usuario: " + infoUsr);

        }

    
    }

    @Override
    public void reservar(){
        System.out.println("Los administradores no realizan reservas");
    }

    @Override
    public void consultarReserva(){
        System.out.println("Consultar en el menu administrador");
    }
/**
 * El metodo muestra el Menu para profesores y las opciones de acciones que tiene para realizar
 * @param reservas Ingresa un ArrayList de reservas
 * @param usuarios Ingresa un ArrayList de usuarios
 */
    public void mostrarMenu(ArrayList<Reserva> reservas, ArrayList<Usuario> usuarios){
        Scanner sc =new Scanner(System.in);
        int opcion;
        do{
            System.out.println("\n===== Menu Administrador =====");
            System.out.println("1. Gestionar Reservas");
            System.out.println("2. Consultar Reservas");
            System.out.println("3. Cerrar Sesion");
            System.out.println("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1 -> this.gestionarReservas(reservas, usuarios);
                case 2 -> this.consultarReserva();
                case 3 -> System.out.println("Cerrando Sesion");
                default -> System.out.println("Opcion no valida. Intente de nuevo");
            }
        } while (opcion != 3);
    }

    @Override
    public void mostrarMenu(){
        System.out.println("Debe ingresar lista de usuarios y reservas");
    }
}