/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entity.Compra;
import DAO.CompraDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import pruebadboracle.ConexionBD;

/**
 *
 * @author mfsv_
 */
public class CompraBO {
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private CompraDAO cdao =  new CompraDAO();
    
    public String agragarCompra( Compra cli){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.agragarCompra(conn, cli);
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
    
    public String modificarCompra ( Compra cli){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarCompra(conn, cli);
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
    public String eliminarCompra( int id){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarCompra(conn, id);
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
    public void listarCompra(JTable tabla){
        Connection conn = conexion.conectar();
        cdao.listarCompras(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
