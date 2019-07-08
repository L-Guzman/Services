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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sefin.gob.hn.fwk.core.demo.entity.Departamentos;
import sefin.gob.hn.fwk.core.demo.service.DepartamentoService;

/**
 *
 * @author Administrador
 */
@Path("/departamentos")
@RequestScoped
public class DepartamentoServiceRest {
    
    //Devuelve consulta de BD
    @Inject
    DepartamentoService serviceDepartamento;
    
    //Metodo GET porque se quiere obtener el listado
    @GET
    
    //Lo que se va a transmitir
    @Produces (MediaType.APPLICATION_JSON)
    //Declaracion del metodo
    public List<Departamentos> obtenerDepartamentos(){
        return serviceDepartamento.obtenerDepartamentos();
    }
    
    @GET
    @Path ("/estado/{pEstado}")
    @Produces (MediaType.APPLICATION_JSON)
    //Declaracion del metodo
    public List<Departamentos> obtenerDepartamentosEstado(@PathParam("pEstado") String pEstado){
        return serviceDepartamento.obtenerDepartamentosEstado(pEstado);
    }
    
     @GET
    @Path("/departamento")
     @Produces (MediaType.APPLICATION_JSON)
    //Declaracion del metodo
    public Departamentos obtenerDepartamentos(@QueryParam ("pIdDepartamento") String pIdDepartamento ){
          return serviceDepartamento.obtnerDepartamentos(pIdDepartamento);
    }
    
 @POST
    @Consumes (MediaType.APPLICATION_JSON)
    @Produces (MediaType.APPLICATION_JSON)
    public Response guardarDepartamento (Departamentos pDepartamento){
        Response.ResponseBuilder builder = null;
        
        serviceDepartamento.guardarDepartamento(pDepartamento);
        
        builder = Response.ok();
        
        return builder.build();
    }
}
