/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import sefin.gob.hn.fwk.core.demo.entity.Persona;

/**
 *
 * @author Administrador
 */
public class DemoApp {
    /*
    //metodo estatico sin devolver un valor de entrada, con arreglo de string.
    //estara reservado en un espacio de memoria, algo que se reserva para este metodo con unica instancia.
    //cuando no se hace se instancia un objeto, se crea una zona de memoria en base a la clase.
    //pueden existir multiples instancias del metodo, cuando es static solo hay un espacio de memoria, sin importar la cantidad de objetos 
    public static void main(String[] args) throws ParseException {
        
        System.out.println("Ejecutando DemoApp");
        
    Persona personaJuan = new Persona ();      
    
    personaJuan.setNombres("Juan Jose");
    personaJuan.setApellidos("Lopez Perez");
    personaJuan.setEstadoCivil("Soltero");
    personaJuan.setGenero("Masculino");
    personaJuan.setIdentidad("0820199500424");
    
    Date fechaNacimiento = null;
    
    DateFormat dateFormat = new SimpleDateFormat("ddMMyyy");
        DateFormat dfGeneral = new SimpleDateFormat("yyy-MM-dd");
    
        try {
            fechaNacimiento = dateFormat.parse("21032000");
        } catch (ParseException ex) {
            Logger.getLogger(DemoApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        personaJuan.setFechaNacimiento(fechaNacimiento);
        
        System.out.println("Nombre de Persona: " + personaJuan.getNombres() + " " + personaJuan.getApellidos() );
        System.out.println("Edad: " + personaJuan.obtenerEdad(null) );
        
        System.out.println("Fecha Nacimiento: " + dfGeneral.format(personaJuan.getFechaNacimiento()) );
        
        try {
            System.out.println("Edad por parametro: " + personaJuan.obtenerEdad(dateFormat.parse("16011984")) );
        } catch (ParseException ex){
               Logger.getLogger(DemoApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Persona pedro = null;
        pedro = new Persona("Pedro", "Paramo", "M", dateFormat.parse("27061990"), "Casado", "0820199500424");
        
        personaJuan = pedro;
        
        pedro.setNombres("Pedro Mateo");
        pedro.setApellidos("Paramo Dolores");
        
        System.out.println("Nombre Pedro: " + pedro.getNombres() + " " + pedro.getApellidos());
        
        System.out.println("Nombre Juan: " + personaJuan.getNombres() + " " + personaJuan.getApellidos());
    }
*/
}
