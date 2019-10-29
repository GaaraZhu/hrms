package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BranchDao extends Dao<Branch, Long> {
    @Query("FROM Branch c WHERE (:manager is null or c.manager = :manager) and (:name is null"
            + " or c.name = :name)")
    Page<Branch> findByManagerAndName(@Param("manager")String manager, @Param("name")String name, Pageable pageable);
}
