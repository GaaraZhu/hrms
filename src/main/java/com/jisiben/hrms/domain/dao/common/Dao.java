package com.jisiben.hrms.domain.dao.common;

import com.jisiben.hrms.domain.entity.common.PersistentRoot;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface Dao<T extends PersistentRoot<T>, ID> extends
        PagingAndSortingRepository<T, Long> {
}
