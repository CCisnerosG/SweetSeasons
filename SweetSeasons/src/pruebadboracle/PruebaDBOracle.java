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

        String url = "jdbc:oracle:thin:@192.168.0.12:1521:orcldb";
       // String url = "jdbc:oracle:thin:@192.168.1.24:1521:orcldb"; //IP MV ANDY
        String user = "HR";
        String pass = "hr";
        String sql = "SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE LAST_NAME = 'King'";
        int empId;
        Connection conn;

        try {
            conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                empId = rs.getInt(1);
                System.out.println("El código de empleado es: " + empId);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getLocalizedMessage());
        }
    }
}
