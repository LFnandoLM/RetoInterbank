package com.bancaProceso.service;

import java.math.BigDecimal;
import java.util.List;
import com.bancaProceso.model.Transaccion;

/**
* Clase que implementa la logica de procesamiento contable para una lista de transacciones bancarias.
* <p>
* Esta clase calcula el balance final, identifica la transacción con el mayor monto
* y cuenta las transacciones de tipo "Credito" y "Debito".
* </p>
* 
* @author Luis Loli
* @version 1.0
*/

public class ProcesoContable {

    /**
     * Procesa una lista de transacciones realizando los siguientes cálculos:
     * <ul>
     *   <li>Balance final (Creditos - Debitos)</li>
     *   <li>Transaccien de mayor monto</li>
     *   <li>Cantidad de transacciones por tipo</li>
     * </ul>
     *
     * Los resultados son impresos por consola.
     * 
     * @param transacciones Lista de transacciones a procesar
     */

    public static void procesandoCsv(List<Transaccion> transacciones){

        // definiendo valores con código unicode
        // \u00e9 -> representa (   é  )
        final String DEDITO = "D"+"\u00e9"+"bito";
        final String CREDITO = "Cr"+"\u00e9"+"dito";

        int cantCreditos=0,cantDebitos=0,idMayor=0;

        BigDecimal mayorMonto = new BigDecimal(0);
        BigDecimal balance = new BigDecimal(0);

        // recorriendo cada transaccion
        for(Transaccion transaccion : transacciones){
            
            // buscando transacciones de tipo "Crédito" o "Débito" mediante comparación
            // suma el monto de tipo "crédito" y de encontrarse "Débito" procede a restarlo
            if(transaccion.getTipo().equalsIgnoreCase(CREDITO)){
                balance = balance.add(transaccion.getMonto());
                cantCreditos++;
            }else if (transaccion.getTipo().equalsIgnoreCase(DEDITO)){
                balance = balance.subtract(transaccion.getMonto());
                cantDebitos++;
            }

            // hallando el monto mas alto
            // compareTo() --> método de Bigdecimal que retorna:
            // 0  --> a.compareTo(b) --> retorna 0 si a es igual a b
            // -1 --> a.compareTo(b) --> retorna -1 si a es menor a b
            // 1  --> a.compareTo(b) --> retorna 1 si a es mayor a b
            if(transaccion.getMonto().compareTo(mayorMonto) == 1){
                mayorMonto = transaccion.getMonto();
                idMayor = transaccion.getId();
            }

        }

        // imprimiendo resultados en consola
        System.out.println("Reporte de Transacciones");
        System.out.println("---------------------------------------------");
        System.out.println("Balance final: S/."+balance);
        System.out.println("Transaccion de mayor monto: "+"ID "+idMayor+" - S/."+mayorMonto);
        System.out.println("Conteo de transacciones: "+CREDITO+": "+cantCreditos+" "+DEDITO+": "+cantDebitos);
        
    }

}
