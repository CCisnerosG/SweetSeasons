/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Andy Madrigal
 */
public class Proveedor {
    
     private int id_proveedor;
    private String nombre_proveedor;
    private String primer_apellido;
    private String segudo_apellido;
    private int numoer_telefonico;
    private String correo_electronico;
    private String estado;
    
    public Proveedor(){
        
    }

    public Proveedor(int id_proveedor, String nombre_proveedor, String primer_apellido, String segudo_apellido, int numoer_telefonico, String correo_electronico, String estado) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.primer_apellido = primer_apellido;
        this.segudo_apellido = segudo_apellido;
        this.numoer_telefonico = numoer_telefonico;
        this.correo_electronico = correo_electronico;
        this.estado = estado;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegudo_apellido() {
        return segudo_apellido;
    }

    public void setSegudo_apellido(String segudo_apellido) {
        this.segudo_apellido = segudo_apellido;
    }

    public int getNumoer_telefonico() {
        return numoer_telefonico;
    }

    public void setNumoer_telefonico(int numoer_telefonico) {
        this.numoer_telefonico = numoer_telefonico;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
}
