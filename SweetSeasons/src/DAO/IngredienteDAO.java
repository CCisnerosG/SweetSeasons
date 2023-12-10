
package DAO;

/**
 *
 * @author Andy Madrigal
 */
import Entity.Ingrediente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Types;

public class IngredienteDAO {
    
    
    private String mensaje;

    public String agregarIngrediente(Connection conn, Ingrediente cli) {
        CallableStatement cst = null;

        String procedureCall = "{call AGREGAR_INGREDIENTE(?,?,?,?,?,?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, cli.getId_ingrediente());
            cst.setString(2, cli.getNombre_ingrediente());
            cst.setString(3, cli.getUnidad_medida());//sino funciona revisar las mayusculas
            cst.setInt(4, cli.getPrecio());
            cst.setInt(5, cli.getCantidad());
            cst.setInt(6, cli.getId_proveedor());
            

            mensaje = "Ingrediente guardado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El ingrediente no se ha podido guardado correctamente \n Error:" + err.getMessage();
        }
        return mensaje;
    }
    
      public String modificarIngrediente(Connection conn, Ingrediente cli) {
        CallableStatement cst = null;

        String procedureCall = "{call ACTUALIZAR_INGREDIENTES(?, ?, ?, ?, ?, ?)}";

        try {
            cst = conn.prepareCall(procedureCall);

            cst.setInt(1, cli.getId_ingrediente());
            cst.setString(2, cli.getNombre_ingrediente());
            cst.setString(3, cli.getUnidad_medida());
            cst.setInt(4, cli.getPrecio());
            cst.setInt(5, cli.getCantidad());
            cst.setInt(6, cli.getId_proveedor());
            

            mensaje = "Ingrediente modificado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El Ingrediente no se ha modificado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }
      
       public String eliminarIngrediente(Connection conn, int id) {
         CallableStatement cst = null;

        String sql = "{call Ej_ELIMINAR_INGREDIENTE(?)}";

        try {
            cst = conn.prepareCall(sql);

            cst.setInt(1, id);

            mensaje = "Ingrediente eliminado correctamente";
            cst.execute();
            cst.close();
        } catch (SQLException err) {
            mensaje = "El Ingrediente no se ha eliminado correctamente \n Error: " + err.getMessage();
        }
        return mensaje;
    }
       
       public void listarIngrediente(Connection conn, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"Id ", "Ingrediente", "Unidad Medida", "Precio", "Cantidad", "ID Proveedor"};
        model = new DefaultTableModel(null, columnas);

        CallableStatement cst = null;
        ResultSet rs = null;

        try {
            cst = conn.prepareCall("{call LEER_INGREDIENTES(?)}");
            cst.registerOutParameter(1, Types.REF_CURSOR);
            cst.execute();

            // Obtener el cursor de resultados
            rs = (ResultSet) cst.getObject(1);

            // Iterar sobre los resultados y agregarlos al modelo de la tabla
            while (rs.next()) {
                String id = rs.getString("ID_INGREDIENTE");
                String nombreIngre = rs.getString("NOMBRE_INGREDIENTE");
                String unidadMed = rs.getString("UNIDAD_MEDIDA");
                String precio = rs.getString("PRECIO");
                String cantidad = rs.getString("CANTIDAD");
                String idProv = rs.getString("ID_PROVEEDOR");

                model.addRow(new Object[]{id, nombreIngre, unidadMed, precio, cantidad, idProv});
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
