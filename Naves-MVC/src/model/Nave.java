
package model;

//Clase Principal Nave
public abstract class Nave {
    String Nombre;
    int Potencia;
    int Empuje;
    float Velocidad;
    float Altura;
    String Pais;
    float Peso;
    String Tipo;
    String Combustible;

    //Constructores de la Clase Nave
    public Nave() {
    }    
  
    public Nave(String Nombre, int Potencia, int Empuje, float Velocidad, float Altura, String Pais, float Peso, String Tipo,String Combustible) {
        this.Nombre = Nombre;
        this.Potencia = Potencia;
        this.Empuje = Empuje;
        this.Velocidad = Velocidad;
        this.Altura = Altura;
        this.Pais = Pais;
        this.Peso = Peso;
        this.Tipo = Tipo;
        this.Combustible = Combustible;
    }

    //Metodos getters para atributos de Nave
    public String getNombre() {
        return Nombre;
    }    

    public int getPotencia() {
        return Potencia;
    }

    public int getEmpuje() {
        return Empuje;
    }

    public float getVelocidad() {
        return Velocidad;
    }

    public float getAltura() {
        return Altura;
    }

    public String getPais() {
        return Pais;
    }

    public float getPeso() {
        return Peso;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getCombustible() {
        return Combustible;
    }
    
       
    //Metodos Setters para atributos de Nave
    
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPotencia(int Potencia) {
        this.Potencia = Potencia;
    }

    public void setEmpuje(int Empuje) {
        this.Empuje = Empuje;
    }

    public void setVelocidad(float Velocidad) {
        this.Velocidad = Velocidad;
    }

    public void setAltura(float Altura) {
        this.Altura = Altura;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public void setPeso(float Peso) {
        this.Peso = Peso;
    }    

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setCombustible(String Combustible) {
        this.Combustible = Combustible;
    }
    
    
    //Metodos abstractos de Nave
    
    public abstract void despegar();
        
    public abstract void aterrizar();
    
    public abstract void reabastecer();
}
