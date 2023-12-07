/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mfsv_
 */
public class VentaDAO {
    
    private String mensaje;

    public String agragarVenta(Connection conn, Venta ven) {
        CallableStatement cst = null;

        String procedureCall = "{call INSERT_VENTAS(?,?,?,?,?,?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, ven.getId_venta());
            cst.setDate(2, (Date) ven.getFecha_venta());
            cst.setInt(3, ven.getCantidad());
            cst.setDouble(4, ven.getPrecio());
            cst.setInt(5, ven.getId_cliente());
            cst.setInt(6, ven.getId_producto());

            mensaje = "Venta guardada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "La venta no se ha podido guardar correctamente \n Error:" + err.getMessage();
        }
        return mensaje;
    }

    public String modificarVenta(Connection conn, Venta ven) {
        CallableStatement cst = null;

        String procedureCall = "{call UPDATE_VENTAS(?, ?, ?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, ven.getId_venta());
            cst.setDate(2, (Date) ven.getFecha_venta());
            cst.setInt(3, ven.getCantidad());
            cst.setDouble(4, ven.getPrecio());
            cst.setInt(5, ven.getId_cliente());
            cst.setInt(6, ven.getId_producto());

            mensaje = "Venta modificada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "La venta no se ha modificado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }

    public String eliminarVenta(Connection conn, int id) {
         CallableStatement cst = null;

        String sql = "{call Ej_Func_Vent(?)}";

        try {
            cst = conn.prepareCall(sql);

            cst.setInt(1, id);

            mensaje = "Venta eliminada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "La venta no se ha eliminado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }
    
    public void listarVenta(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Fecha de venta", "Cantidad ", "Precio", "Id del cliente", "Id del producto"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call P_READ_VENTAS(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            // Obtener el cursor de resultados
            rs = (ResultSet) cst.getObject(1);

            // Iterar sobre los resultados y agregarlos al modelo de la tabla
            while (rs.next()) {
                String fecha = rs.getString("FECHA_VENTA");
                String cantidad = rs.getString("CANTIDAD");
                String precio = rs.getString("PRECIO");
                String id_cliente = rs.getString("ID_CLIENTE");
                String id_producto = rs.getString("ID_PRODUCTOS");

                model.addRow(new Object[]{fecha, cantidad, precio, id_cliente, id_producto});
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
