/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import sefin.gob.hn.fwk.core.demo.exception.CodigoDuplicadoException;
import sefin.gob.hn.fwk.core.demo.exception.CodigoInvalidoException;

/**
 *
 * @author Administrador
 */
public abstract class Persona {
    //propiedades (son equivalentes a los atributos)
    private String _nombres;
    private String _apellidos;
    private String _genero;
    private Date _fechaNacimiento;
    private String _estadoCivil;
    private String _identidad;
    
    
    //Constructores
    //Explicito
    public Persona(){
    
    }

    public Persona(String pNombres, String pApellidos, String pGenero, Date pFechaNacimiento, String pEstadoCivil, String pIdentidad) {
        _nombres = pNombres;
        _apellidos = pApellidos;
        _genero = pGenero;
        _fechaNacimiento = pFechaNacimiento;
        _estadoCivil = pEstadoCivil;
        _identidad = pIdentidad;
    }
    
    
   
    //metodos (son equivalentes a las funciones)

   
   
    /**
     * @return the _nombres
     */
    public String getNombres() {
        return _nombres;
    }

    /**
     * @param _nombres the _nombres to set
     */
    public void setNombres(String _nombres) {
        this._nombres = _nombres;
    }

    /**
     * @return the _apellidos
     */
    public String getApellidos() {
        return _apellidos;
    }

    /**
     * @param _apellidos the _apellidos to set
     */
    public void setApellidos(String _apellidos) {
        this._apellidos = _apellidos;
    }

    /**
     * @return the _genero
     */
    public String getGenero() {
        return _genero;
    }

    /**
     * @param _genero the _genero to set
     */
    public void setGenero(String _genero) {
        this._genero = _genero;
    }

    /**
     * @return the _fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return _fechaNacimiento;
    }

    /**
     * @param _fechaNacimiento the _fechaNacimiento to set
     */
    public void setFechaNacimiento(Date _fechaNacimiento) {
        this._fechaNacimiento = _fechaNacimiento;
    }

    /**
     * @return the _estadoCivil
     */
    public String getEstadoCivil() {
        return _estadoCivil;
    }

    /**
     * @param _estadoCivil the _estadoCivil to set
     */
    public void setEstadoCivil(String _estadoCivil) {
        this._estadoCivil = _estadoCivil;
    }

    /**
     * @return the _identidad
     */
    public String getIdentidad() {
        return _identidad;
    }

    /**
     * @param _identidad the _identidad to set
     */
    public void setIdentidad(String _identidad) {
        this._identidad = _identidad;
    }
    
     //alcance    tipo    nombre(parametros)
    public int obtenerEdad(Date pFechaNacimiento){
        Integer edad = null;
        Date fechaNac = null;
        
        if(pFechaNacimiento==null)
            fechaNac =getFechaNacimiento();
        else
            fechaNac =pFechaNacimiento;
        
        edad = Period.between(convertToLocalDateViaInstant(fechaNac), convertToLocalDateViaInstant(Calendar.getInstance().getTime())).getYears();
        
        return edad;
    }
    

public LocalDate convertToLocalDateViaInstant(Date dateToConvert){
return dateToConvert.toInstant()
.atZone(ZoneId.systemDefault())
.toLocalDate();
}


public abstract void validarCodigo() throws CodigoInvalidoException, CodigoDuplicadoException;

}
