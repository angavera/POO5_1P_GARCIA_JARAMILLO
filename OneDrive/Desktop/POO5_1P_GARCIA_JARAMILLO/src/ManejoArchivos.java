package src;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ManejoArchivos {
    /**
     *  El metodo recibe un String que se traduce como la ruta del archivo donde se va a extraer al informacion
     *  y devuelve un ArrayList de Strings con todas las lineas leidas por el metodo
     * @param nombrearchivo Ruta en formato String
     * @return ArrayList de Strings con las lineas leidas del archivo
     */
    public static ArrayList<String> LeeFichero(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
                

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;

    }
/**
 * El metodo recibe la ruta del archivo en formato String y la linea que quiere escribirse dentro del archivo
 * 
 * @param nombreArchivo Ingresa la ruta del archivo en formato String
 * @param linea Ingresa la linea que se quiere escribir
 */
    public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
      
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(linea+"\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
/**
 * El metodo procesa los usuarios que se encuentran en cada linea de los Archivos
 * @param lineas Ingresa el ArrayList con las lineas del archivo usuarios.txt
 * @return Devuelve el ArrayList de Usuarios que se crean a partir del metodo
 */
    public static ArrayList<Usuario> procesarUsuarios(ArrayList<String> lineas) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
    
        for (String linea : lineas) {
            String[] datos = linea.split(" \\|");
    
            
            if (datos.length < 8) {
                System.err.println("Línea inválida en usuarios.txt: " + linea);
                continue;
            }
    
            String codigo = datos[0].trim();
            String cedula = datos[1].trim();
            String nombres = datos[2].trim();
            String apellidos = datos[3].trim();
            String usuario = datos[4].trim();
            String contraseña = datos[5].trim();
            String correo = datos[6].trim();
            String rol = datos[7].trim();
            System.out.println("Rol detectado: [" + rol + "]"); 
    
            switch (rol) {
                case "E" -> {
                    Estudiante estudiante = new Estudiante(codigo, cedula, nombres, apellidos, usuario, contraseña, correo, rol, null, null);
                    usuarios.add(estudiante);
                }
                case "P" -> {
                    Profesor profesor = new Profesor(codigo, cedula, nombres, apellidos, usuario, contraseña, correo , rol, null, null);
                    usuarios.add(profesor);
                }
                case "A" -> {
                    Administrador administrador = new Administrador(codigo, cedula, nombres, apellidos, usuario, contraseña, correo, rol, null);
                    usuarios.add(administrador);
                }
                default -> System.err.println("Rol desconocido en línea: " + linea);
            }
        }
        return usuarios;
    }
/**
 * El metodo procesa los espacios que se encuentran en cada linea de los Archivos
 * @param lineas Ingresa el ArrayList con las lineas del archivo espacios.txt
 * @return Devuelve el ArrayList de Espacios que se crean a partir del metodo
 */
    public static ArrayList<Espacio> procesarEspacios(ArrayList<String> lineas) {
        ArrayList<Espacio> espacios = new ArrayList<>();
        for (String linea : lineas) {
            String[] datos = linea.split("\\|");
            String codigo = datos[0].trim();
            String tipo = datos[1].trim();
            String nombre = datos[2].trim();
            int capacidad = Integer.parseInt(datos[3].trim());
            String estado = datos[4].trim();
            String rolPermitido = datos[5].trim();
            espacios.add(new Espacio(codigo, tipo, nombre, capacidad, estado, rolPermitido));
        }
        return espacios;
    }
/**
 * El metodo procesa las reservas que se encuentran en cada linea de los Archivos
 * @param lineas Ingresa el ArrayList con las lineas del archivo reservas.txt
 * @return Devuelve el ArrayList de Reservas que se crean a partir del metodo
 */
    public static ArrayList<Reserva> procesarReservas(ArrayList<String> lineas) {
    ArrayList<Reserva> reservas = new ArrayList<>();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
    for (String linea : lineas) {
        try {
            String[] datos = linea.split("\\|");
            String codigoReserva = datos[0].trim();
            String codigoUsuario = datos[1].trim();
            String cedulaUsuario = datos[2].trim();
            Date fechaReserva = formatoFecha.parse(datos[3].trim());
            String codigoEspacio = datos[4].trim();
            String tipoEspacio = datos[5].trim();
            String estado = datos[6].trim();
            String motivo = datos[7].trim();
            reservas.add(new Reserva(codigoUsuario, cedulaUsuario, fechaReserva, codigoEspacio, tipoEspacio, estado, motivo));
        } catch (ParseException e) {
            System.err.println("Error al procesar una reserva: " + e.getMessage());
        }
    }
    return reservas;
}


    
    
}
