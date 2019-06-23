/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueinfantil;

/**
 *
 * @author david
 */

public class ParqueInfantil {
    private boolean cerrado, expulsar;
    private int edadTobogan;

    public ParqueInfantil(boolean cerrado) {
        this.cerrado = cerrado;
    }
    

    public boolean estaCerrado() {
        return cerrado ;        
    }

    void entraColumpios(Persona aThis) {
        System.out.println("E: columpios");
        
    }

    void salirColumpios(Persona aThis) {
        System.out.println("S: columpios");
    }

    void entraTobogan(Persona aThis) {
        System.out.println("E: tobogán");
        //seccionde semaforos
        aThis.setEnTobogan(true);
        //paso prebio antes de jugar
        
        edadTobogan = aThis.getEdad();
        if(edadTobogan>7 &&expulsar){ //*********************
         // no se le deja jugar por lo tanto no hace el sleep
         
        }else{
         //el niño hace el sleep;
        } 
    }

    void salirTobogan(Persona aThis) {
        System.out.println("S: tobogán");
    }

    void entraTiovivo(Persona aThis) {
        System.out.println("E: TioVivo");
    }

    public void salirTiovivo(Persona aThis) {
        System.out.println("S: TioVivo");
    }

    public void cerrarParque() {
        this.cerrado=true;
    }

    public void refrescarInfo() {
        System.out.println("refrescando.........");
    }

    public int edadNinio() {
        return this.edadTobogan;
        
    }

public void expulsarNinio(boolean expul) {
        this.expulsar = expul;
    }

  
    
}
