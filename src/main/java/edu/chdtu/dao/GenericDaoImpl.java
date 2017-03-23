package edu.chdtu.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Transactional
@Repository
public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {

    protected Class<? extends E> daoType;


    @PersistenceContext
    EntityManager entityManager;

    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session currentSession() {
        Session session = entityManager.unwrap(Session.class);
        return session;
    }

    public Class<? extends E> getDaoType() {
        return daoType;
    }

    public void setDaoType(Class<? extends E> daoType) {
        this.daoType = daoType;
    }


    public void add(E entity) {
        currentSession().save(entity);
    }


    public void saveOrUpdate(E entity) {
        currentSession().saveOrUpdate(entity);
    }


    public void update(E entity) {
        currentSession().saveOrUpdate(entity);
    }


    public void remove(E entity) {
        currentSession().delete(entity);
    }


    public E find(K key) {
        return (E) currentSession().get(daoType, key);
    }


    public List<E> getAll() {
        return currentSession().createCriteria(daoType).list();
    }
}