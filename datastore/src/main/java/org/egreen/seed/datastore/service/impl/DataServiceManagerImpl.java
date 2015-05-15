package org.egreen.seed.datastore.service.impl;


import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.egreen.seed.datastore.model.KeyInterface;
import org.egreen.seed.datastore.model.ModelInterface;
import org.egreen.seed.datastore.service.DataServiceManager;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import java.util.List;

/**
 * Created by dewmal on 5/12/15.
 */

//@Component(immediate = true)
public class DataServiceManagerImpl<T extends ModelInterface, I extends KeyInterface> implements DataServiceManager<T, I> {

    static {
        System.out.println("Working Model");
    }
//    @Reference
    private PersistenceManager pm;

    private final Class<T> modelClass;
    private final Class<I> keyClass;

    public DataServiceManagerImpl(Class<T> modelClass, Class<I> keyClass) {
        this.modelClass = modelClass;
        this.keyClass = keyClass;
    }


    @Override
    public PersistenceManager getPm() {
        return pm;
    }

    @Override
    public I create(T entity) {
        Transaction transaction = pm.currentTransaction();
        transaction.begin();
        pm.makePersistent(entity);
        transaction.commit();
        return (I) entity.getID();
    }

    @Override
    public I update(T entity) {
        Transaction transaction = pm.currentTransaction();
        transaction.begin();
        pm.makePersistent(entity);
        transaction.commit();
        return (I) entity.getID();
    }

    @Override
    public int delete(T entity) {
        return 0;
    }

    @Override
    public T read(I id) {
        return (T) pm.getObjectById(id);
    }

    @Override
    public List<T> getAll(int offset, int limit, String order) {
        Query query = pm.newQuery(modelClass);
        query.setRange(offset, limit);
        return (List<T>) query.execute();
    }

    @Override
    public List<T> getAllListById(Long id, String propertyName) {
        return null;
    }

    @Override
    public List<T> getAllByPropertyByIntegerValue(Integer value, String propertyName) {
        return null;
    }

    @Override
    public List<T> getAllByPropertyByStringValue(String value, String propertyName) {
        return null;
    }

    @Override
    public void detach(Object entity) {

    }

    @Override
    public Long getAllCount() {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }
}
