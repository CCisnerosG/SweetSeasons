package DAO;

import Entity.Compra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Types;

/**
 *
 * @author mfsv_
 */
public class CompraDAO {

    private String mensaje;

    public String agragarCompra(Connection conn, Compra cli) {
        CallableStatement cst = null;

        String procedureCall = "{call INSERTAR_COMPRA(?,?,?,?,?,?,?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, cli.getId_compra());
            cst.setString(2, cli.getFecha_compra());
            cst.setInt(3, cli.getId_proveedor());
            cst.setInt(4, cli.getId_productos());
            cst.setInt(5, cli.getCantidad());
            cst.setInt(6, cli.getPrecio());
            cst.setInt(7, cli.getTotal());

            mensaje = "Compra guardada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "La compra no se ha podido guardado correctamente \n Error:" + err.getMessage();
        }
        return mensaje;
    }

    public String modificarCompra(Connection conn, Compra cli) {
        CallableStatement cst = null;

        String procedureCall = "{call actualizar_compra(?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, cli.getId_compra());
            cst.setInt(2, cli.getCantidad());
            cst.setInt(3, cli.getPrecio());
            cst.setInt(4, cli.getTotal());

            mensaje = "Compra modificada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "La compra no se ha modificado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }

    public String eliminarCompra(Connection conn, int id) {
        CallableStatement cst = null;

        String sql = "{call EJ_FUNC_COMPRA(?)}";

        try {
            cst = conn.prepareCall(sql);

            cst.setInt(1, id);

            mensaje = "Compra eliminada correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "La compra no se ha eliminado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }

    public void listarCompras(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Información de Compra"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{? = call READ_ALL_PURCHASES}");

            cst.registerOutParameter(1, Types.REF_CURSOR);

            cst.execute();

            // Obtener el cursor de resultados
            rs = (ResultSet) cst.getObject(1);

            while (rs.next()) {
                String infoCompra = rs.getString("INFO_COMPRA");
                model.addRow(new Object[]{infoCompra});
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
