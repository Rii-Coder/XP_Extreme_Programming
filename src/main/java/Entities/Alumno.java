/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
 * @author R2
 */
@Entity
@Table(name = "Alumno")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Alumno_has_grupo> alumno_has_grupos;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;

    public Alumno() {
    }

    public Alumno(Long id, List<Alumno_has_grupo> alumno_has_grupos, String nombre, Grupo grupo) {
        this.id = id;
        this.alumno_has_grupos = alumno_has_grupos;
        this.nombre = nombre;
        this.grupo = grupo;
    }

    public Alumno(String nombre, Grupo grupo) {
        this.nombre = nombre;
        this.grupo = grupo;
        alumno_has_grupos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.nombre);
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
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    public Object[] toArray() {
        return new Object[]{
            this.id,
            this.nombre,
            this.grupo.getId()
            
        };

    }

}
