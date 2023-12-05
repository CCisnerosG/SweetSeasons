package DAO;

import Entity.Cliente;
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
public class ClienteDAO {

    private String mensaje;

    //Funcion modificada para que funcione con un procedimiento almacenado
    public String agragarCliente(Connection conn, Cliente cli) {
        CallableStatement cst = null;

        String procedureCall = "{call INSERT_CLIENTES(?,?,?,?,?,?,?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, cli.getId_cliente());
            cst.setString(2, cli.getNombre());
            cst.setString(3, cli.getPrimer_apellido());
            cst.setString(4, cli.getSegundo_apellido());
            cst.setString(5, cli.getCorreo());
            cst.setInt(6, cli.getNumero_telefonico());
            cst.setString(7, cli.getDireccion());

            mensaje = "Cliente guardado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El cliente no se ha podido guardado correctamente \n Error:" + err.getMessage();
        }
        return mensaje;
    }

    public String modificarCliente(Connection conn, Cliente cli) {
        CallableStatement cst = null;

        String procedureCall = "{call UPDATE_CLIENTES(?, ?, ?, ?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, cli.getId_cliente());
            cst.setString(2, cli.getNombre());
            cst.setString(3, cli.getPrimer_apellido());
            cst.setString(4, cli.getSegundo_apellido());
            cst.setString(5, cli.getCorreo());
            cst.setInt(6, cli.getNumero_telefonico());
            cst.setString(7, cli.getDireccion());

            mensaje = "Cliente modificado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El cliente no se ha modificado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }

    public String eliminarCliente(Connection conn, int id) {
         CallableStatement cst = null;

        String sql = "{call Ej_Func_Client(?)}";

        try {
            cst = conn.prepareCall(sql);

            cst.setInt(1, id);

            mensaje = "Cliente eliminado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El cliente no se ha eliminado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }
    
    public void listarCliente(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Nombre", "Primer apellido", "Segundo apellido", "Correo", "Número de telefono", "Dirección"};
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
                String primerApellido = rs.getString("PRIMER_APELLIDO");
                String segundoApellido = rs.getString("SEGUNDO_APELLIDO");
                String correo = rs.getString("CORREO");
                String numeroTelefono = rs.getString("NUMERO_TELEFONICO");
                String direccion = rs.getString("DIRECCION");

                model.addRow(new Object[]{nombre, primerApellido, segundoApellido, correo, numeroTelefono, direccion});
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
