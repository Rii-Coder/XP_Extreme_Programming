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
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "idMaestro")
    private Maestro maestro;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Grupo> grupos; //provisional
    
    @Column(name = "unidades", nullable = false)
    private byte unidades;

    public Curso(){
        
    }

    public Curso(Long id, String nombre, Maestro maestro, List<Grupo> grupos, byte unidades) {
        this.id = id;
        this.nombre = nombre;
        this.maestro = maestro;
        this.grupos = grupos;
        this.unidades = unidades;
    }
    
    public Curso(String nombre, ArrayList<Grupo> grupo, byte unidades) {
        this.nombre = nombre;
        this.grupos = grupo;
        this.unidades = unidades;
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

    public byte getUnidades() {
        return unidades;
    }

    public void setUnidades(byte unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Curso:" + nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.maestro);
        hash = 89 * hash + this.unidades;
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
            this.maestro,
            this.grupos,
            this.unidades
            
        };

    }
    
    
}
