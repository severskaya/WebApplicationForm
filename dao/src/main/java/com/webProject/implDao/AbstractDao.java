package com.webProject.implDao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Северская on 10.08.2016.
 */
@Component
@Transactional
public abstract class AbstractDao<T, PK extends Serializable> {

    @Autowired
    protected SessionFactory sessionFactory;

    public T findById(PK id, Class<T> entityClass) {
        Query query = getSession().createQuery("select t from " + entityClass.getSimpleName() + " t where t.id like :id").setParameter("id", id);
        return (T) query.uniqueResult();
    }


    public List<T> findAll(Class<T> entityClass) {
        Query query = getSession().createQuery("select t from " + entityClass.getSimpleName() + " t");
        return query.list();
    }


    public PK save(T value) {
        return (PK) getSession().save(value);
    }

    public void update(T value) {
        getSession().update(value);
    }

    public void deleteAll(T... values) {
        for (T aValue : values) {
            getSession().delete(aValue);
        }
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
