
package co.com.uan.HogarApp.servicesImpl;

import java.util.ArrayList;
import java.util.List;

public class Proveedor extends Persona{
    
    private String estado;
    private int identificador;
    
    public Proveedor(){
        
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
    public List<Proveedor> consultarPersona(int identificador) {
        List<Proveedor> proveedor =  new ArrayList<>();
        setNombres("Eduardo");
        setApellidos("Michaela");
        proveedor.add(this);
        return proveedor;
    }

    @Override
    public List<Proveedor> consultarPersonas() {
        List<Proveedor> proveedor =  new ArrayList<>();
        setNombres("Eduardo");
        setApellidos("Michaela");
        proveedor.add(this);
        setNombres("Martina");
        setApellidos("Mendez");
        proveedor.add(this);
        return proveedor;
    }

    @Override
    public List buscarProveedor(int servicio) {
        List valor = new ArrayList<>();
        setApellidos("MisApelidos");
        valor.add(this);
        return valor;
    }

    @Override
    public void registrarPersona(List<?> proveedor) {
        System.out.println("Lógica para registrar a un proveedor");
    }
    
}
