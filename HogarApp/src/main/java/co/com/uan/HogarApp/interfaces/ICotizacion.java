
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import co.com.uan.HogarApp.entities.Cotizacion;

public interface ICotizacion {
    
    public List<Cotizacion> listarCotizacion(int idProveedor);
    public void enviarCotizacion(int idCliente);
    
}
