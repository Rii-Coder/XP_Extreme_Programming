/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entities.Alumno;
import Entities.Alumno_has_grupo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Jbran
 */
public class AlumnoHasGrupoDAO extends BaseDAO<Alumno_has_grupo> {

    @Override
    public void agregar(Alumno_has_grupo entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(Long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Alumno_has_grupo alumno = entityManager.find(Alumno_has_grupo.class, id);
        if (alumno != null) {
            entityManager.remove(alumno);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizar(Alumno_has_grupo entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Alumno_has_grupo alumno = entityManager.find(Alumno_has_grupo.class, entidad.getId());
        if (alumno != null) {
            alumno.setAlumno(entidad.getAlumno());
            alumno.setAsistencia(true);
            alumno.setGrupo(entidad.getGrupo());
            alumno.setId(alumno.getId());
            entityManager.merge(alumno);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Alumno_has_grupo buscarPorId(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Alumno_has_grupo alumno = entityManager.find(Alumno_has_grupo.class, id);
        entityManager.getTransaction().commit();
        return alumno;
    }

    @Override
    public ArrayList<Alumno_has_grupo> buscarTodas() {
       EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Alumno_has_grupo.class));
        Query query = entityManager.createQuery(criteria);
        List<Alumno_has_grupo> alumno = query.getResultList();
        entityManager.getTransaction().commit();
        return new ArrayList<>(alumno);
    }
    
}
