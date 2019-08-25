package com.jisiben.hrms.service.common;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Service<T extends PersistentRoot<T>> {

    Page<T> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize);

    Optional<T> findById(Long id);

    Optional<T> save(T t);

    Page<T> findAll(Pageable pageable);

    void delete(Long id);

}
