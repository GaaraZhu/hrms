package com.jisiben.hrms.service.common.impl;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.common.PersistentRoot;
import com.jisiben.hrms.service.common.Service;
import com.jisiben.hrms.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

public abstract class AbstractService<T extends PersistentRoot<T>> implements
        Service<T> {

    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    public Optional<T> findById(Long id) { return Optional.ofNullable(getDao().findOne(id)); }

    public Optional<T> save(T t) {
        return Optional.ofNullable(getDao().save(t));
    }

    public Page<T> findAll(Pageable pageable) { return getDao().findAll(pageable); }

    public abstract Dao<T, Long> getDao();

    public void delete(Long id) { getDao().delete(id); }

}
