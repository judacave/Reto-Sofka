
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;


import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.N_Lanzadera;
import model.N_NoTripulada;
import model.N_Tripulada;
import model.Nave;
import model.NaveDAO;
import view.VistaNaves;

/**
 *
 * @author juand
 */

//Clase controlador que implementa la interfaz ActionListener
public class Controller implements ActionListener{

    //Se instancian los objetos a usar de las disstintas clases
    NaveDAO daon = new NaveDAO();
    
    N_Lanzadera n1 = new N_Lanzadera();
    N_Tripulada n3 = new N_Tripulada();
    N_NoTripulada n2 = new N_NoTripulada();
    
    //Se crean las vistas para hacer uso de la interfaz grafica
    VistaNaves shipview = new VistaNaves();
    //Modelo para listar los datos en la tabla de la vista
    DefaultTableModel modelo = new DefaultTableModel();

   //Constructor del controlador que recibe la vista 
    public Controller(VistaNaves vn) {
        this.shipview=vn;
        this.shipview.btnCrear.addActionListener(this);
        this.shipview.btnFiltrarr.addActionListener(this);
        this.shipview.btnListar.addActionListener(this);
    }
    
    //Se sobreescribe el unico metodo de la interfaz para capturar eventos
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==shipview.btnCrear) {
            //Se llama al metodo crear nave
            crearnave();
        }
        if (e.getSource()==shipview.btnListar) {
            //Se llama al metodo listar entregandole como parametro el JTable
            limpiarTabla();
            listar(shipview.tableNaves);
        }
        if (e.getSource()==shipview.btnFiltrarr) {
            //Se llama al metodo para filtrar y se limpia la tabla cada vez que se captura este evento
            limpiarTabla();
            filtrarType(shipview.tableNaves);
        }
    }
    


    //Metodo para capturar los nuevos datos para crear una nave
    //Este metodo se comunica con el modelo para entregarle los datos capturados en la vista
     public void crearnave(){
        //Se capturan los distintos datos que se ingresan en la vista
        String nom=shipview.txtNom.getText();
        String potaux=shipview.txtPot.getText();
        String empaux=shipview.txtEmp.getText();
        String velaux=shipview.txtVel.getText();
        String altaux=shipview.txtAlt.getText();
        String pais=shipview.txtPais.getText();
        String pesoaux=shipview.txtPeso.getText(); 
        String tipo=shipview.txtTipo.getSelectedItem().toString();
        String comb = shipview.txtCombustible.getText();
        
        //Se transforman algunos datos a su tipo de dato adecuado
        int pot = Integer.parseInt(potaux);
        int emp = Integer.parseInt(empaux);
        float vel = Float.parseFloat(velaux);
        float alt = Float.parseFloat(altaux);
        float peso = Float.parseFloat(pesoaux);
        
        String opcion = tipo;
        //Switch que teniendo en cuenta el tipo de nave seleccionado crea un objeto usando las instancias de las naves
        //Tambien se comunica con la dao para la persistencia de los datos
        switch (opcion){

            case "Nave Lanzadera" -> {
                //Haciendo uso de los stters se establece el value de los atributos de la nave
                n1.setNombre(nom);
                n1.setPotencia(pot);
                n1.setEmpuje(emp);
                n1.setVelocidad(vel);
                n1.setAltura(alt);
                n1.setPais(pais);
                n1.setPeso(peso);
                n1.setTipo(opcion);
                n1.setCombustible(comb);
                int r = daon.crearnaveLanzadera(n1);
                if (r==1) {
                    JOptionPane.showMessageDialog(shipview, "Nave Lanzadera creada con exito");
                }else{
                    JOptionPane.showMessageDialog(shipview,"Error");
                }
            }
            case "Nave No Tripulada" -> {
                n2.setNombre(nom);
                n2.setPotencia(pot);
                n2.setEmpuje(emp);
                n2.setVelocidad(vel);
                n2.setAltura(alt);
                n2.setPais(pais);
                n2.setPeso(peso);
                n2.setTipo(opcion);
                n2.setCombustible(comb);
                int r = daon.crearnaveNoTripulada(n2);
                if (r==1) {
                    JOptionPane.showMessageDialog(shipview, "Nave No Tripulada creada con exito");
                }else{
                    JOptionPane.showMessageDialog(shipview,"Error");
                }
            }
            case "Nave Tripulada" -> {
                n3.setNombre(nom);
                n3.setPotencia(pot);
                n3.setEmpuje(emp);
                n3.setVelocidad(vel);
                n3.setAltura(alt);
                n3.setPais(pais);
                n3.setPeso(peso);
                n3.setTipo(opcion);
                n3.setCombustible(comb);
                int r = daon.crearnaveTripulada(n3);
                if (r==1) {
                    JOptionPane.showMessageDialog(shipview, "Nave Tripulada creada con exito");
                }else{
                    JOptionPane.showMessageDialog(shipview,"Error");
                }
            }
            default -> {
                System.out.println("Opcion incorrecta");
            }

      }//cierra SWITCH     
              
              
        
    }  
    
    //Metodo que se encarga de mostrar los datos de las naves en la vista
     //Este metodo se comunica con la dao que se encargara de devolver los datos a listar desde la base de datos
    public void listar(JTable tableNaves) {
        modelo= (DefaultTableModel)tableNaves.getModel();
        List<Nave> lista=daon.listar();
        Object[]object=new Object[9];
        for (int i = 1; i < lista.size(); i++) {
            object[0] = lista.get(i).getNombre();
            object[1] = lista.get(i).getPotencia();
            object[2] = lista.get(i).getEmpuje();
            object[3] = lista.get(i).getVelocidad();
            object[4] = lista.get(i).getAltura();
            object[5] = lista.get(i).getPais();
            object[6] = lista.get(i).getPeso();
            object[7] = lista.get(i).getTipo();
            object[8] = lista.get(i).getCombustible();
            modelo.addRow(object);
        }
        shipview.tableNaves.setModel(modelo);
    }
    
    //Metodo para filtrar las naves por criterios de busqueda
    public void filtrarType(JTable tableNaves) {
        //Se capturan los criterios de busqueda para comunicarselos a las daos
        String opcion=shipview.despFiltro.getSelectedItem().toString();
        String txt=shipview.txtFiltro.getText();
        
        modelo= (DefaultTableModel)tableNaves.getModel();
        //Se invoca el metodo de la dao entregandole los parametros de busqueda capturados
        List<N_Lanzadera> lista=daon.filtrarTipo(opcion,txt);
        Object[]object=new Object[9];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getNombre();
            object[1] = lista.get(i).getPotencia();
            object[2] = lista.get(i).getEmpuje();
            object[3] = lista.get(i).getVelocidad();
            object[4] = lista.get(i).getAltura();
            object[5] = lista.get(i).getPais();
            object[6] = lista.get(i).getPeso();
            object[7] = lista.get(i).getTipo();
            object[8] = lista.get(i).getCombustible();
            modelo.addRow(object);
        }
        shipview.tableNaves.setModel(modelo);
    }
    //Metodo para limpiar la tabla cada que se hace una nueva busqueda con el filtro
    public void limpiarTabla(){
    for (int i = 0; i < shipview.tableNaves.getRowCount(); i++) {        
        modelo.removeRow(i);
        i-=1;
    }
    }
}
