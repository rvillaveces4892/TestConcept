	
package co.com.uan.HogarApp.interfaces;

import java.util.List;

import co.com.uan.HogarApp.entities.Categoria;

public interface ICategoria {
    
    public List<Categoria> listarCategorias();
    public Categoria findCategoriaByID(Long idCategoria);
}