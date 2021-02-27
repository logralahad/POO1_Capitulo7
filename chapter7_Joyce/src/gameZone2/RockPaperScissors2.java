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
public class RockPaperScissors2 {

    private Integer jugador;
    private Integer computadora;
    private String tipo_jugada;
    private Boolean valido;
    private Integer score_jugador;
    private Integer score_pc;
    private Integer empates;
    
    public RockPaperScissors2(){
        this.score_jugador = 0;
        this.score_pc = 0;
        this.empates = 0;
    }

    public void resultado() {
        if (this.jugador == this.computadora) {
            System.out.print("Empate, jueguen otra vez!\n\n");
            this.empates++;
        }
        else if ((this.jugador == 1 && this.computadora == 3) ||(this.jugador == 2 && this.computadora == 1) 
                ||(this.jugador == 3 && this.computadora == 2)  ){
            System.out.print("Gano el jugador!\n\n");
            this.score_jugador++;
        }
        else if ((this.jugador == 1 && this.computadora == 2) || (this.jugador == 2 && this.computadora == 3) 
                || (this.jugador == 3 && this.computadora == 1)){
            System.out.print("Perdio el jugador!\n\n");
            this.score_pc++;
        }

    }

    private void setJugador() {
        switch (this.tipo_jugada) {
            case "Piedra":
                this.jugador = 1;
                break;
                
            case "Papel":
                this.jugador = 2;
                break;
                
            case "Tijeras":
                this.jugador = 3;
                break;
            default:
                this.jugador = 0;
                break;
        }
        this.setComputadora();
    }

    public Integer getComputadora() {
        return computadora;
    }

    private void setComputadora() {
        this.computadora = (int)(Math.random() * 3 + 1);
    }
    
    public String getTipoJugada(){
        return this.tipo_jugada;
    }
    
    public Boolean getValido(){
        return this.valido;
    }
    
    public Integer getScoreJugador(){
        return this.score_jugador;
    }
    
    public Integer getScorePC(){
        return this.score_pc;
    }
    
    public Integer getEmpates(){
        return this.empates;
    }
    
    public void setTipoJugada(String jugada){
        if(jugada.startsWith("pi") || jugada.startsWith("pI") || jugada.startsWith("Pi") || jugada.startsWith("PI")){
            this.tipo_jugada = "Piedra";
            this.valido = true;
        }
        else if(jugada.startsWith("pa") || jugada.startsWith("pA") || jugada.startsWith("Pa") || jugada.startsWith("PA")){
            this.tipo_jugada = "Papel";
            this.valido = true;
        }
        else if(jugada.startsWith("ti") || jugada.startsWith("tI") || jugada.startsWith("Ti") || jugada.startsWith("TI")){
            this.tipo_jugada = "Tijeras";
            this.valido = true;
        }else{
            this.tipo_jugada = "INVALIDO";
            this.valido = false;
        }
        this.setJugador();
    }
    
    public static String jugada(Integer var){
        switch (var) {
            case 1:
                return "Piedra";
            
            case 2:
                return "Papel";
                
            case 3:
                return "Tijeras";
                
            default:
                return "INVALIDO";
        }
    }
}



