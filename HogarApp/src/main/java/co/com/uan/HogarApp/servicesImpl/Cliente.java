
package co.com.uan.HogarApp.servicesImpl;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    
    private String estado;
    private int identificador;
    
    public Cliente(){
        
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public List<Cliente> consultarPersona(int identificador) {
        List<Cliente> cliente =  new ArrayList<>();
        setNombres("Eduardo");
        setApellidos("Michaela");
        cliente.add(this);
        return cliente;
    }

    @Override
    public List<Cliente> consultarPersonas() {
        List<Cliente> cliente =  new ArrayList<>();
        setNombres("Eduardo");
        setApellidos("Michaela");
        cliente.add(this);
        setNombres("Martina");
        setApellidos("Mendez");
        cliente.add(this);
        return cliente;
    }

    @Override
    public List buscarProveedor(int servicio) {
        throw new UnsupportedOperationException("No es aplicable");
    }

    @Override
    public void registrarPersona(List<?> cliente) {
        System.out.println("Lógica para registrar a un cliente");
    }
    
}
