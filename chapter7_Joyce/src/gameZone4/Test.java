/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone4;

import java.util.Scanner;

/**
 *
 * @author logra
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Eliza prototipo1 = new Eliza();
        Scanner sc = new Scanner(System.in);
        String respuesta;
        
        do{
            System.out.println("Write something for Eliza.");
            respuesta = sc.nextLine();
            System.out.println(prototipo1.conversar(respuesta));
        }while(!respuesta.equals("Goodbye"));
    }
    
}
