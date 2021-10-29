/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetoNegocio;
import Entities.Curso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Armando
 */
public class ControlCurso {
    public void insertarCurso(Curso curso){
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("xp_PU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(curso);
        entityManager.getTransaction().commit();
        System.out.println("El curso se ha agregado");
        }
    
    public void agregarCurso(Curso curso){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xp_PU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Curso cursoAux = entityManager.find(Curso.class, curso.getId());
        if (cursoAux != null) {

            cursoAux.setNombre(curso.getNombre());
            cursoAux.setId(curso.getId());
            cursoAux.setMaestro(curso.getMaestro());
            cursoAux.setUnidades(curso.getUnidades());
            cursoAux.setGrupos(curso.getGrupos());
            

        } else {
            System.out.println("El curso no existe");
        }

        entityManager.getTransaction().commit();
        System.out.println("Curso actualizado correctamente");
    }
    
    public boolean eliminarCurso(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xp_PU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        Curso curso = entityManager.find(Curso.class, id);
        if (curso != null) {
            entityManager.remove(curso);
        } else {
            System.out.println("El curso no fue encontrado");
            return false;
        }

        entityManager.getTransaction().commit();
        System.out.println("Curso eliminado correctamente");
        return true;
    }
    
    public List<Curso> consultarCursos(String nombre){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xp_PU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        
        List<Curso> cursos;
         if (!nombre.equals("")) {
            String jpql = String.format("SELECT * FROM xp.cursos WHERE xp.cursos.nombres = '%s';", nombre);
            cursos = entityManager.createNativeQuery(jpql, Curso.class).getResultList();
        } else {
            String jpql = "SELECT * FROM xp.cursos;";
            cursos = entityManager.createNativeQuery(jpql, Curso.class).getResultList();
        }
        entityManager.getTransaction().commit();
        return cursos;
    }
    
   public Curso consultarCurso(Integer id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("xp_PU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        
        
        entityManager.getTransaction().commit();
        return entityManager.find(Curso.class, id);
    }
    
}
