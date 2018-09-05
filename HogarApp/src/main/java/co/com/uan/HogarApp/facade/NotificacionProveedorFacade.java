/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.uan.HogarApp.facade;

import co.com.uan.HogarApp.entities.NotificacionProveedor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rvill
 */
@Stateless
public class NotificacionProveedorFacade extends AbstractFacade<NotificacionProveedor> {

    @PersistenceContext(unitName = "EnterpriseApplication1-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificacionProveedorFacade() {
        super(NotificacionProveedor.class);
    }
    
}
