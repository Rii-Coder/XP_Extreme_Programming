/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author R2
 */
public abstract class BaseDAO<T> {
    
    public abstract void agregar(T entidad);
    
    public abstract void eliminar(Long id);
    
    public abstract void actualizar(T entidad);
    
    public abstract T buscarPorId(long id);
    
    public abstract ArrayList<T> buscarTodas();
    
    public EntityManager createEntityManager() {
        EntityManagerFactory emFactory
                = Persistence.createEntityManagerFactory("xp_PU");
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
}
