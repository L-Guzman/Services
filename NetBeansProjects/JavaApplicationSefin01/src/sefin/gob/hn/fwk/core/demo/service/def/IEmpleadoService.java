/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.service.def;

import java.util.List;
import sefin.gob.hn.fwk.core.demo.entity.Empleado;

/**
 *
 * @author Administrador
 */
public interface IEmpleadoService {
    
    void guardarEmpleado(Empleado emp);
    
    Empleado obtenerEmpleado(String pCodigoEmpleado);
    
    List<Empleado> obtenerListaEmpleado();
    
    Double calcularRentaEmpleado(Empleado emp);
    
}
