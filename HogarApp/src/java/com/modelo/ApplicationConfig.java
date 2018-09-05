/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author rootMaster
 */
@javax.ws.rs.ApplicationPath("datosHogarapp")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.modelo.CalificacionesFacadeREST.class);
        resources.add(com.modelo.CategoriaServicioFacadeREST.class);
        resources.add(com.modelo.CategoriasFacadeREST.class);
        resources.add(com.modelo.CoordenadasFacadeREST.class);
        resources.add(com.modelo.EscolaridadFacadeREST.class);
        resources.add(com.modelo.NotificacionesFacadeREST.class);
        resources.add(com.modelo.ParametrosFacadeREST.class);
        resources.add(com.modelo.RolesFacadeREST.class);
        resources.add(com.modelo.ServiciosFacadeREST.class);
        resources.add(com.modelo.SolicitudFacadeREST.class);
        resources.add(com.modelo.UsuariosFacadeREST.class);
    }
    
}
