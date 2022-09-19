import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Lista que almacena archivos
        File[] pathList;
        // Scanner
        Scanner sc = new Scanner(System.in);

        // Solicitamos un path por consola y cerramos el scanner
        System.out.println("Introduzca un path: ");
        String pathReader = sc.nextLine();
        sc.close();
        // Creamos la variable que almacena el path introducido, de tipo File
        File path = new File(pathReader);
        // LLenamos la lista creada con los archivos del path
        pathList = path.listFiles();

        // Creamos un if para evitar errores, nos aseguramos que el path introducido sea real.
        if (pathList != null) {
            // Generamos un for que recorra la lista ya rellena
            for (File pathArchives : pathList) {
                // He decidido crear variables para no petar el sout de mas abajo, no se si sera lo mas correcto.
                // Primero, conseguimos los nombres de los archivos; luego preparamos los String para otros datos.
                String archivesName = pathArchives.getName();
                String archivesRead;
                String archivesWrite;
                long archivesSpace = pathArchives.length();
                // Preparamos los Boolean (los metodos usados devuelven eso), y usando los anteriores String, lo preparo usando un par de if.
                Boolean archivesReadBol = pathArchives.canRead();
                Boolean archivesWriteBol = pathArchives.canWrite();
                if (archivesReadBol.equals(true)) {
                    archivesRead = " | Permite lectura";
                } else {
                    archivesRead = " | No permite lectura";
                }
                if (archivesWriteBol.equals(true)) {
                    archivesWrite = " | Permite escritura";
                } else {
                    archivesWrite = " | No permite escritura";
                }
                // sout con todos los datos de los archivos
                System.out.println(archivesName + " | Tamanio en byte: " + archivesSpace + archivesRead + archivesWrite);
            }
        } else {
            System.out.print("Error en el Path introducido");
        }

    }


}
