
package model;

//Clase Nave Lanzadera que hereda de la clase Nave
public class N_Lanzadera extends Nave {

    //Aqui se sobreescriben todos los metodos abstractos de Nave con las funcionalidades de una Nave Lanzadera
    @Override
    public void despegar() {
        
        if (Peso>100000) {
            System.out.println("Imposible despegar con tanto peso");
        } else {
            System.out.println("Nave Lanzadera despegando con exito");
        }
    }   
    
    @Override
    public void aterrizar() {
        System.out.println("Como soy de lanzadera no cuento con tren de aterrizaje");
    }

    @Override
    public void reabastecer() {
        System.out.println("Soy una nave lanzare Reabasteciendome");
    }
    
      //Metodos con sobrecarga
    public void separarse() {
        int n_modulos = 3;
        System.out.println("Me estoy separando en " + n_modulos+ " modulos");
    }
    
    public void separarse(int n) {
        System.out.println("Estoy sobrecargado y me estoy separando en " + n + " modulos");
    }
}


