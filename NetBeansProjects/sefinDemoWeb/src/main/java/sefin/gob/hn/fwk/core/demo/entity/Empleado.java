/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Cacheable
@Entity
@Table (name = "Empleado")
public class Empleado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column (name = "id_empleado")
    private String idEmpleado;
    
    @Column (name = "nombre_empleado")
    private String nombre;
    
    @Column (name = "estado")
    private String estado;
    
    
    @JoinColumn (name = "id_departamento")
    @ManyToOne
    private Departamentos departamentoEmpleado;

    /**
     * @return the idEmpleado
     */
    public String getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    /**
     * @return the departamentoEmpleado
     */
    public Departamentos getDepartamentoEmpleado() {
        return departamentoEmpleado;
    }

    /**
     * @param departamentoEmpleado the departamentoEmpleado to set
     */
    public void setDepartamentoEmpleado(Departamentos departamentoEmpleado) {
        this.departamentoEmpleado = departamentoEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idEmpleado);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.idEmpleado, other.idEmpleado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + '}';
    }
    
}
