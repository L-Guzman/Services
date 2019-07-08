/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.entity;

import java.util.Date;
import sefin.gob.hn.fwk.core.demo.exception.CodigoInvalidoException;

/**
 *
 * @author Administrador
 */
public class Cliente extends Persona {
    private String _codigoCliente;
    private String _direccion;
    private String _correo;

    /**
     * @return the _codigoCliente
     */
    public String getCodigoCliente() {
        return _codigoCliente;
    }

    /**
     * @param _codigoCliente the _codigoCliente to set
     */
    public void setCodigoCliente(String _codigoCliente) {
        this._codigoCliente = _codigoCliente;
    }

    /**
     * @return the _direccion
     */
    public String getDireccion() {
        return _direccion;
    }

    /**
     * @param _direccion the _direccion to set
     */
    public void setDireccion(String _direccion) {
        this._direccion = _direccion;
    }

    /**
     * @return the _correo
     */
    public String getCorreo() {
        return _correo;
    }

    /**
     * @param _correo the _correo to set
     */
    public void setCorreo(String _correo) {
        this._correo = _correo;
    }

    public Cliente() {
    }

    public Cliente(String pCodigoCliente, String pDireccion, String pCorreo, String pNombres, String pApellidos, String pGenero, Date pFechaNacimiento, String pEstadoCivil, String pIdentidad) {
        super(pNombres, pApellidos, pGenero, pFechaNacimiento, pEstadoCivil, pIdentidad);
        this._codigoCliente = pCodigoCliente;
        this._direccion = pDireccion;
        this._correo = pCorreo;
    }

    @Override
    public void validarCodigo() {
       // boolean valido = false;
       
       if(!_codigoCliente.startsWith("C"))
             throw new CodigoInvalidoException("El Codigo de Cliente no inicia con C");
          // valido = true;
       
       //return valido;
    }
    
}
