package Entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Brandon
 */
@Entity
@Table(name = "Grupo")
public class Grupo {

    @Id
    @Column(name = "IdGrupo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idCurso")
    private Curso curso;

    @OneToMany(mappedBy = "grupo", cascade = CascadeType.ALL)
    private List<Alumno_has_grupo> alumno_has_grupos;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "FechaInicio")
    private Date fechaInicio;

    public Grupo() {
    }

    public Grupo(Long id, Curso curso, String nombre, Date fechaInicio) {
        this.id = id;
        this.curso = curso;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        alumno_has_grupos = new ArrayList<>();
    }

    public Grupo(Curso curso, String nombre, Date fechaInicio) {
        this.curso = curso;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        alumno_has_grupos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Alumno_has_grupo> getAlumno_has_grupos() {
        return alumno_has_grupos;
    }

    public void setAlumno_has_grupos(List<Alumno_has_grupo> alumno_has_grupos) {
        this.alumno_has_grupos = alumno_has_grupos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.curso);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.fechaInicio);
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
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Grupo{" + "id=" + id + ", curso=" + curso + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + '}';
    }

}
