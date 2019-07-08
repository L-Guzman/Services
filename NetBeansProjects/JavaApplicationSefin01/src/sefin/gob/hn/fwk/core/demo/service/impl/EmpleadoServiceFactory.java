/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.service.impl;

import sefin.gob.hn.fwk.core.demo.service.def.IEmpleadoService;

/**
 *
 * @author Administrador
 */
public class EmpleadoServiceFactory {
    
    public IEmpleadoService obtenerEmpleadoService(String pTipo){
        IEmpleadoService empService = null;
        if(pTipo.equals("Db")){
            empService = new EmpleadoServiceImplDb();
        } else if (pTipo.equals("Ws")){
            empService = new EmpleadoServiceImplWs();
        }
        
        return empService;
    }
    
}
