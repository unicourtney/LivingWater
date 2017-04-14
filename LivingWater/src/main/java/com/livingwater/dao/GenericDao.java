package com.livingwater.dao;

/**
 * Created by John Leeroy Gadiane on 14/04/2017.
 */
public interface GenericDao<T> {
    public boolean create(T data);

    public T show(int id);

    public boolean update(T data);

    public boolean delete(T data);
}
