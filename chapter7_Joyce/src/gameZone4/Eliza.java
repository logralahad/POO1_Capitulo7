/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author logra
 */
public class Eliza {
    
    private String saludo;
    private String respuesta;
    private String despedida;

    public Eliza() {
        this.saludo = "Hello, my name is Eliza. Nice to meet you!";
        this.despedida = "Have a nice day, it was a pleasure to meet you.";
    }
    
    public String conversar(String oracion){
        
        if(oracion.contains(" my ")){
            String persona = new String();
            String[] partes = oracion.split(" ");
            for (int i = 0; i < partes.length; i++) {
                if(partes[i].contentEquals("my")){
                    persona = partes[i + 1];                
                }
            }
            return String.format("Tell me more about your %s\n", persona);
        }
        else if(oracion.contains(" love ") || oracion.contains(" hate ") || oracion.contains(" dislike ")){
            return "You seem to have strong feelings about that\n";
        }
        else if(oracion.equals("Goodbye")){
            return this.despedida;
        }
        else{
            ArrayList<String> resp = new ArrayList(Arrays.asList("Please, go on.\n", 
                    "Tell me more\n", "Continue\n"));
            Random rd = new Random();
            return resp.get(rd.nextInt(resp.size()));
        }
    }
    
    
}
