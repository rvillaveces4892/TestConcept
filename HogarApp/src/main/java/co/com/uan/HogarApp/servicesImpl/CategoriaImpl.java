
package co.com.uan.HogarApp.servicesImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import co.com.uan.HogarApp.entities.Categoria;
import co.com.uan.HogarApp.interfaces.ICategoria;

@Component
@Configuration
public class CategoriaImpl implements ICategoria{

    @Autowired
    private EntityManager em;

    public CategoriaImpl(){
    }

    @Override
    public List<Categoria> obtenerCategorias(){
        List<Categoria> categorias=em.createNamedQuery("Categoria.findAll",Categoria.class).setParameter("estado","ACTIVO").getResultList();
        return categorias;
    }

    @Override
    public Categoria obtenerCategoriaPorId(Long categoria_id){
        Categoria categoria=em.createNamedQuery("Categoria.findByCategoriaId",Categoria.class).setParameter("categoriaId",categoria_id).setParameter("estado","ACTIVO").getSingleResult();
        return categoria;
    }

}
