package com.cybershop.daosImpl;

import com.cybershop.models.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.cybershop.daos.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Product obj) {
        em.persist(obj);
    }

    @Override
    public void update(Product obj) {
        em.merge(obj);
    }

    @Override
    public void delete(int id) {
        em.remove(getById(id));
    }

    @Override
    public List<Product> getAll() {
        return em.createQuery("from Product").getResultList();
    }

    @Override
    public Product getById(int id) {
        return em.find(Product.class, id);
    }

}
