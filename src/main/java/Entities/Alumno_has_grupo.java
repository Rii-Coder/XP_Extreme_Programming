/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author R2
 */
@Entity
@Table(name = "Alumno_has_grupo")
public class Alumno_has_grupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Fecha")
    private Date fecha;
    
    @Column(name = "Asistencia")
    private boolean asistencia;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "idAlumno")
    private Alumno alumno;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;
    

    public Alumno_has_grupo() {
    }

    public Alumno_has_grupo(Long id, Date fecha, boolean asistencia, Alumno alumno, Grupo grupo) {
        this.id = id;
        this.fecha = fecha;
        this.asistencia = asistencia;
        this.alumno = alumno;
        this.grupo = grupo;
    }

    public Alumno_has_grupo(Date fecha, boolean asistencia, Alumno alumno, Grupo grupo) {
        this.fecha = fecha;
        this.asistencia = asistencia;
        this.alumno = alumno;
        this.grupo = grupo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.fecha);
        hash = 97 * hash + (this.asistencia ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.alumno);
        hash = 97 * hash + Objects.hashCode(this.grupo);
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
        final Alumno_has_grupo other = (Alumno_has_grupo) obj;
        if (this.asistencia != other.asistencia) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.alumno, other.alumno)) {
            return false;
        }
        if (!Objects.equals(this.grupo, other.grupo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alumno_has_grupo{" + "id=" + id + ", fecha=" + fecha + ", asistencia=" + asistencia + ", alumno=" + alumno + ", grupo=" + grupo + '}';
    }

    
    
}
