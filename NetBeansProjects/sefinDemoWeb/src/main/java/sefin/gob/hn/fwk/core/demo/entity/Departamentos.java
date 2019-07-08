/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sefin.gob.hn.fwk.core.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import static javax.swing.text.StyleConstants.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrador
 */
@Cacheable
@Entity
@NamedQueries({
    @NamedQuery(name = "encontrarTodosQry", query = "select d from Departamentos d",
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")}),
    @NamedQuery (name = "encontrarPorEstadoQry",
            query = "select d from Departamentos d where d.estado = :pEstado",
            hints = { @QueryHint(name = "org.hibernate.cacheable", value = "true")})
})
@Table(name = "Departamentos")
public class Departamentos implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @Column (name = "id_departamento")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String idDepartamento;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "nombre_departamento")
    private String nombreDepartamento;
    
    @NotNull
    @Column (name = "estado")
    private String estado;
    
    @JsonIgnore
    @OneToMany (mappedBy = "departamentoEmpleado")
    private List<Empleado>empleados;
    
    public String getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(String idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the nombreDepartamento
     */
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    /**
     * @param nombreDepartamento the nombreDepartamento to set
     */
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
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
     * @return the empleados
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idDepartamento);
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
        final Departamentos other = (Departamentos) obj;
        if (!Objects.equals(this.idDepartamento, other.idDepartamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Departamentos{" + "idDepartamento=" + idDepartamento + ", nombreDepartamento=" + nombreDepartamento + ", estado=" + estado + '}';
    }

    

   

    
    
}
