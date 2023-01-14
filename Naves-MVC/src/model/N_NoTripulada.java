
package model;

/**
 *
 * @author juand
 */

//Clase Nave No Tripulada que hereda de la clase Nave
public class N_NoTripulada extends Nave {

    //Se reescriben todos los metodos abstractos con las funcionalidades especificas de una nave no tripulada
    @Override
    public void despegar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aterrizar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void reabastecer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
