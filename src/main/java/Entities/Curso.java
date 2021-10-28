/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brandon
 */
public class Curso {
    
    String nombre;
    List<Grupo> grupos; //provisional
    byte unidades;

    public Curso(){
        
    }
    
    public Curso(String nombre, ArrayList<Grupo> grupo, byte unidades) {
        this.nombre = nombre;
        this.grupos = grupo;
        this.unidades = unidades;
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
    
    
}
