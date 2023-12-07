/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import DAO.VentaDAO;
import Entity.Venta;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import pruebadboracle.ConexionBD;

/**
 *
 * @author mfsv_
 */
public class VentaBO {
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private VentaDAO vdao =  new VentaDAO();
    
    public String agragarVenta( Venta ven){
        Connection conn = conexion.conectar();
       try{
           mensaje = vdao.agragarVenta(conn, ven);
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
    
    public String modificarVenta(Venta ven){
        Connection conn = conexion.conectar();
       try{
           mensaje = vdao.modificarVenta(conn, ven);
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
    public String eliminarVenta(int id){
        Connection conn = conexion.conectar();
       try{
           mensaje = vdao.eliminarVenta(conn, id);
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
    public void listarVenta(JTable tabla){
        Connection conn = conexion.conectar();
        vdao.listarVenta(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
