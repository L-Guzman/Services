/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.exception;

/**
 *
 * @author Administrador
 */
public class CodigoInvalidoException extends RuntimeException {
    public CodigoInvalidoException(String pMensajeError){
        super(pMensajeError);
    }
}
