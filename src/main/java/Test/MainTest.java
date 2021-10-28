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
        
        long id1 = 1;
        
        MaestroDAO maestros = new MaestroDAO();
        maestros.agregar(new Maestro(id1, "pepe", "1234", "correo@gmail.com"));
        CursoDAO cursos = new CursoDAO();
        
    }
}
