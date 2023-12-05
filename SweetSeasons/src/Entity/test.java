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
    
    public void ingresar(){
        cli.setId_cliente(18);
        cli.setNombre("MaDFG");
        cli.setPrimer_apellido("DDDF");
        cli.setSegundo_apellido("DFGGS");
        cli.setCorreo("jjkkok@gmail.D");
        cli.setNumero_telefonico(34889900);
        cli.setDireccion("Heredia");
        mensaje = cbo.agragarCliente(cli);
        System.out.println(mensaje);
    }
    
    public static void main (String[] args){
        test Test =new test();
        Test.ingresar();
    }
}
