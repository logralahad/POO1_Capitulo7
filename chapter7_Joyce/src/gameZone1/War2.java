/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone1;

import java.util.Random;

/**
 *
 * @author logra
 */
public class War2 {

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        // TODO code application logic here
        Card jugador = new Card();
        jugador.setSuit();
        jugador.setValor();
        
        Card pc = new Card();
        pc.setSuit();
        pc.setValor();
        
        System.out.println("Jugador: ");
        jugador.showCard();
        
        System.out.println("Computadora: ");
        pc.showCard();
        
        Card.winWar(jugador, pc);
        
    }
    
}
