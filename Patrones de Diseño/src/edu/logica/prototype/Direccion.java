/*
 * Modelos de programacion
 * Ejemplos de codigo de aplicacion de patrones
 */

package edu.logica.prototype;

public class Direccion implements Copiable{
    private String tipo;
    private String predio;
    private String ciudad;
    private String departamento;
    private String codigoPostal;
    public static final String FIN_LINEA ="-";
    public static final String COMMA = ",";
    public static final String CASA = "casa";
    public static final String OFICINA = "oficina";
    
    public Direccion(String tipoInicial, String predioInicial,
        String ciudadInicial, String departamentoInicial, String codigoInicial){
            tipo = tipoInicial;
            predio = predioInicial;
            ciudad = ciudadInicial;
            departamento = departamentoInicial;
            codigoPostal = codigoInicial;
    }
    
    public Direccion(String predioInicial, String ciudadInicial,
        String departamentoInicial, String codigoInicial){
            this(OFICINA, predioInicial, ciudadInicial, departamentoInicial, codigoInicial);
    }
    public Direccion(String tipoInicial){
        tipo = tipoInicial;
    }
    public Direccion(){ }
    
    public String getTipo(){ return tipo; }
    public String getPredio(){ return predio; }
    public String getCiudad(){ return ciudad; }
    public String getEstado(){ return departamento; }
    public String getCodigoPostal(){ return codigoPostal; }
    
    public void setTipo(String newTipo){ tipo = newTipo; }
    public void setPredio(String newPredio){ predio = newPredio; }
    public void setCiudad(String newCiudad){ ciudad = newCiudad; }
    public void setDepartamento(String newDepartamento){ departamento = newDepartamento; }
    public void setCodigoPostal(String newCodigo){ codigoPostal = newCodigo; }
    
    public Object copiar(){
        return new Direccion(predio, ciudad, departamento, codigoPostal);
    }
    
    public String toString(){
        return "\t" + predio + COMMA + " " + FIN_LINEA +
            "\t" + ciudad + COMMA + " " + departamento + " " + codigoPostal;
    }
}