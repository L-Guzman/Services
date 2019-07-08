/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.service;

import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import sefin.gob.hn.fwk.core.demo.entity.Departamentos;

/**
 *
 * @author Administrador
 */
@Transactional
@Named
public class DepartamentoService {
    @PersistenceContext //Lee la persistencia que se tiene de escritura, lee todas las configuraciones y las inyecta.
   
    private EntityManager em;
    
    //Metodo para desplegar el listado de Departamento
    //Ejecucion del primer Query
    public List<Departamentos> obtenerDepartamentos() {
    List<Departamentos> lista = null;

     TypedQuery query = em.createNamedQuery("encontrarTodosQry", Departamentos.class); 
      //query.setHint("org.hibernate.cacheable", "true");
     
     lista = query.getResultList();
    
     return lista;
    }
    
     public List<Departamentos> obtenerDepartamentosEstado(String pEstado) {
    List<Departamentos> lista = null;

     TypedQuery query = em.createNamedQuery("encontrarPorEstadoQry", Departamentos.class); 
     
     query.setParameter("pEstado", pEstado);
     //query.setHint("org.hibernate.cacheable", "true");
     
     lista = query.getResultList();
    
     return lista;
    }
     
     public Departamentos obtnerDepartamentos (String pIdDepartamento){
         Departamentos dep = null;
         
         dep = em.find(Departamentos.class, pIdDepartamento);
         return dep;
     }
     
     public void guardarDepartamento(Departamentos pDepartamento){
         em.persist(pDepartamento);
     }

   
}
