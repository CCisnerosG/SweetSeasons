package DAO;

import Entity.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement; // Importa la clase Statement correcta
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        PreparedStatement cst = null;

        String sql = "UPDATE CLIENTE SET NOMBRE = ? PRIMER_APELLIDO = ? SEGUNDO_APELLIDO = ? CORREO = ? NUMERO_TELEFONICO = ? DIRECCION = ?"
                + "WHERE ID_CLIENTE = ?";

        try {
            cst = conn.prepareStatement(sql);

            cst.setString(1, cli.getNombre());
            cst.setString(2, cli.getPrimer_apellido());
            cst.setString(3, cli.getSegundo_apellido());
            cst.setString(4, cli.getCorreo());
            cst.setInt(5, cli.getNumero_telefonico());
            cst.setString(6, cli.getDireccion());

            cst.setInt(7, cli.getId_cliente());

            mensaje = "Cliente modificado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El cliente no se ha modificar correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }

    public String eliminarCliente(Connection conn, int id) {
        PreparedStatement cst = null;

        String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?";

        try {
            cst = conn.prepareStatement(sql);

            cst.setInt(1, id);

            mensaje = "Cliente eliminado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El cliente no se ha eliminar correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }

    public void listarCliente(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"ID_CLIENTE", "NOMBRE", "PRIMER_APELLIDO", "SEGUNDO_APELLIDO", "CORREO", "NUMERO TELEFONICO", "DIRECCION"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM CLIENTE";
        String[] filas = new String[7];
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                for (int i = 0; i < 7; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (SQLException e) {
            System.out.println("No se puede listar la tabla");
            e.printStackTrace();
        } 
    }
    
}
