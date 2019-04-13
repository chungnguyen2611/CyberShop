
package com.cybershop.daos;

import com.cybershop.models.Brand;
import com.cybershop.interfacedao.InterfaceBasicDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class BrandDAO implements InterfaceBasicDAO<Brand>{

    @PersistenceContext
    private EntityManager em;
    @Override
    public void create(Brand obj) {
        em.persist(obj);
    }

    @Override
    public void update(Brand obj) {
        em.merge(obj);
    }

    @Override
    public void delete(int id) {
        em.remove(getById(id));
    }

    @Override
    public List<Brand> getAll() {
        return em.createQuery("from Brand").getResultList();
    }

    @Override
    public Brand getById(int id) {
        return em.find(Brand.class, id);
    }
    
    
    
    
}
