/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entity.Cliente;
import DAO.ClienteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import pruebadboracle.ConexionBD;

/**
 *
 * @author mfsv_
 */
public class ClienteBO {
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private ClienteDAO cdao =  new ClienteDAO();
    
    public String agragarCliente( Cliente cli){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.agragarCliente(conn, cli);
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
    
    public String modificarCliente ( Cliente cli){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarCliente(conn, cli);
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
    public String eliminarCliente( int id){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarCliente(conn, id);
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
    public void listarCliente(JTable tabla){
        Connection conn = conexion.conectar();
        cdao.listarCliente(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
