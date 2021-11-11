
package Entities;

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
    @JoinColumn(name = "idMaestro")
    private Maestro maestro;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "idCurso")
    private Curso curso;
    
    @OneToMany(mappedBy = "Grupo", cascade = CascadeType.ALL)
    private List<Alumno> alumnos;
    
    @Column(name = "Nombre")
    private String nombre;
    
    public Grupo() {
    }

    public Grupo(Long id, Maestro maestro, Curso curso, List<Alumno> alumnos, String nombre) {
        this.id = id;
        this.maestro = maestro;
        this.curso = curso;
        this.alumnos = alumnos;
        this.nombre = nombre;
    }

    public Grupo(Long id, Maestro maestro, Curso curso, String nombre) {
        this.id = id;
        this.maestro = maestro;
        this.curso = curso;
        this.nombre = nombre;
        this.alumnos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.maestro);
        hash = 79 * hash + Objects.hashCode(this.curso);
        hash = 79 * hash + Objects.hashCode(this.nombre);
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
        if (!Objects.equals(this.maestro, other.maestro)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Grupo{" + "nombre=" + nombre + ", maestro=" + maestro + ", curso=" + curso + ", alumnos=" + alumnos + '}';
    }

    
    
}
