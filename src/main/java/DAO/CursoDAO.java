/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author R2
 */
public class CursoDAO extends BaseDAO<Curso>{

    @Override
    public void agregar(Curso entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(Long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Curso curso = entityManager.find(Curso.class, id);
        if (curso != null) {
            entityManager.remove(curso);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizar(Curso entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Curso curso = entityManager.find(Curso.class, entidad.getId());
        if (curso != null) {
            curso.setNombre(entidad.getNombre());
            curso.setGrupos(entidad.getGrupos());
            curso.setUnidades(entidad.getUnidades());
            entityManager.merge(curso);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Curso buscarPorId(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Curso curso = entityManager.find(Curso.class, id);
        entityManager.getTransaction().commit();
        return curso;
    }

    @Override
    public ArrayList<Curso> buscarTodas() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Curso.class));
        Query query = entityManager.createQuery(criteria);
        List<Curso> curso = query.getResultList();
        entityManager.getTransaction().commit();
        return new ArrayList<>(curso);
    }
    
    public List<Curso> consultarCursos(String nombre, long id){
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        
        List<Curso> cursos;
         if (!nombre.equals("")) {
            String jpql = "SELECT * FROM dTKxX176tm.Curso WHERE dTKxX176tm.Curso.idMaestro ="+ id + " AND dTKxX176tm.Curso.nombre LIKE '"+"%"+nombre+"%"+"';";
            cursos = entityManager.createNativeQuery(jpql, Curso.class).getResultList();
        } else {
            String jpql = String.format("SELECT * FROM dTKxX176tm.Curso WHERE dTKxX176tm.Curso.idMaestro = %s;", id);
            cursos = entityManager.createNativeQuery(jpql, Curso.class).getResultList();
        }
        entityManager.getTransaction().commit();
        return cursos;
    }
    
}
