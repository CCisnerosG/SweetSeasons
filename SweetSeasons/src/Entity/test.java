/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import BO.VentaBO;
import Entity.Venta;
import java.util.Date;

/**
 *
 * @author mfsv_
 */
public class test {
    VentaBO vbo = new VentaBO();
    Venta ven = new Venta();
    
    String mensaje = "";
    
    Date fecha = new Date();
    
    public void Modificar(){
//        Date date = new Date();

//        long timeInMilliSeconds = date.getTime();
//        java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
//
//        System.out.println("SQL Date: " + date1);
        
        mensaje = vbo.eliminarVenta(16);
        System.out.println(mensaje);
    }
    
    public static void main (String[] args){
        test Test =new test();
        Test.Modificar();
    }
    
}
