
package BO;

/**
 *
 * @author Andy Madrigal
 */


import Entity.Ingrediente;
import DAO.IngredienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import pruebadboracle.ConexionBD;
public class IngredienteBO {
    
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private IngredienteDAO cdao =  new IngredienteDAO();
    
    
    public String agregarIngrediente( Ingrediente cli){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.agregarIngrediente(conn, cli);
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
    
    
    public String modificarIngrediente ( Ingrediente cli){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarIngrediente(conn, cli);
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
    
    
    public String eliminarIngrediente( int id){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarIngrediente(conn, id);
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
    public void listarIngrediente(JTable tabla){
        Connection conn = conexion.conectar();
        cdao.listarIngrediente(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    
}
