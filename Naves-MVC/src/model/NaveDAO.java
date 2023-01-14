
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// En esta clase DAO es donde se crean los metodos para la persistencia de datos con sql

public class NaveDAO {
    //Nos conectamos a la base de datos creando un objeto de la clase Conexion
    Conexion conectar=new Conexion();   
    Connection con;
    //Usamos Prepared Stament para definir distintas consultas sql con eficiencia
    PreparedStatement ps;
    ResultSet rs;
 
    //Metodo listar para mostrar todas las naves existentes en la base de datos
    public List listar() {
        List<N_Lanzadera>datos=new ArrayList<>();
        String sql="select * from naves";
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()) {
                N_Lanzadera n= new N_Lanzadera();
                n.setNombre(rs.getString(1));
                n.setPotencia(rs.getInt(2));
                n.setEmpuje(rs.getInt(3));
                n.setVelocidad(rs.getFloat(4));
                n.setAltura(rs.getFloat(5));
                n.setPais(rs.getString(6));
                n.setPeso(rs.getFloat(7));
                n.setTipo(rs.getString(8));
                n.setCombustible(rs.getString(9));                 
                datos.add(n);
            }
        } catch (Exception e) {
        }
        return datos;
    }
   
    //Metodo para filtrar las naves
    public List filtrarTipo(String opcion, String content) {
        List<N_Lanzadera>datos=new ArrayList<>();
        String sql="";
        //Los ifs hacen referencia al desplegable de la vista donde filtramos
        if ("Nombre".equals(opcion)) {
            sql="select * from naves where Nombre = ?";
        }
        if ("Tipo".equals(opcion)) {
            sql="select * from naves where Tipo = ?";
        }
        if ("Pais".equals(opcion)) {
            sql="select * from naves where Pais = ?";
        }              
        try {            
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,content);
            rs=ps.executeQuery();
            
            while(rs.next()) {
                N_Lanzadera n= new N_Lanzadera();
                n.setNombre(rs.getString(1));
                n.setPotencia(rs.getInt(2));
                n.setEmpuje(rs.getInt(3));
                n.setVelocidad(rs.getFloat(4));
                n.setAltura(rs.getFloat(5));
                n.setPais(rs.getString(6));
                n.setPeso(rs.getFloat(7));
                n.setTipo(rs.getString(8));     
                n.setCombustible(rs.getString(9));
                datos.add(n);
            }
        } catch (Exception e) {
        }
        return datos;
    }
  
    //Metodo para crear una nave de tipo Lanzadera
    public int crearnaveLanzadera(N_Lanzadera n) {
        String sql = "insert into naves(Nombre,Potencia,Empuje,Velocidad,Altura,Pais,Peso,Tipo,Combustible) values(?,?,?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,n.getNombre());
            ps.setInt(2, n.getPotencia());
            ps.setInt(3, n.getEmpuje());
            ps.setFloat(4,n.getVelocidad());   
            ps.setFloat(5,n.getAltura());
            ps.setString(6,n.getPais());
            ps.setFloat(7,n.getPeso()); 
            ps.setString(8, n.getTipo());
            ps.setString(9, n.getCombustible());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return 1;
    }
    
    //Metodo para crear una nave de tipo no tripulada
    public int crearnaveNoTripulada(N_NoTripulada n) {
        String sql = "insert into naves(Nombre,Potencia,Empuje,Velocidad,Altura,Pais,Peso,Tipo,Combustible) values(?,?,?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,n.getNombre());
            ps.setInt(2, n.getPotencia());
            ps.setInt(3, n.getEmpuje());
            ps.setFloat(4,n.getVelocidad());   
            ps.setFloat(5,n.getAltura());
            ps.setString(6,n.getPais());
            ps.setFloat(7,n.getPeso()); 
            ps.setString(8, n.getTipo());
            ps.setString(9, n.getCombustible());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return 1;
    }
    
    //Metodo para crear una nave de tipo tripulada
    public int crearnaveTripulada(N_Tripulada n) {
        String sql = "insert into naves(Nombre,Potencia,Empuje,Velocidad,Altura,Pais,Peso,Tipo,Combustible) values(?,?,?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,n.getNombre());
            ps.setInt(2, n.getPotencia());
            ps.setInt(3, n.getEmpuje());
            ps.setFloat(4,n.getVelocidad());   
            ps.setFloat(5,n.getAltura());
            ps.setString(6,n.getPais());
            ps.setFloat(7,n.getPeso()); 
            ps.setString(8, n.getTipo());
            ps.setString(9, n.getCombustible());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return 1;
    }
}
