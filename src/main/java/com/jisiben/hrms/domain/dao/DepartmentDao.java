package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentDao extends Dao<Department, Long> {
    @Query("FROM Department c WHERE (:number is null or c.number = :number) and (:name is null"
            + " or c.name = :name)")
    Page<Department> findByNumberAndName(@Param("number")String number, @Param("name")String name, Pageable pageable);
}
