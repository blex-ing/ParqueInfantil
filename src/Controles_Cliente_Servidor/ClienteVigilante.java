/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Cliente_Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public class ClienteVigilante {
    
    private BufferedReader entrada;
    private String respuesta;
    private InterfaceControlVigilante objeto;
    private JTextField textEdad;
    public ClienteVigilante(JTextField edad) throws IOException {
        this.textEdad = edad;
    }
    /**
     * Metodo del Vigilante para hacer su trabajo
     * @param accion
     * @throws IOException
     * @throws NotBoundException 
     */
    public void interaccionV(String accion) throws IOException, NotBoundException{
        
        String respuesta="";
        try{
            InterfaceControlVigilante objeto = (InterfaceControlVigilante) Naming.lookup("//127.0.0.1/ObjetoControlVigilante"); //Localiza el objeto distribuido
            respuesta= objeto.controlarNinio(accion);
            this.textEdad.setText(respuesta);   // edad del niño controlado
            System.out.println("# expulsado "+respuesta);
        } catch (RemoteException ex) {
            System.out.println("Servidor no encotrado");
            System.out.println("ERROR: "+ ex.getMessage());
            //Logger.getLogger(ClienteVigilante.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }
    
}
