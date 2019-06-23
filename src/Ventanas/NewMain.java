/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.io.IOException;
import parqueinfantil.ParqueInfantil;
import parqueinfantil.Persona;
import Controles_Cliente_Servidor.ServidorParque;

/**
 *
 * @author david
 */
public class NewMain {
    private static ParqueInfantil park;
    private static Persona persona;
    private static ServidorParque servidor;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        park = new ParqueInfantil(false);
        servidor = new ServidorParque(park);
        persona = new Persona(1,1,"nada",true, park);
        
        servidor.start();
        persona.start();
    }
    
}
