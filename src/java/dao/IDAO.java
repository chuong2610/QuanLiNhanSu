/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IDAO<T,K> {
    T insert(T entity);
    List<T> findAll();
    T findByID(K id);
    boolean update(T entity);
    boolean delete(K id);
  
    
}
