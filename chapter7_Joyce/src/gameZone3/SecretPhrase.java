/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameZone3;

/**
 *
 * @author logra
 */
public class SecretPhrase {
    
    private String frase;
    private StringBuilder cifrado;
    private Boolean descifrado;
    
    public SecretPhrase(){
        this.frase = "Go Team";
        setCifrado();
        this.descifrado = false;
        
    }
    
    public String getCifrado(){
        return this.cifrado.toString();
    }
    
    public Boolean isDescifrado(){
        return this.descifrado;
    }
    
    private void setDescifrado(){
        if(this.frase.equals(this.cifrado.toString()) == true){
            this.descifrado = true;
        }else{
            this.descifrado = false;
        }
    }
    
    private void setCifrado(){
        this.cifrado = new StringBuilder();
        for (int i = 0; i < this.frase.length(); i++) {
            if(i % 3 == 0 || this.frase.charAt(i) == ' '){
                this.cifrado.append(this.frase.charAt(i));
            }
            else{
                this.cifrado.append('*');
            }
        }
    }
    
    public void descifrar(Character guess){
        int pos = this.frase.indexOf(guess);
        if(pos != -1){
           this.cifrado.setCharAt(pos, guess);
        }
        else{
            System.out.println("No esta la letra");
        }
        setDescifrado();
    }
    
    public void victoria(){
        System.out.println(String.format("\nGanaste, la frase era: %s", this.frase));
    }
    
}
