package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BranchDao extends Dao<Branch, Long> {
    @Query("FROM Branch c WHERE (:company is null or c.company.name like CONCAT('%',:company,'%')) and (:branch is null"
            + " or c.name like CONCAT('%',:branch,'%'))")
    Page<Branch> findByManagerAndName(@Param("company")String company, @Param("branch")String branch, Pageable pageable);

}
