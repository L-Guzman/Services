/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.service.rest;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import sefin.gob.hn.fwk.core.demo.entity.Empleado;
import sefin.gob.hn.fwk.core.demo.service.EmpleadoService;

/**
 *
 * @author Administrador
 */

@Path("/empleado")
@RequestScoped
public class EmpleadoServiceRest {
    
    @Inject
    EmpleadoService empService;
    
    @GET
    @Path ("/estado/{pEstado}")
    @Produces (MediaType.APPLICATION_JSON)
    //Declaracion del metodo
    public List<Empleado> buscarPorEstado(@PathParam("pEstado") String pEstado){
        return empService.buscarPorEstado(pEstado);
    
    }
    
    @GET
    @Path ("/departamento/{pIdDepartamento}")
    @Produces(MediaType.APPLICATION_JSON)
     public List<Empleado> buscarPorDepartamento(@PathParam ("pIdDepartamento") String pIdDepartamento ){
          return empService.buscarPorDepartamento(pIdDepartamento);
}
     @GET
     @Path("/buscarPor")
     @Produces (MediaType.APPLICATION_JSON)
     public List<Empleado> buscarPor(@Context UriInfo uriInfo){
          MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
          
        return empService.buscarPor(queryParams);
     }
}
