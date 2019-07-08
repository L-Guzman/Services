/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.app;

import sefin.gob.hn.fwk.core.demo.service.def.IEmpleadoService;
import sefin.gob.hn.fwk.core.demo.service.impl.EmpleadoServiceFactory;

/**
 *
 * @author Administrador
 */
public class ClienteInterfaceApp {
    
    public static void main(String[] args){
        EmpleadoServiceFactory empServiceFactory = new EmpleadoServiceFactory();
        
        IEmpleadoService empServiceDb = empServiceFactory.obtenerEmpleadoService("Db");
        
        IEmpleadoService empServiceWs = empServiceFactory.obtenerEmpleadoService("Ws");
        
        System.out.println("Obtener empleado de Base de Datos E001 " + empServiceDb.obtenerEmpleado("E001").toString());
        System.out.println("Obtener empleado de Service Web E002 " + empServiceWs.obtenerEmpleado("E002").toString());
    }
}
