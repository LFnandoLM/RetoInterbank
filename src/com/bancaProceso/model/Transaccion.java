package com.bancaProceso.model;

import java.math.BigDecimal;


 /**
 * Clase que representa una transaccion bancaria.
 * contiene:
 * <p> id  IDENTIFICADOR DE OPERACION</p>
 * <p> TIPO  CREDITO O DEBITO</p>
 * <p> monto  MONTO DE LA TRANSACCION</p>
 * 
 * 
 * @author Luis Loli
 * @version 1.0
 */


public class Transaccion {
    
    private int id;
    private String tipo;

    //MANEJO DE PRESICIONES DECIMALES DON BigDecimal
    private BigDecimal monto;

    /**
     * Crea una nueva transacción.
     *
     * @param id    Identificador de la transaccion
     * @param tipo  Tipo de la transaccion (Credito o Debito)
     * @param monto Monto de la transaccion
     */
    public Transaccion(int id, String tipo, BigDecimal monto){
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
    }

    
    /**
     * Retorna el ID de la transacción.
     *
     * @return id
     */
    public int getId(){
        return id;
    }


    /**
     * Retorna el tipo de la transaccion (credito o debito).
     *
     * @return tipo
     */
    public String getTipo(){
        return tipo;
    }


    /**
     * Retorna el monto de la transaccion.
     *
     * @return monto
     */
    public BigDecimal getMonto(){
        return monto;
    }

    /**
     * Retorna la información del objeto transaccion.
     * se obtiene solo llamando al objeto
     * 
     * @return toString()
     */

    @Override
    public String toString(){
        return "ID - "+id+" - "+tipo+" - S/."+monto;
    }
}
