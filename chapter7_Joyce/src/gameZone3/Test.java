/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone3;

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
        SecretPhrase frase = new SecretPhrase();
        Scanner sc = new Scanner(System.in);
        
        System.out.println(frase.getCifrado());
        while(!frase.isDescifrado()){
            System.out.print("Escriba una letra para adivinar: ");
            frase.descifrar(sc.nextLine().charAt(0));
            System.out.println(frase.getCifrado());
        }
        
        frase.victoria();
        
    }
    
}
