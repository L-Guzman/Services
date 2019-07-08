/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import sefin.gob.hn.fwk.core.demo.entity.Cliente;
import sefin.gob.hn.fwk.core.demo.entity.Empleado;
import sefin.gob.hn.fwk.core.demo.entity.Persona;
import sefin.gob.hn.fwk.core.demo.exception.CodigoDuplicadoException;
import sefin.gob.hn.fwk.core.demo.exception.CodigoInvalidoException;

/**
 *
 * @author Administrador
 */
public class HerenciaApp {
    
    public static void main(String[] args) {
        System.out.println("Validando uso de Herencia");
        
        List<Persona> personas = new ArrayList<Persona>();
        
        Empleado pUno = new Empleado("E002", Calendar.getInstance().getTime(), 
                new BigDecimal("1500"), null, "Juan", "Gomez", "M", 
                Calendar.getInstance().getTime(), "Soltero", "0820199500424");
        personas.add(pUno);
        Cliente pDos = new Cliente("001", "Tegucigalpa", "sefin@gob.hn", "Mateo", "Guzman", "M", 
                Calendar.getInstance().getTime(), "Soltero", "0801200000322");
        
        personas.add(pDos);
        
        for(Persona per: personas){
            System.out.println("\nNombre: " + per.getNombres() + " " + per.getApellidos());
            
            if (per instanceof Cliente)
            {
                Cliente cl = (Cliente) per;
                System.out.println ("Cliente codigo: " + cl.getCodigoCliente());
                
                
                try {
                    cl.validarCodigo();
                    System.out.println ("Codigo Cliente Valido " );
                } catch (CodigoInvalidoException e){
                    System.out.println ("Codigo Cliente Invalido " );
                }
                
                 
            }
            if (per instanceof Empleado)
            {
                Empleado emp = (Empleado) per;
                System.out.println ("Empleado codigo: " + emp.getCodigoEmpleado());
                
                
                try {
                    emp.validarCodigo();
                    System.out.println ("Codigo Empleado Valido " );
                } catch (CodigoInvalidoException | CodigoDuplicadoException e){
                    System.out.println (e.getMessage() );
                } 
                
                
            }
        }
    }
    
}
