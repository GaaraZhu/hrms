package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.Candidate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidateDao extends Dao<Candidate, Long> {
    @Query("FROM Candidate c WHERE (:name is null or c.name = :name) and (:phone is null"
            + " or c.phone = :phone)")
    Page<Candidate> findByNameAndPhone(
            @Param("name")String name, @Param("phone")String phone, Pageable pageable);

    Candidate findByIdNumber(String idNumber);
}
