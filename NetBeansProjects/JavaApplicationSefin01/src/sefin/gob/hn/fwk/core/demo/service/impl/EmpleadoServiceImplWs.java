/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import sefin.gob.hn.fwk.core.demo.entity.Empleado;
import sefin.gob.hn.fwk.core.demo.service.def.IEmpleadoService;

/**
 *
 * @author Administrador
 */
public class EmpleadoServiceImplWs implements IEmpleadoService {

    @Override
    public void guardarEmpleado(Empleado emp) {
        
    }

    @Override
    public Empleado obtenerEmpleado(String pCodigoEmpleado) {
        Empleado emp = null; 
         if(pCodigoEmpleado.equals("E001")){
             emp = new Empleado();
              emp.setCodigoEmpleado("E001");
             emp.setNombres("Jose");
             emp.setApellidos("Rodriguez");
             emp.setFechaContratacion(Calendar.getInstance().getTime());
             emp.setSalario(BigDecimal.valueOf(15000));
             
         }   
         
         else if (pCodigoEmpleado.equals("E002")){
              Empleado empDos = null; 
             emp = new Empleado();
              emp.setCodigoEmpleado("E002");
             emp.setNombres("Juan");
             emp.setApellidos("Perez");
             emp.setFechaContratacion(Calendar.getInstance().getTime());
             emp.setSalario(new BigDecimal("25000"));
         }
         
         return emp;       
        
    }

    @Override
    public List<Empleado> obtenerListaEmpleado() {
       List<Empleado> lista = new ArrayList<Empleado>();
       
       lista.add(this.obtenerEmpleado("E001"));
       lista.add(obtenerEmpleado("E002"));
       
       return lista;
    }

    @Override
    public Double calcularRentaEmpleado(Empleado emp) {
       Double renta = 0d;
       Double porcentaje = 0d;
       
       porcentaje = emp.getSalario().compareTo(BigDecimal.valueOf(20000d))==1? 0.25d : 0.15d;
       
      //Orientado a Objetos sería: 
      //renta = emp.getSalario().multiply(BigDecimal.valueOf(porcentaje)).doubleValue();
       
       renta = emp.getSalario().doubleValue() * porcentaje;
       
       return renta;
    }
    
}
