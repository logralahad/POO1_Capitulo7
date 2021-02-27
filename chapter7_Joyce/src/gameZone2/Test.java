/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone2;

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
        RockPaperScissors2 game = new RockPaperScissors2();
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 10; i++) {
            do {
                System.out.print("Elija entre piedra, papel o tijeras: ");
                game.setTipoJugada(sc.nextLine());
            } while (game.getValido() == false);


            System.out.println("\nComputadora saco: " + RockPaperScissors2.jugada(game.getComputadora()));
            System.out.println("Jugador saco: " + game.getTipoJugada());
            game.resultado();
        }
        
        System.out.println("Jugador gano: " + game.getScoreJugador());
        System.out.println("Computadora gano: " + game.getScorePC());
        System.out.println("Juegos empatados: " + game.getEmpates());
        
    }
}
