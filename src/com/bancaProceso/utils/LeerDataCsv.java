package com.bancaProceso.utils;

import com.bancaProceso.model.Transaccion;

/*
 * clases específicas para trabajar archivos
 * File -> verifica la existencia del archivo
 * FileInputStream -> lee archivos de manera secuencial (imagenes, audio o texto)
 * IOException -> señala un error de entrada o salida del archivo.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// BigDecimal -> números decimales de alte precisión
import java.math.BigDecimal;

/*
 * List -> coleccion ordenada de elementos. 
 * ArrayList -> Arraglo dinámico de elementos.
 * Scanner -> lee entradas (archivos,consola,texto, etc).
 */
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
     * El archivo debe tener el siguiente formato
     *  <pre>
     *  id,tipo,monto
     *  1,Crédito,100.00
     *  2,Débito,50.00
     *  </pre>
     * 
     *
     * @param rutaDataCsv Ruta al archivo CSV que contiene las transacciones
     * @return Una lista de transacciones leídas desde el archivo
     * @throws IOException Si ocurre un error al leer el archivo
     */
    public static List<Transaccion> leerCsv(String rutaDataCsv) throws IOException{

        File file = new File(rutaDataCsv);
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scan = new Scanner(fileInputStream,"UTF-8");
        
        // coleccion Transacciones para acceder a sus elementos
        List<Transaccion> transacciones = new ArrayList<>();

        // saltando la primera linea(id, tipo, monto)
        scan.nextLine();

        while (scan.hasNextLine()) {

            // separando los elementos que están entre comas ','
            String[] partes = scan.nextLine().split(",");
            
            // asignando id, tipo, monto 
            int id = Integer.parseInt(partes[0]);
            String tipo = partes[1];
            BigDecimal monto = new BigDecimal(partes[2]);

            Transaccion transaccion = new Transaccion(id, tipo, monto);
            
            // coleccionando objetos
            transacciones.add(transaccion);
        }

        // cerrando el objeto scanner
        scan.close();

        return transacciones;
    }


}
