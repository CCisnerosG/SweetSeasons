/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author mfsv_
 */
public class Compra {
    private int id_compra;
    private String fecha_compra;
    private int id_proveedor;
    private int id_productos;
    private int cantidad;
    private int precio;
    private int total;

    public Compra() {
    }

    
    public Compra(int id_compra, String fecha_compra, int id_proveedor, int id_productos, int cantidad, int precio, int total) {
        this.id_compra = id_compra;
        this.fecha_compra = fecha_compra;
        this.id_proveedor = id_proveedor;
        this.id_productos = id_productos;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_productos() {
        return id_productos;
    }

    public void setId_productos(int id_productos) {
        this.id_productos = id_productos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
}
