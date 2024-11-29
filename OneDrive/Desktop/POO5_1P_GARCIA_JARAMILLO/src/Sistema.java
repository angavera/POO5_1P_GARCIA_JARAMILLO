package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Sistema{
    public static ArrayList<Usuario> usuarios;
    public static ArrayList<Espacio> espacios;
    public static ArrayList<Reserva> reservas;

    public Sistema(){
        this.usuarios = new ArrayList<>();
        this.espacios = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void iniciarSesion(){
        Scanner sc = new Scanner(System.in);

        System.out.println("===== Sistema de Reserva de Espacios =====");
        System.out.println("Ingrese su usuario: ");
        String usuarioIn = sc.nextLine();
        System.out.println("Inrese su contraseña: ");
        String passwordIn = sc.nextLine();

        Usuario usuario = null;
        for(Usuario u : usuarios){
            if(u.getUsuario().equals(usuarioIn) && u.getPassword().equals(passwordIn)){
                usuario = u;
                break;
            }
        }

        if(usuario == null){
            System.out.println("Usuario o contraseña incorrectos.Intente nuevamente.");
            return;
        }

        if(usuario instanceof Estudiante){
            Estudiante e = (Estudiante)usuario;
            e.mostrarMenu();;
        } else if (usuario instanceof Profesor){
            Profesor p = (Profesor)usuario;
            p.mostrarMenu();
        } else if (usuario instanceof Administrador){
            Administrador a = (Administrador)usuario;
            a.mostrarMenu(reservas, usuarios);
        }

    }

/**
 * El programa principal realiza la conversion de datos de los Archivos a ArrayLists con
 * los metodos creados en ManejoArchivos, luego prrocesa los usuarios para poderlos leer
 * y por ultimo realiza el inicio de sesion de los usuarios
 * @param args
 */
    public static void main(String[] args){
        Sistema sistema = new Sistema();
        ArrayList<String> lineasUsuarios = ManejoArchivos.LeeFichero("src/usuarios.txt");
        ArrayList<String> lineasEspacios = ManejoArchivos.LeeFichero("src/espacios.txt");
        ArrayList<String> lineasReservas = ManejoArchivos.LeeFichero("src/reservas.txt");

        usuarios = ManejoArchivos.procesarUsuarios(lineasUsuarios);
        espacios = ManejoArchivos.procesarEspacios(lineasEspacios);
        reservas = ManejoArchivos.procesarReservas(lineasReservas);
        System.out.println(usuarios);
        System.out.println(espacios);
        System.out.println(reservas);

        
        
        sistema.iniciarSesion();
    }

}


