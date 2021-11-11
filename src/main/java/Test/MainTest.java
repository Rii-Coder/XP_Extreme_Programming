/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO.CursoDAO;
import DAO.MaestroDAO;
import Entities.Curso;
import Entities.Maestro;

/**
 *
 * @author R2
 */
public class MainTest {
    public static void main(String[] args) {
        
        
        MaestroDAO maestros = new MaestroDAO();
        try {
            maestros.agregar(new Maestro("pepe", "123456", "pepe@gmail.com"));
        } catch (Exception e) {
        }
        
        //CursoDAO cursos = new CursoDAO();
        //cursos.agregar(new Curso());
    }
}
