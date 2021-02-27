/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caseProblem2;

/**
 *
 * @author logra
 */
public class Rental {
    
    public final static int MIN_HOUR = 60;
    public final static int RENTA_HORA = 40;
    
    private String contrato;
    private Integer minutos;
    private Integer horas;
    private Integer min_extras;
    private Integer costo;
    private String telefono;
    
    public Rental(){
        this("A000", 0, "0000000000");
    }
    
    public Rental(String contrato, Integer minutos, String telefono) {
        setContrato(contrato);
        this.minutos = minutos;
        this.horas = minutos / 60;
        this.min_extras = this.minutos % 60;
        this.costo = (this.horas * 40) + (this.min_extras / 40) + (this.min_extras % 40);
        setTelefono(telefono);
    }
    
    public String aPagar(){
        return String.format("Contrato: %s\nHoras completas: %d\nMinutos extras: %d\n"
                + "Costo: $%d\nTelefono: %s", contrato, horas, min_extras, costo, this.getTelefono());
    }

    public void setContrato(String contrato) {
        if(this.isDigits(contrato.substring(1))){
            if((contrato.charAt(0) >= 'A' && contrato.charAt(0) <= 'Z')){
                this.contrato = contrato;
            }else if((contrato.charAt(0) >= 'a' && contrato.charAt(0) <= 'z')){
                this.contrato = contrato.substring(0,1).toUpperCase() + contrato.substring(1);
            }
        }
        else{
            this.contrato = "A000";
        }
    }
    
    public void setMinutos(int min){
        this.minutos = min;
        this.horas = min / 60;
        this.min_extras = min % 60;
        this.costo = (this.horas * 40) + (this.min_extras / 40) + (this.min_extras % 40);
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

    public String getContrato() {
        return contrato;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public Integer getHoras() {
        return horas;
    }

    public Integer getMin_extras() {
        return min_extras;
    }

    public Integer getCosto() {
        return costo;
    }
    
    public String getTelefono(){
        String tel = String.format("(%s) %s-%s", this.telefono.substring(0, 3), 
                this.telefono.substring(3, 6), this.telefono.substring(6));
        return tel;
    }
    
    public static void SammysMotto(){
        System.out.println("SSSSSSSSSSSSSSSSSSSSSSSS");
        System.out.println("S   Sammy's makes it   S");
        System.out.println("S    fun in the sun    S");
        System.out.print("SSSSSSSSSSSSSSSSSSSSSSSS\n\n");
    }
    
    private Boolean isDigits(String digits){
        if(digits.length() < 3) return false;
        else if(digits.charAt(0) >= '0' && digits.charAt(0) <= '9'){
            if (digits.charAt(1) >= '0' && digits.charAt(1) <= '9') {
                if(digits.charAt(2) >= '0' && digits.charAt(2) <= '9'){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static Rental largerRental(Rental a1, Rental a2){
        if(a1.getMinutos() > a2.getMinutos()){
            System.out.println("\nRenta 1 mas grande.");
            System.out.println("---------------------");
            return a1;
        }
        else if(a2.getMinutos() > a1.getMinutos()){
            System.out.println("\nRenta 2 mas grande.");
            System.out.println("---------------------");
            return a2;
        }
        else{
            System.out.println("\nRenta de la misma duracion.");
            System.out.println("---------------------");
            return a1;
        }
    }
    
    public static void cupones(Rental r){
        for (int i = 0; i < r.horas; i++) {
            System.out.println("Cupones del 10% de descuento en la proxima renta!");
        }
    }
}
