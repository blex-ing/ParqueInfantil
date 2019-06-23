/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Cliente_Servidor;

import Controles_Cliente_Servidor.InterfaceControlVigilante;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JTextField;
import parqueinfantil.ParqueInfantil;

/**
 *
 * @author david
 */
public class ControlVigilante extends UnicastRemoteObject implements InterfaceControlVigilante{
    
    private ParqueInfantil park;

    public ControlVigilante(ParqueInfantil park) throws RemoteException {
        this.park=park;
    }

    @Override
    public String controlarNinio(String nombre) throws RemoteException {
        if(park.edadNinio() > 7){
            park.expulsarNinio(true);
        }else{park.expulsarNinio(false);}
        return Integer.toString( park.edadNinio());
    } 
    
}
