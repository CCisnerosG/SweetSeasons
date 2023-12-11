/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Producto;
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
public class ProductoDAO {
    
    private String mensaje;

    public String agregarProducto(Connection conn, Producto producto) {
        CallableStatement cst = null;

        String procedureCall = "{call ADD_PRODUCTOS(?,?,?,?,?,?,?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, producto.getId_producto());
            cst.setString(2, producto.getNombre());
            cst.setInt(3, producto.getId_categoria());
            cst.setInt(4, producto.getCantidad());
            cst.setString(5, producto.getDescripcion());
            cst.setString(6, producto.getTamano());
            cst.setInt(7, producto.getPrecio());

            mensaje = "Producto guardado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El producto no se ha podido guardado correctamente \n Error:" + err.getMessage();
        }
        return mensaje;
    }

    public String modificarProducto(Connection conn, Producto producto) {
        CallableStatement cst = null;

        String procedureCall = "{call UPDATE_PRODUCTOS(?, ?, ?, ?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, producto.getId_producto());
            cst.setString(2, producto.getNombre());
            cst.setInt(3, producto.getId_categoria());
            cst.setInt(4, producto.getCantidad());
            cst.setString(5, producto.getDescripcion());
            cst.setString(6, producto.getTamano());
            cst.setInt(7, producto.getPrecio());

            mensaje = "producto modificado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El producto no se ha modificado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }

    public String eliminarProducto(Connection conn, int id) {
         CallableStatement cst = null;

        String sql = "{call DELETE_PRODUCTOS(?)}";

        try {
            cst = conn.prepareCall(sql);

            cst.setInt(1, id);

            mensaje = "producto eliminado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El producto no se ha eliminado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }
    
    public void listarProducto(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Nombre", "ID Categoria", "Cantidad", "Descripcion", "Tamano", "Precio"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call P_READ_PRODUCTOS(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            // Obtener el cursor de resultados
            rs = (ResultSet) cst.getObject(1);

            // Iterar sobre los resultados y agregarlos al modelo de la tabla
            while (rs.next()) {
                String nombre = rs.getString("NOMBRE");
                String idCategoria = rs.getString("ID_CATEGORIA");
                String cantidad = rs.getString("CANTIDAD");
                String descripcion = rs.getString("DESCRIPCION");
                String tamano = rs.getString("TAMANO");
                String precio = rs.getString("PRECIO");

                model.addRow(new Object[]{nombre, idCategoria, cantidad, descripcion, tamano, precio});
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
