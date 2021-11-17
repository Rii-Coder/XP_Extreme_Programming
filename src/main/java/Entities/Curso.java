/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "Curso")
public class Curso {
    
    @Id
    @Column(name = "IdCurso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Grupo> grupos; //provisional
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "idMaestro")
    private Maestro maestro;
    
    @Column(name = "unidades", nullable = false)
    private int unidades;

    public Curso(){}

    public Curso(String nombre, int unidades, Maestro maestro) {
        this.nombre = nombre;
        this.unidades = unidades;
        this.grupos = new ArrayList<>();
        this.maestro = maestro;
    }

    public Curso(Long id, String nombre, List<Grupo> grupos, int unidades, Maestro maestro) {
        this.id = id;
        this.nombre = nombre;
        this.grupos = grupos;
        this.unidades = unidades;
        this.maestro = maestro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nombre=" + nombre + ", maestro=" + maestro + ", unidades=" + unidades + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.nombre);
        hash = 83 * hash + Objects.hashCode(this.maestro);
        hash = 83 * hash + this.unidades;
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
        final Curso other = (Curso) obj;
        if (this.unidades != other.unidades) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.maestro, other.maestro)) {
            return false;
        }
        return true;
    }
    
    
    
    public Object[] toArray() {
        return new Object[]{
            this.id,
            this.nombre,
            this.unidades
            
        };

    }
    
    
}
