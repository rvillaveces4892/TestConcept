/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.uan.HogarApp.facade;

import co.com.uan.HogarApp.entities.Coordenadas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rvill
 */
@Stateless
public class CoordenadasFacade extends AbstractFacade<Coordenadas> {

//    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
    	if(em == null)
            em = Persistence.createEntityManagerFactory("EnterpriseApplication1-ejbPU").createEntityManager();
    	return em;
    }

    public CoordenadasFacade() {
        super(Coordenadas.class);
    }
    
}
