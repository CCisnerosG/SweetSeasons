/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entity.Producto;
import DAO.ProductoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import pruebadboracle.ConexionBD;

/**
 *
 * @author XPC
 */
public class ProductoBO {
    
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private ProductoDAO cdao =  new ProductoDAO();
    
    public String agregarProducto( Producto producto){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.agregarProducto(conn, producto);
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
    
    public String modificarProducto ( Producto producto){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarProducto(conn, producto);
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
    public String eliminarProducto( int id){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarProducto(conn, id);
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
    
    
    public void listarProducto(JTable tabla){
        Connection conn = conexion.conectar();
        cdao.listarProducto(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    

    
}
