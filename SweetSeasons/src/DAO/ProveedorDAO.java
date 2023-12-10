
package DAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Types;
import Entity.Proveedor;
/**
 *
 * @author Andy Madrigal
 */
public class ProveedorDAO {
    
    private String mensaje;
    
    public String agregarProveedor(Connection conn, Proveedor cli) {
        CallableStatement cst = null;

        String procedureCall = "{call AGREGAR_proveedor(?,?,?,?,?,?,?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, cli.getId_proveedor());
            cst.setString(2, cli.getNombre_proveedor());
            cst.setString(3, cli.getPrimer_apellido());
            cst.setString(4, cli.getSegudo_apellido());
            cst.setInt(5, cli.getNumoer_telefonico());
            cst.setString(6, cli.getCorreo_electronico());
            cst.setString(7,cli.getEstado());
            
            

            mensaje = "Proveedor guardado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El Proveedor no se ha podido guardado correctamente \n Error:" + err.getMessage();
        }
        return mensaje;
    }
    
    public String modificarProveedor(Connection conn, Proveedor cli) {
        CallableStatement cst = null;

        String procedureCall = "{call ACTUALIZAR_PROVE(?, ?, ?, ?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, cli.getId_proveedor());
            cst.setString(2, cli.getNombre_proveedor());
            cst.setString(3, cli.getPrimer_apellido());
            cst.setString(4, cli.getSegudo_apellido());
            cst.setInt(5, cli.getNumoer_telefonico());
            cst.setString(6, cli.getCorreo_electronico());
            cst.setString(7,cli.getEstado());
            

            mensaje = "Proveedor modificado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El Proveedor no se ha modificado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }
    
       public String eliminarProveedor(Connection conn, int id) {
         CallableStatement cst = null;

        String sql = "{call Ej_ELIMINAR_Proveedor(?)}";

        try {
            cst = conn.prepareCall(sql);

            cst.setInt(1, id);

            mensaje = "Proveedor eliminado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El Proveedor no se ha eliminado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }
       
       public void listarProveedor(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Id ", "Nombre", "P.Apellido", "S.Apellido", "Telefono", "correo","Estado"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call LEER_PROVEEDOR(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            // Obtener el cursor de resultados
            rs = (ResultSet) cst.getObject(1);

            // Iterar sobre los resultados y agregarlos al modelo de la tabla
            while (rs.next()) {
                String id = rs.getString("ID_PROVEEDOR");
                String nombre = rs.getString("NOMBRE_PROVEEDOR");
                String pApellido = rs.getString("PRIMER_APELLIDO");
                String sApellido = rs.getString("SEGUNDO_APELLIDO");
                String telefono = rs.getString("NUMERO_TELEFONICO");
                String correo = rs.getString("CORREO_ELECTRONICO");
                String estado = rs.getString("ESTADO");

                model.addRow(new Object[]{id, nombre, pApellido, sApellido, telefono, correo,estado});
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
