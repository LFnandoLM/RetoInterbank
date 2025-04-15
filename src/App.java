import java.io.IOException;
import java.util.List;

// incorporando las clases principales de cada módulo
import com.bancaProceso.model.Transaccion;
import com.bancaProceso.service.ProcesoContable;
import com.bancaProceso.utils.LeerDataCsv;

/**
 * Clase principal que ejecuta la aplicación de procesamiento de transacciones bancarias.
 * <p>
 * Esta clase lee un archivo CSV con transacciones, las convierte en objetos y 
 * llama al proceso contable para procesarlas e imprimir un reporte.
 * </p>
 * 
 * @author Luis Loli
 * @version 1.0
 */
public class App {

    /**
     * Punto de entrada del programa.
     * <p>
     * Este metodo intenta leer un archivo CSV con datos de transacciones
     * y luego procesarlas para generar un resumen. Si ocurre un error al leer
     * el archivo, se captura y muestra en consola.
     * </p>
     * 
     * @param args Argumentos de linea de comandos
     * @throws Exception Lanza una excepcion en caso de errores generales no manejados.
     */

    public static void main(String[] args) throws Exception {
        try{
            // Obteniendo la colección de transacciones desde un archivo CSV
            List<Transaccion> transacciones = LeerDataCsv.leerCsv("resources/data.csv");

            // procesando la coleccion de Transaccion
            ProcesoContable.procesandoCsv(transacciones);

        }catch(IOException e){
            System.out.println("error: "+e.getMessage());
        }
    }
}
