/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Types;


/**
 *
 * @author XPC
 */
public class CategoriaDAO {
    
    private String mensaje;
    
    
    /* --------- METODO PARA AGREGAR CATEGORIA ---------- */
    public String agregarCategoria(Connection conn, Categoria categoria) {
        CallableStatement cst = null;

        String procedureCall = "{call ADD_CATEGORY(?,?,?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, categoria.getId_categoria());
            cst.setString(2, categoria.getNombre());
            cst.setString(3, categoria.getDescripcion());
            
            mensaje = "Categoria guardada correctamente";
            
            cst.execute();
            cst.close();
            
        } catch (SQLException err) {
            
            mensaje = "La categoria no se ha podido guardar correctamente \n Error:" + err.getMessage();
        
        }
        return mensaje;
    }
    
    /* --------- METODO PARA EDITAR CATEGORIA ---------- */
    public String modificarCategoria(Connection conn, Categoria categoria) {
        CallableStatement cst = null;

        String procedureCall = "{call UPDATE_CATEGORY(?,?,?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, categoria.getId_categoria());
            cst.setString(2, categoria.getNombre());
            cst.setString(3, categoria.getDescripcion());
            
            mensaje = "Categoria modificada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "La categoria no se ha modificado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }
    
    /* --------- METODO PARA ELIMINAR CATEGORIA ---------- */
    public String eliminarCategoria(Connection conn, int id) {
        CallableStatement cst = null;

        String sql = "{call DELETE_CATEGORY(?)}";

        try {
            cst = conn.prepareCall(sql);

            cst.setInt(1, id);

            mensaje = "Categoria eliminada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "La categoria no se ha eliminado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }
    
    /* --------- METODO PARA LISTAR CATEGORIA ---------- */
    public void listarCategoria(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Nombre", "Descripcion"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call P_READ_CLIENTE(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            // Obtener el cursor de resultados
            rs = (ResultSet) cst.getObject(1);

            // Iterar sobre los resultados y agregarlos al modelo de la tabla
            while (rs.next()) {
                String nombre = rs.getString("NOMBRE");
                String descripcion = rs.getString("DESCRIPCION");
                
                model.addRow(new Object[]{nombre, descripcion});
            }

            tabla.setModel(model);

        } catch (SQLException e) {
            System.out.println("No se puede listar la tabla");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cst != null) {
                    cst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    
    
    
}
