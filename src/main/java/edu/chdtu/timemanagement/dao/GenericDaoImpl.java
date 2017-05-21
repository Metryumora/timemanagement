package edu.chdtu.timemanagement.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
@Repository
public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {

    private Class<E> persistentClass;


    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        this.persistentClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    public List<E> findAll() {
        return entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
    }

    private Session currentSession() {
        return entityManager.unwrap(Session.class);
    }

    public Class<? extends E> getDaoType() {
        return persistentClass;
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
        return currentSession().get(persistentClass, key);
    }
}