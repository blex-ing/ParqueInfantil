/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Cliente_Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controles_Cliente_Servidor.ControlParque;
import Controles_Cliente_Servidor.ControlVigilante;

import parqueinfantil.ParqueInfantil;
import parqueinfantil.ParqueInfantil;

/**
 *
 * @author david
 */
public class ServidorParque extends Thread {
    private final ParqueInfantil park;
    private ControlParque ctrlPark;
    private final ServerSocket servidor;
    
    private ControlVigilante objeto; 
    private Registry registro;
    

    public ServidorParque(ParqueInfantil park) throws IOException {
        this.park = park;
               
        servidor = new ServerSocket(2222);// Creamos un ServerSocket en el puerto 2222
        registro = LocateRegistry.createRegistry(1099); //arranca RMIregistry local en el puesto 1099
        
        
        
               
        
    }

    @Override
    public void run() {
        
        Socket conexion;       
        int cont=0;
        try{
            System.out.println("Servidor Activo....");
            
            
            while(true){
                
            this.objeto = new ControlVigilante(this.park);
            Naming.rebind("//127.0.0.1/ObjetoControlVigilante", objeto);
            System.out.println("El Objeto ControlVigilante ha quedado registrado");
                
                conexion = servidor.accept();  //Esperamos una conexión
                if(conexion.isConnected()){
                ctrlPark = new ControlParque(conexion,park);
                ctrlPark.start();
                cont++;
                System.out.println("Conexión nº"+cont+" desde "+conexion.getInetAddress().getHostName());}
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorParque.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
}
