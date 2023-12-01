/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebadboracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionBD {
    private final String driver = "oracle.jdbc.driver.OracleDriver";
    
    //private final String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcldb"; //Ip MV Carlos 
    //private final String url = "jdbc:oracle:thin:@192.168.1.24:1521:orcldb"; //IP MV ANDY
    private final String url = "jdbc:oracle:thin:@192.168.56.101:1521:orcl"; //Ip MV Ma Fer
    private final String user = "ProyectoSS";
    private final String pass = "OracleUwu";
    
    public Connection cadena;
    
    public ConexionBD(){
        this.cadena = null;
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            this.cadena = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return this.cadena;
    }
    
    public void desconectar(){
        try{
            this.cadena.close();
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
