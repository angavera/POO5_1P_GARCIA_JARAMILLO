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

    public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
      
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(linea+"\n");
            System.out.println("ksdsdlsd");

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

    public static ArrayList<Usuario> procesarUsuarios(ArrayList<String> lineas) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
    
        for (String linea : lineas) {
            String[] datos = linea.split("\\|");
    
            
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
    
            switch (rol) {
                case "E" -> {
                    // Validar campos adicionales para estudiantes
                    if (datos.length < 8 ) {
                        System.err.println("Datos incompletos para estudiante en línea: " + linea);
                        continue; // Saltar a la siguiente línea
                    }
                    String matricula = datos[8].trim();
                    String carrera = datos[9].trim();
                    usuarios.add(new Estudiante(codigo, cedula, nombres, apellidos, usuario, contraseña, correo, rol, matricula, carrera));
                }
                case "P" -> {
                    // Validar campos adicionales para profesores
                    if (datos.length < 10) {
                        System.err.println("Datos incompletos para profesor en línea: " + linea);
                        continue; // Saltar a la siguiente línea
                    }
                    String facultad = datos[8].trim();
                    String[] materias = datos[9].trim().split(",");
                    usuarios.add(new Profesor(codigo, cedula, nombres, apellidos, usuario, contraseña, correo, rol, facultad, materias));
                }
                case "A" -> {
                    // Validar campos adicionales para administradores
                    if (datos.length < 9) {
                        System.err.println("Datos incompletos para administrador en línea: " + linea);
                        continue; // Saltar a la siguiente línea
                    }
                    String cargo = datos[8].trim();
                    usuarios.add(new Administrador(codigo, cedula, nombres, apellidos, usuario, contraseña, correo, rol, cargo));
                }
                default -> System.err.println("Rol desconocido en línea: " + linea);
            }
        }
    
        return usuarios;
    }

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
