/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.entity;

import java.math.BigDecimal;
import java.util.Date;
import sefin.gob.hn.fwk.core.demo.exception.CodigoDuplicadoException;
import sefin.gob.hn.fwk.core.demo.exception.CodigoInvalidoException;

/**
 *
 * @author Administrador
 */
public class Empleado extends Persona {
    private String _codigoEmpleado;
    private Date _fechaContratacion;
    private BigDecimal _salario;
    private byte[] _foto;

    public Empleado() {
    }

    public Empleado(String pCodigoEmpleado, Date pFechaContratacion, BigDecimal pSalario, byte[] pFoto, String pNombres, String pApellidos, String pGenero, Date pFechaNacimiento, String pEstadoCivil, String pIdentidad) {
        super(pNombres, pApellidos, pGenero, pFechaNacimiento, pEstadoCivil, pIdentidad);
        this._codigoEmpleado = pCodigoEmpleado;
        this._fechaContratacion = pFechaContratacion;
        this._salario = pSalario;
        this._foto = pFoto;
    }
    
    

    /**
     * @return the _codigoEmpleado
     */
    public String getCodigoEmpleado() {
        return _codigoEmpleado;
    }

    /**
     * @param _codigoEmpleado the _codigoEmpleado to set
     */
    public void setCodigoEmpleado(String _codigoEmpleado) {
        this._codigoEmpleado = _codigoEmpleado;
    }

    /**
     * @return the _fechaContratacion
     */
    public Date getFechaContratacion() {
        return _fechaContratacion;
    }

    /**
     * @param _fechaContratacion the _fechaContratacion to set
     */
    public void setFechaContratacion(Date _fechaContratacion) {
        this._fechaContratacion = _fechaContratacion;
    }

    /**
     * @return the _salario
     */
    public BigDecimal getSalario() {
        return _salario;
    }

    /**
     * @param _salario the _salario to set
     */
    public void setSalario(BigDecimal _salario) {
        this._salario = _salario;
    }

    /**
     * @return the _foto
     */
    public byte[] getFoto() {
        return _foto;
    }

    /**
     * @param _foto the _foto to set
     */
    public void setFoto(byte[] _foto) {
        this._foto = _foto;
    }

    @Override
    public void validarCodigo() {
      // boolean valido = false;
       
       if(!_codigoEmpleado.startsWith("E"))
           //valido = true;
       throw new CodigoInvalidoException("El Codigo de Empleado no inicia con E");
       else if (_codigoEmpleado.equalsIgnoreCase("e002"))
           throw new CodigoDuplicadoException ("El Codigo de Empleado ya está Registrado");
    
       
       //return valido;
    }

    @Override
    public String toString() {
        return super.getNombres() + " " + super.getApellidos() + " CODIGO " + getCodigoEmpleado();
    }
   
    
}
