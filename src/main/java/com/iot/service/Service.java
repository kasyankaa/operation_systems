package com.iot.service;

import java.util.List;

public interface Service<E> {
    List<E> getAllObjects();

    E getObjectById(Integer id);

    E createObject(E object);

    E updateObject(Integer id, E object, E oldObject);

    boolean deleteObject(Integer id);
}
