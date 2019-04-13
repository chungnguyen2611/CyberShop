/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cybershop.services;

import java.util.List;

/**
 *
 * @author ngthe
 */
public interface ServiceBasic<T> {
     void save(T obj);
    void remove(int id);
    T getById(int id);
    List<T> getByAll();
   
}
