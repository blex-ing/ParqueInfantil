/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Cliente_Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import parqueinfantil.ParqueInfantil;

/**
 *
 * @author david
 */
public class ControlParque extends Thread {
    private final Socket conexionPark;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private final ParqueInfantil park;

    public ControlParque(Socket conexionPark,ParqueInfantil park) {
        this.conexionPark = conexionPark;
        this.park = park;
    }

    @Override
    public void run() {
        while (true){
            try{
                entrada = new DataInputStream(conexionPark.getInputStream());
                salida = new DataOutputStream(conexionPark.getOutputStream());
                String mensaje = entrada.readUTF();
                switch(mensaje){
                    case "Cerrar": //cerramos el parque
                        park.cerrarParque();
                        break;
                    case "Refrescar":
                        park.refrescarInfo();
                        break;
                        
                    default:
                        conexionPark.close();
                        entrada.close();
                        salida.close();
                        break;
                }
            }catch(IOException ex){
            }
        
        }
    }
    
    
    
    
    
    
}
