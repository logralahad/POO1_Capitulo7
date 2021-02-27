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
public class Card {
    
    private Suit suit;
    private Integer valor;
    private String tipo;

    public Card() {
        this.suit = Suit.CORAZONES;
        this.valor = 1;
        setTipo();
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit() {
        randomSuit();
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor() {
        randomValue();
    }
    
    private void setTipo(){
        switch(valor) {
            case 1:
                this.tipo = "Ace";
                break;
                
            case 11:
                this.tipo = "Jack";
                break;
                
            case 12:
                this.tipo = "Queen";
                break;
                
            case 13:
                this.tipo = "King";
                break;
                
            default:
                this.tipo = String.valueOf(this.valor);
                break;
        }
    }
    
    public void showCard(){
        System.out.println(String.format("%s de %s", this.tipo, this.suit));
    }
    
    public void randomSuit(){
        Suit[] tipos = Suit.values();
        Random rnd = new Random();
        
        this.suit = tipos[rnd.nextInt(tipos.length)];
    }
    
    public void randomValue(){
        Random rand = new Random();
        int val = rand.nextInt(13) + 1;
        
        this.valor = val;
        setTipo();
    }
    
    public static boolean changeCard(Card a, Card b){
        if(a.getSuit() == b.getSuit()){
            b.setSuit();
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void winWar(Card a, Card b){
        if(a.getValor() > b.getValor() && changeCard(a, b) == false){
            System.out.println("\nJugador gano!");
        }
        else if(a.getValor() < b.getValor() && changeCard(a, b) == false){
            System.out.println("\nComputadora gano!");
        }
        else{
            changeCard(a, b);
            System.out.println("\nEmpate!");
        }
    }
}
