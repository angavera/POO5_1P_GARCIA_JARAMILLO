import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal{
    private ArrayList<Usuario> usuarios;
    private ArrayList<Espacio> espacios;
    private ArrayList<Reserva> reservas;

    public Principal(){
        this.usuarios = new ArrayList<>();
        this.espacios = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void cargarDatos(){

    }

    public void iniciarSesion(){

    }

    public static void main(String[] args){
        Principal sistema = new Principal();
        sistema. cargarDatos();
        sistema.iniciarSesion();
    }

}


