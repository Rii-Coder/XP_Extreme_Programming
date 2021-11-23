/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Maestro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;


/**
 *
 * @author R2
 */
public class MaestroDAO extends BaseDAO<Maestro> {

    @Override
    public void agregar(Maestro entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entidad);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(Long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Maestro usuario = entityManager.find(Maestro.class, id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public void actualizar(Maestro entidad) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Maestro maestro = entityManager.find(Maestro.class, entidad.getId());
        if (maestro != null) {
            maestro.setCorreo(entidad.getCorreo());
            maestro.setNombre(entidad.getNombre());
            maestro.setContraseña(entidad.getContraseña());
            maestro.setCurso(entidad.getCurso());
            entityManager.merge(maestro);
        }
        entityManager.getTransaction().commit();
    }

    @Override
    public Maestro buscarPorId(long id) {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        Maestro maestro = entityManager.find(Maestro.class, id);
        entityManager.getTransaction().commit();
        return maestro;
    }

    @Override
    public ArrayList<Maestro> buscarTodas() {
        EntityManager entityManager = this.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        criteria.select(criteria.from(Maestro.class));
        Query query = entityManager.createQuery(criteria);
        List<Maestro> maestro = query.getResultList();
        entityManager.getTransaction().commit();
        return new ArrayList<>(maestro);
    }

    public Maestro iniciarSesion(Maestro maestro) {

        if (maestro != null) {
            EntityManager entityManager = this.createEntityManager();
            entityManager.getTransaction().begin();

            if (!maestro.getCorreo().equals("") && !maestro.getContraseña().equals("")) {
                String jpql = String.format("SELECT * FROM dTKxX176tm.Maestro WHERE dTKxX176tm.Maestro.CorreoElectronico = '%s' AND dTKxX176tm.Maestro.Contraseña = '%s';",
                        maestro.getCorreo(), maestro.getContraseña());
                maestro = (Maestro) entityManager.createNativeQuery(jpql, Maestro.class).getSingleResult();
            }
            try {
                entityManager.getTransaction().commit();
            } catch (Exception x) {
                System.out.println("Ningun maestro encontrado");
            }
            return maestro;
        }
        return null;
    }

    public boolean isMaestroRegistrado(String correo) {

        if (correo != "") {
            EntityManager entityManager = this.createEntityManager();
            entityManager.getTransaction().begin();

            String jpql = String.format("SELECT * FROM dTKxX176tm.Maestro WHERE dTKxX176tm.Maestro.CorreoElectronico = '%s';",
                    correo);
            List lista = entityManager.createNativeQuery(jpql, Maestro.class).getResultList();

            try {
                entityManager.getTransaction().commit();
            } catch (Exception x) {
                System.out.println("Ningun maestro encontrado");
            }
            if(lista.isEmpty()){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }

}
