package com.bancaProceso.utils;

import com.bancaProceso.model.Transaccion;

//paquete con clases específicas para trabajar con archivos
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// BigDecimal -> números decimales de alta precisión
import java.math.BigDecimal;

// paquete standart de java para uso de colecciones -> List, ArrayList
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Clase de utilidad para leer archivos CSV que contienen transacciones bancarias.
 * <p>
 * Esta clase convierte las líneas de un archivo CSV en objetos {@link Transaccion}.
 * </p>
 * 
 * @author Luis Loli
 * @version 1.0
 */

public class LeerDataCsv {

    /**
     * Lee un archivo CSV con transacciones bancarias y devuelve una lista de objetos {@link Transaccion}.
     *
     * @param rutaDataCsv Ruta al archivo CSV que contiene las transacciones
     * @return Una lista de transacciones leídas desde el archivo
     * @throws IOException Si ocurre un error al leer el archivo
     */
    public static List<Transaccion> leerCsv(String rutaDataCsv) throws IOException{

        //verificando la existencia del archivo a trabajar
        File file = new File(rutaDataCsv);
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scan = new Scanner(fileInputStream,"UTF-8");
        
        List<Transaccion> transacciones = new ArrayList<>();

        // saltando la primera linea(id, tipo, monto)
        scan.nextLine();

        while (scan.hasNextLine()) {

            // separando los elementos id, tipo, monto
            String[] partes = scan.nextLine().split(",");
            
            int id = Integer.parseInt(partes[0]);
            String tipo = partes[1];
            BigDecimal monto = new BigDecimal(partes[2]);

            // coleccionando objetos
            Transaccion transaccion = new Transaccion(id, tipo, monto);
            transacciones.add(transaccion);
        }

        // cerrando el objeto scanner
        scan.close();

        return transacciones;
    }


}
