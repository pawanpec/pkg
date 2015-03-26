package com.spedia.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.spedia.model.GenericObject;




public interface BaseDao<T, ID extends Serializable> {

    /**
     * Find By Id
     * @param id
     * @param lock
     */
    T findById(ID id, boolean lock);
    /**
     * Find By Id
     * @param id
     */
    T findById(ID id);
    /**
     * Find All
     */
    List<T> findAll();
    /**
     * Makes transient
     * @param entity
     */
    void makeTransient(T entity);
    /**
     * Saves or Updates Collection
     * @param entities
     * @return
     */
    public Collection<T> saveOrUpdateAll(Collection<T> entities);
   
    /**
    * flush
    */
    void flush();
    /**
     * Immediately persist the entity
     * @param entity
     */
    public T persist(T entity);
    
    /**
     * persist field mainly for count purpose
     * @param entity
     * @return T
     */
    public T persistField(T entity);
    
    
    
    /**
     * Deletes entity
     * @param entity
     */
    void delete(T entity, ID id);
	/**
	 * get Result
	 * @param queryStr
	 * @param objectMap
	 * @return
	 */
	public List<T> getResult(String queryStr, Map<String, Object> objectMap);
	
	
}
