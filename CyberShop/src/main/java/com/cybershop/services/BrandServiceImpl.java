/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybershop.services;

import com.cybershop.interfacedao.ServiceBasic;
import com.cybershop.daos.BrandDAO;
import com.cybershop.models.Brand;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ngthe
 */
@Service
public class BrandServiceImpl implements ServiceBasic<Brand>{
    
    @Autowired
    private BrandDAO dao;

    @Transactional
    @Override
    public void save(Brand obj) {
        dao.create(obj);
    }

    @Transactional
    @Override
    public void remove(int id) {
        dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Brand findById(int id) {
        return dao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Brand> getByAll() {
        return dao.getAll();
    }
    
}
