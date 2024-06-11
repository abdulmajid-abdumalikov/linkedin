package org.example.repository;

import org.example.domain.model.BaseModel;
import org.example.utils.Util;

import java.sql.Connection;
import java.util.Optional;
import java.util.UUID;

public interface BaseRepository<T extends BaseModel> {
    Connection connection = Util.getConnection();

    String save(T t);
    String update(UUID id, T update);
    void delete(UUID id);

    Optional<T> findById(UUID id);
}
