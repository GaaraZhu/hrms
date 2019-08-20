package com.jisiben.hrms.service.common;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface Service<T extends PersistentRoot> {

    Optional<T> findById(Long id);

    Optional<T> save(T t);

    Page<T> findAll(Pageable pageable);

    void delete(Long id);

}
