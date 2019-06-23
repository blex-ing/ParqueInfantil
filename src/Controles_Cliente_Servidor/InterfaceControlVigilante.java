package Controles_Cliente_Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTextField;

/**
 *
 * @author david
 */
public interface InterfaceControlVigilante extends Remote {
    /**
     * Funcion que controla la edad del niño
     * y si es mayor de N años es expulsado 
     * @param nombre
     * @return
     * @throws RemoteException 
     */
    String controlarNinio(String nombre) throws RemoteException;            
}
