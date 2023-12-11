/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entity.Categoria;
import DAO.CategoriaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JTable;
import pruebadboracle.ConexionBD;


/**
 *
 * @author XPC
 */
public class CategoriaBO {
    
    ConexionBD conexion = new ConexionBD();
            
    private String mensaje ;
    private CategoriaDAO cdao =  new CategoriaDAO();
    
    public String agregarCategoria( Categoria cat){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.agregarCategoria(conn, cat);
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
    
    public String modificarCategoria ( Categoria cat){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.modificarCategoria(conn, cat);
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
    public String eliminarCategoria( int id){
        Connection conn = conexion.conectar();
       try{
           mensaje = cdao.eliminarCategoria(conn, id);
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
    
    
    public void listarCategoria(JTable tabla){
        Connection conn = conexion.conectar();
        cdao.listarCategoria(conn, tabla);
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
