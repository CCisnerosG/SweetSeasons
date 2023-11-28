package pruebadboracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaDBOracle {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getLocalizedMessage());
            return;
        }

        String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcldb"; //Ip MV Carlos 
        //String url = "jdbc:oracle:thin:@192.168.1.24:1521:orcldb"; //IP MV ANDY
        //String url = "jdbc:oracle:thin:@192.168.56.101:1521:orcl"; //Ip MV Ma Fer
        String user = "ProyectoSS";
        String pass = "1234";
        
        String sql = "SELECT ID_CLIENTE FROM CLIENTE WHERE NOMBRE = 'Pablo'";
        int clId;
        
        Connection conn;
        
        try{
            conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                clId = rs.getInt(1);
                 System.out.println("El id del cliente es: " + clId);
            }
        }catch(SQLException err){
            System.out.println("Error en la conexion: " + err.getLocalizedMessage());
        }
        
        Inicio();
    }
    
    public static void Inicio() {
        frmLogin inicio = new frmLogin();
        inicio.setLocationRelativeTo(null); // Esto centra el form en la pantalla al ejecutarse.
        inicio.setVisible(true); // Esto hace visible el form.
    }
    
    
}
