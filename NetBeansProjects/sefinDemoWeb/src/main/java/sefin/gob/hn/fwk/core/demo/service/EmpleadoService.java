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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.ws.rs.core.MultivaluedMap;
import sefin.gob.hn.fwk.core.demo.entity.Empleado;

/**
 *
 * @author Administrador
 */
@Transactional
@Named
public class EmpleadoService {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<Empleado> buscarPorEstado(String pEstado){
        List<Empleado> lista = null;
        
        //BASE CRITERIA
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Empleado> criteria = cb.createQuery(Empleado.class);
        
        //FROM
        Root<Empleado> empleado = criteria.from(Empleado.class);
        
        //Construcciones dinamicas: SELECT Y WHERE
        criteria.select(empleado).where(cb.equal(empleado.get("estado"),pEstado) );
        
        //EJECUCION
        lista = em.createQuery(criteria).getResultList();
        
        return lista;
    }
    
    public List<Empleado> buscarPorDepartamento(String pIdDepartamento){
        List<Empleado> lista = null;
        
        //BASE CRITERIA
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Empleado> criteria = cb.createQuery(Empleado.class);
        
        //FROM
        Root<Empleado> empleado = criteria.from(Empleado.class);
        
        //Construcciones dinamicas: SELECT Y WHERE
        criteria.select(empleado).where(cb.equal(empleado.get("departamentoEmpleado"). get("idDepartamento"),pIdDepartamento) );
        
        //EJECUCION
        lista = em.createQuery(criteria).getResultList();
        
        return lista;
    }
    
    public List<Empleado> buscarPor (MultivaluedMap <String, String> parametros){
        List<Empleado> lista = null;
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Empleado> criteria = cb.createQuery(Empleado.class);
        
        Root<Empleado> empleado = criteria.from(Empleado.class);
        int conteo = 0;
        Predicate predicado = null;
        for(String param : parametros.keySet()){
            String valor = parametros.getFirst(param);
            Predicate pred= null ;
            if(param != null && !param.isEmpty() && valor!=null && !valor.isEmpty()){
                switch (param){
                    case "estado":
                        pred = cb.equal(empleado.get("estado") , valor);
                        break;
                    case "departamento":
                        pred = cb.equal(empleado.get("departamentoEmpleado").get("idDepartamento"), valor);
                        break;
                    case "nombre":
                        pred = cb.like(empleado.<String>get("nombre"), "%"+valor+"%");
                        break;
                }
            }
            
            if(conteo==0){
                predicado = pred;
            } else {
                predicado = cb.and(predicado, pred);
            }
            conteo ++;
        }
        
    criteria.select(empleado).where(predicado);
    lista = em.createQuery(criteria).getResultList();
    return lista;
    }
    
   public void guardarEmpleado(Empleado pEmpleado) {
       em.persist(pEmpleado);
   }
}
