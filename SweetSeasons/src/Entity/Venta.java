/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author mfsv_
 */
public class Venta {
    private int id_venta;
    private Date fecha_venta;
    private int cantidad;
    private double precio;
    private int id_cliente;
    private int id_producto;

    public Venta() {
    }

    public Venta(int id_venta, Date fecha_venta, int cantidad, double precio, int id_cliente, int id_producto) {
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_cliente = id_cliente;
        this.id_producto = id_producto;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_compra(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
    
    
    
}
