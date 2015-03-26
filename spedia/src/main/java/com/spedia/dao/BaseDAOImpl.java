package com.spedia.dao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import com.spedia.model.BaseDataObject;
import com.spedia.model.GenericObject;



/**
 * * Implements the generic CRUD data access operations using Java Persistence
 * APIs. <p> To write a DAO, subclass and parameterize this class with your
 * entity. Of course, assuming that you have a traditional 1:1 appraoch for
 * Entity:DAO design. This is actually an implementation that uses some
 * extensions for Java Persistence from Hibernate .
 */


public abstract class BaseDAOImpl<T, ID extends Serializable> implements BaseDao<T, ID> {
	private static final Log logger = LogFactory.getLog(BaseDAOImpl.class);
	private Class<T> entityBeanType;
	
	@PersistenceContext
	private EntityManager em;
	
	public BaseDAOImpl(){
		this.entityBeanType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}


	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	public EntityManager getEntityManager() {
		if (em == null)
			throw new IllegalStateException("EntityManager has not been set on DAO before usage");
		return em;
	}

	public Class<T> getEntityBeanType() {
		return entityBeanType;
	}

	public T findById(ID id, boolean lock) {
		T entity;
		if (lock) {
			entity = getEntityManager().find(getEntityBeanType(), id);
			em.lock(entity, javax.persistence.LockModeType.WRITE);
		} else {
			entity = getEntityManager().find(getEntityBeanType(), id);
		}
		return entity;
	}
	
	public T findById(ID id) {
		return findById(id, false);
	}

	public List<T> findByIds(List<ID> ids) {
		List<T> list = new ArrayList<T>();
		for(ID id:ids){
			T t = findById(id);
			if(t != null){
				list.add(t);
			}
		}
		return list;
	}
	
	public List<T> findAll() {
		return getEntityManager().createQuery("from " + getEntityBeanType().getName()).getResultList();
	}


	
	public Collection<T> saveOrUpdateAll(Collection<T> entities){
		if(entities !=null && !entities.isEmpty()){
			System.out.println(entities.toString());			
			for (T t : entities) {
				t = persist(t);
			}
		}
		return entities;
	}
	@Transactional
	public T persist(T entity) {
		logger.debug("persist entity " + entity.toString());
		if(entity instanceof BaseDataObject){
			BaseDataObject baseObject = (BaseDataObject) entity;
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = "System";
			if (auth != null) {
				username = auth.getName();
			}
			try {
				if(baseObject.getId() == null){
					baseObject.setCreatedDate(new Date(System.currentTimeMillis()));
				}
				baseObject.setUpdatedDate(new Date(System.currentTimeMillis()));
				baseObject.setUpdatedBy(username);
			} catch (ParseException e1) {
				logger.error("Error in parseing date  " + e1.getMessage());
				e1.printStackTrace();
			}			
		}
		T e = getEntityManager().merge(entity);
		getEntityManager().persist(e);
		getEntityManager().flush();
		return e;
	}
	
	
	public T persistField(T entity) {
		logger.debug("persist entity " + entity.toString());
		T e = getEntityManager().merge(entity);
		getEntityManager().persist(e);
		getEntityManager().flush();
		return e;
	}

	public void makeTransient(T entity) {
		getEntityManager().remove(entity);
	}
	
	@Override
	public void delete(T entity, ID id) {
		getEntityManager().find(entityBeanType, id);
		getEntityManager().remove(entity);
	}

	public void flush() {
		getEntityManager().flush();
	}

	public void clear() {
		getEntityManager().clear();
	}

	@Override
	public List<T> getResult(String queryStr, Map<String, Object> param) {
		Query query = getEntityManager().createQuery(queryStr);
		for (Entry<String, Object> entry : param.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		List<T> list = query.getResultList();
		return list;
	}
}
