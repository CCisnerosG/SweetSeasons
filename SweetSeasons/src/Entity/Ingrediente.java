/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Andy Madrigal
 */
public class Ingrediente {

    private int id_ingrediente;
    private String nombre_ingrediente;
    private String unidad_medida;
    private int precio;
    private int cantidad;
    private int id_proveedor;

    public Ingrediente() {

    }

    public Ingrediente(int id_ingrediente, String nombre_ingrediente, String unidad_medida, int precio, int cantidad, int id_proveedor) {
        this.id_ingrediente = id_ingrediente;
        this.nombre_ingrediente = nombre_ingrediente;
        this.unidad_medida = unidad_medida;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_proveedor = id_proveedor;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getNombre_ingrediente() {
        return nombre_ingrediente;
    }

    public void setNombre_ingrediente(String nombre_ingrediente) {
        this.nombre_ingrediente = nombre_ingrediente;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

   

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
    

}
