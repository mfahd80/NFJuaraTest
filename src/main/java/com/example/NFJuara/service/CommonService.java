package com.example.NFJuara.service;

import java.util.List;

public interface CommonService<E, D, PK> {

    Long getNum();

    E save(D dto) throws Exception;

    D getById(PK pk) throws Exception;

    Boolean delete(PK PK) throws Exception;

    List<D> getAll() throws Exception;

}

