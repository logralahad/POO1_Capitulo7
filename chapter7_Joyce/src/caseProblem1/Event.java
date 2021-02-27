/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caseProblem1;

/**
 *
 * @author logra
 */
public class Event {
    
    public final static int ALTO_PRECIO = 35;
    public final static int BAJO_PRECIO = 32;
    public final static int TIPO_EVENTO = 50;
    
    private String evento;
    private Integer num_inv;
    private Integer costo;
    private Integer costo_por_persona;
    private Boolean tam_evento;
    private String telefono;
    
    public Event(){
        this("A000", 0, "0000000000");
    }

    public Event(String evento, Integer num_inv, String telefono) {
        setEvento(evento);
        this.num_inv = num_inv;
        setTam_evento();
        this.costo_por_persona = this.costo / this.num_inv;
        setTelefono(telefono);
    }

    private void setTam_evento() {
        if(num_inv >= TIPO_EVENTO){
            this.costo = num_inv * BAJO_PRECIO;
            this.tam_evento = true;
        }else{
            this.costo = num_inv * ALTO_PRECIO;
            this.tam_evento = false;
        }
    }
    
    public void setEvento(String evento) {
        if(this.isDigits(evento.substring(1))){
            if((evento.charAt(0) >= 'A' && evento.charAt(0) <= 'Z')){
                this.evento = evento;
            }else if((evento.charAt(0) >= 'a' && evento.charAt(0) <= 'z')){
                this.evento = evento.substring(0,1).toUpperCase() + evento.substring(1);
            }
        }
        else{
            this.evento = "A000";
        }
    }

    public void setNum_inv(Integer num_inv) {
        this.num_inv = num_inv;
        setTam_evento();
    }
    
    public void setTelefono(String telefono){
        if(telefono.length() != 10){
            this.telefono = "0000000000";
        }
        else{
            for (int i = 0; i < telefono.length(); i++) {
                if(telefono.charAt(i) < '0' && telefono.charAt(i) > '9'){
                    telefono = telefono.replace(telefono.charAt(i), '\0');
                }
            }
            this.telefono = telefono;
        }
    }
    
    public Boolean getTam_evento() {
        return tam_evento;
    }

    public String getEvento() {
        return evento;
    }

    public Integer getNum_inv() {
        return num_inv;
    }

    public Integer getCosto() {
        return costo;
    }

    public Integer getCosto_por_persona() {
        return costo / num_inv;
    }
    
    public String getTelefono(){
        String tel = String.format("(%s) %s-%s", this.telefono.substring(0, 3), 
                this.telefono.substring(3, 6), this.telefono.substring(6));
        return tel;
    }
    
    public Boolean isLargeEvent(){
        return tam_evento;
    }
    
    private Boolean isDigits(String digits){
        if(digits.charAt(0) >= '0' && digits.charAt(0) <= '9'){
            if (digits.charAt(1) >= '0' && digits.charAt(1) <= '9') {
                if(digits.charAt(2) >= '0' && digits.charAt(2) <= '9'){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void CarlysMotto(){
        System.out.println("\n*************************");
        System.out.println("*   Carly’s makes the   *");
        System.out.println("*    food that makes    *");
        System.out.println("*      it a party!      *");
        System.out.print("*************************\n");
    }
    
    public String eCosto(){
        String s1 = String.format("Evento: %s\nNum. de invitados: %d\nPrecio por invitado: $%d\nTelefono: %s\n", 
                this.evento, this.num_inv, this.costo_por_persona, this.getTelefono());
        String s2 = String.format("Evento grande: %b\nCosto total: $%d", isLargeEvent(), this.costo);
        
        return String.format("\n%s%s", s1, s2);
    }

    
}
