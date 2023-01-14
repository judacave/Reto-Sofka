
package model;

import java.sql.Connection;
import java.sql.DriverManager;


//Conexion a la Base de Daros
public class Conexion {
    String url="jdbc:mysql://localhost:3307/navesoftka";
    String user="root",pass="1234";    
    Connection con;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {            
        }
        return con;
    }
}
