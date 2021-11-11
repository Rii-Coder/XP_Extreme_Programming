/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
@Table(name = "Alumno")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;
    
    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "AñoIngreso", nullable = false, length = 100)
    private int añoIngreso;
    
    @Column(name = "Carrera", nullable = false, length = 100)
    private String carrera;
    
    @Column(name = "Edad", nullable = false, length = 100)
    private int edad;
    
    @Column(name = "numMaterias", nullable = false, length = 100)
    private int numMaterias;

    public Alumno() {
    }

    public Alumno(Long id, Grupo grupo, String nombre, int añoIngreso, String carrera, int edad, int numMaterias) {
        this.id = id;
        this.grupo = grupo;
        this.nombre = nombre;
        this.añoIngreso = añoIngreso;
        this.carrera = carrera;
        this.edad = edad;
        this.numMaterias = numMaterias;
    }

    public Alumno(Grupo grupo, String nombre, int añoIngreso, String carrera, int edad, int numMaterias) {
        this.grupo = grupo;
        this.nombre = nombre;
        this.añoIngreso = añoIngreso;
        this.carrera = carrera;
        this.edad = edad;
        this.numMaterias = numMaterias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(int añoIngreso) {
        this.añoIngreso = añoIngreso;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumMaterias() {
        return numMaterias;
    }

    public void setNumMaterias(int numMaterias) {
        this.numMaterias = numMaterias;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.nombre);
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
        return "Alumno{" + "grupo=" + grupo + ", nombre=" + nombre + ", añoIngreso=" + añoIngreso + ", carrera=" + carrera + ", edad=" + edad + ", numMaterias=" + numMaterias + '}';
    }

    

    
    
    
}
