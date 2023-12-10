
package BO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import pruebadboracle.ConexionBD;
import Entity.Proveedor;
import DAO.ProveedorDAO;
/**
 *
 * @author Andy Madrigal
 */
public class ProveedorBO {
    
     ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private ProveedorDAO cdao =  new ProveedorDAO();
    
     public String agregarProveedor( Proveedor cli){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.agregarProveedor(conn, cli);
           conn.rollback();
       }catch(Exception e){
           mensaje = mensaje + " " + e.getMessage();
       }finally{
           try{
               if (conn!=null) {
                   conn.close();
               }
           }catch(Exception e){
               mensaje = mensaje + " " + e.getMessage();
           }
       }
        
        return mensaje;
    }
     
     public String modificarProveedor ( Proveedor cli){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarProveedor(conn, cli);
           conn.rollback();
       }catch(Exception e){
           mensaje = mensaje + " " + e.getMessage();
       }finally{
           try{
               if (conn!=null) {
                   conn.close();
               }
           }catch(Exception e){
               mensaje = mensaje + " " + e.getMessage();
           }
       }
        
        return mensaje;
    }
     
     public String eliminarProveedor( int id){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarProveedor(conn, id);
           conn.rollback();
       }catch(Exception e){
           mensaje = mensaje + " " + e.getMessage();
       }finally{
           try{
               if (conn!=null) {
                   conn.close();
               }
           }catch(Exception e){
               mensaje = mensaje + " " + e.getMessage();
           }
       }
       return mensaje;
    }
    public void listarProveedor(JTable tabla){
        Connection conn = conexion.conectar();
        cdao.listarProveedor(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
}
