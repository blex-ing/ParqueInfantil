/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Cliente_Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author david
 */
public class ClienteSupervisor {
    
    private Socket cliente;
    private DataInputStream entrada;
    private DataOutputStream salida;
    
    public ClienteSupervisor(){
        try{
            this.cliente = new Socket(InetAddress.getLocalHost(),2222);
            this.entrada = new DataInputStream(cliente.getInputStream());
            this.salida = new DataOutputStream(cliente.getOutputStream());
        }catch(IOException ex){
            System.out.println("ERROR: "+ ex.getMessage());
            System.exit(0);// si se habre antes el cliente que el servidor cerramos la ventana
        }
    }
    
    public void interaccion (String accion){
        try{
            salida.writeUTF(accion);
        }catch(IOException e){
            System.out.println("ERROR");
        }
    }
    
    public void cerrarConexiones(){
        try{
            entrada.close();
            salida.close();
            cliente.close();
        }catch(IOException ex){
            System.out.println("ERROR: "+ ex.getMessage());}
    }
}
