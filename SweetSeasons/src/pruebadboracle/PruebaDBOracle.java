package pruebadboracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaDBOracle {

    public static void main(String[] args) {
        ConexionBD conexion = new ConexionBD();
        String sql = "";
        
        try{
            sql = "SELECT ID_CLIENTE FROM CLIENTE WHERE NOMBRE = 'Pablo'";
            Connection conn = conexion.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            int clId;
            
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
