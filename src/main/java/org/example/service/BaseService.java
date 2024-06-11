package org.example.service;

import org.example.domain.model.BaseModel;

import java.util.UUID;

public interface BaseService<T extends BaseModel> {

    String save(T t);
    String update(UUID id, T update);
    void delete(UUID id);

    T findById(UUID id);

}
