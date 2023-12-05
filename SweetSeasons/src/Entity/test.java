/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import BO.ClienteBO;
import Entity.Cliente;

/**
 *
 * @author mfsv_
 */
public class test {
    ClienteBO cbo = new ClienteBO();
    Cliente cli = new Cliente();
    
    String mensaje = "";
    
    public void Eliminar(){
        mensaje = cbo.eliminarCliente(18);
        System.out.println(mensaje);
    }
    
    public static void main (String[] args){
        test Test =new test();
        Test.Eliminar();
    }
}
