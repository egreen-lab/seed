package org.egreen.seed.datastore.service.impl;


import org.datanucleus.util.NucleusLogger;
import org.egreen.seed.datastore.model.ModelInterface;
import org.egreen.seed.datastore.service.DataServiceManager;
import org.egreen.seed.datastore.service.PersistanceManagerHolder;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;
import java.util.List;

/**
 * Created by dewmal on 5/12/15.
 */

//@Component(immediate = true)
public abstract class DataServiceManagerImpl<T extends ModelInterface, I> implements DataServiceManager<T, I> {

    static {
        System.out.println("Working Model");
    }


    protected PersistanceManagerHolder persistanceManagerHolder;

    private PersistenceManager persistenceManager;

    private final Class<T> modelClass;
    private final Class<I> keyClass;

    public DataServiceManagerImpl(Class<T> modelClass, Class<I> keyClass) {
        this.modelClass = modelClass;
        this.keyClass = keyClass;
    }


    @Override
    public PersistenceManager getPm() {

        if (persistenceManager == null) {
            persistenceManager = persistanceManagerHolder.getManagerFactory().getPersistenceManager();
        }

        return persistenceManager;


    }

    @Override
    public I create(T entity) {

        PersistenceManager pm = getPm();


        Transaction tx = pm.currentTransaction();
        try {
            tx.begin();

            pm.makeTransient(entity);
            pm.makePersistent(entity);

            tx.commit();
        } catch (Exception e) {
            NucleusLogger.GENERAL.info(">> Exception in query", e);
            e.printStackTrace();
        } finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }

        return (I) entity.getID();
//        return null;
    }

    @Override
    public I update(T entity) {
        Transaction transaction = getPm().currentTransaction();
        transaction.begin();
        getPm().makePersistent(entity);
        transaction.commit();
//        return (I) entity.getID();
        return null;
    }

    @Override
    public int delete(T entity) {
        return 0;
    }

    @Override
    public T read(I id) {
        return (T) getPm().getObjectById(id);
    }

    @Override
    public List<T> getAll(int offset, int limit, String order) {
        Query query = getPm().newQuery(modelClass);
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
