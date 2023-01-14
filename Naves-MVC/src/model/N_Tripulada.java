
package model;

/**
 *
 * @author juand
 */

//Clase Nave Tripulada que hereda de la clase Nave
public class N_Tripulada extends Nave {

    //Se sobreescriben todos los metodos abstractos de la clase Nave con las funcionalidades especificas para Nave Tripulada
    @Override
    public void despegar() {
        System.out.println("Nave Tripulada despegando");
    }

    @Override
    public void aterrizar() {
        System.out.println("Nave Tripulada Aterrizando");
    }

    @Override
    public void reabastecer() {
        System.out.println("Como soy nave tripulada se puede reabastecer combustible de forma manual");
    }
    
}
