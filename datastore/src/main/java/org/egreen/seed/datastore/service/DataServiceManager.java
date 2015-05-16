package org.egreen.seed.datastore.service;

import javax.jdo.PersistenceManager;
import java.util.List;

/**
 * Created by dewmal on 5/12/15.
 */
public interface DataServiceManager<T, I> {


    /**
     *
     * @return
     */
    PersistenceManager getPm();

    /* Create Entity in db
    *
            * @param entity
    * @return
            */
    I create(T entity);

    /**
     * Update entity
     *
     * @param entity
     * @return
     */
    I update(T entity);

    /**
     * Delete Entity from db
     *
     * @param entity
     * @return
     */
    int delete(T entity);

    /**
     * @param id
     * @return
     */
    T read(I id);

    /**
     * Get all by offset limit order by giventype
     *
     * @return
     */
    List<T> getAll(int offset, int limit, String order);

    /**
     * Get List By Id
     *
     * @return
     */
    List<T> getAllListById(Long id, String propertyName);


    /**
     * getAllByPropertyByIntegerValue
     *
     * @param value
     * @param propertyName
     * @return
     */
    List<T> getAllByPropertyByIntegerValue(Integer value, String propertyName);

    /**
     * getAllByPropertyByStringValue
     *
     * @param value
     * @param propertyName
     * @return
     */
    List<T> getAllByPropertyByStringValue(String value, String propertyName);

    /**
     * to Delete
     *
     * @param entity
     */
    void detach(Object entity);

    /**
     *
     * @return
     */
    Long getAllCount();

    /**
     *
     * @return
     */
    List<T> getAll();
}
