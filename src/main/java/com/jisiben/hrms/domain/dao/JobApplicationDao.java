package com.jisiben.hrms.domain.dao;

import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.dao.bean.Pair;
import com.jisiben.hrms.domain.entity.JobApplication;
import com.jisiben.hrms.domain.entity.common.JobApplicationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface JobApplicationDao extends Dao<JobApplication, Long> {
    @Query("FROM JobApplication ja WHERE (:company is null or ja.job.company = :company) and (:city is null or ja.job.company.city = :city)"
            + "and (:jobName is null or ja.job.name like CONCAT('%',:jobName,'%')) and (:hasReferee is null or (:hasReferee=true and ja.referee is not null) or (:hasReferee=false and ja.referee is null))"
            + "and (:candidate is null or ja.candidate.name = :candidate or ja.candidate.phone = :candidate) and (:referee is null or ja.referee = :referee or ja.refereePhone = :referee) and (:status is null or ja.status = :status)"
            + "and (:createdBy = 'admin' or ja.creator = :createdBy) and (:fromTime is null or ja.applicationDate >= :fromTime) and (:toTime is null or ja.applicationDate <= :toTime) ORDER BY ja.id desc")
    Page<JobApplication> findJobApplications(
            @Param("company")String company,
            @Param("city")String city,
            @Param("jobName")String jobName,
            @Param("hasReferee")Boolean hasReferee,
            @Param("candidate")String candidate,
            @Param("referee")String referee,
            @Param("status") JobApplicationStatus status,
            @Param("fromTime") Date fromTime,
            @Param("toTime")Date toTime,
            @Param("createdBy")String createdBy,
            Pageable pageable);

    @Query("SELECT COUNT(ja) FROM JobApplication ja WHERE ja.candidate.idNumber = :candidateIdNumber and ja.job.id = :jobId and ja.status not in "
            +"(com.jisiben.hrms.domain.entity.common.JobApplicationStatus.FAILED, com.jisiben.hrms.domain.entity.common.JobApplicationStatus.INTERVIEW_FAILED, com.jisiben.hrms.domain.entity.common.JobApplicationStatus.RESIGNED)")
    Long countByCandidateIdNumber(@Param("candidateIdNumber")String candidateIdNumber, @Param("jobId")Long jobId);

    @Modifying
    @Query(value = "update jobApplication set creator = ?2 where creator = ?1", nativeQuery = true)
    void migrateJobApplications(String originalUserAccount, String targetUserAccount);

    @Query("FROM JobApplication ja WHERE ja.applicationDate >= :fromTime and ja.applicationDate < :toTime")
    List<JobApplication> findNewlyApplied(@Param("fromTime") Date fromTime, @Param("toTime")Date toTime);

    @Query("FROM JobApplication ja WHERE ja.interviewDate >= :fromTime and ja.interviewDate < :toTime")
    List<JobApplication> findNewlyInterviewed(@Param("fromTime") Date fromTime, @Param("toTime")Date toTime);

    @Query("FROM JobApplication ja WHERE ja.onboardDate >= :fromTime and ja.onboardDate < :toTime")
    List<JobApplication> findNewlyOnboarded(@Param("fromTime") Date fromTime, @Param("toTime")Date toTime);

    @Query("SELECT new com.jisiben.hrms.domain.dao.bean.Pair(ja.job.company.name, COUNT(ja)) FROM JobApplication ja WHERE ja.status in (com.jisiben.hrms.domain.entity.common.JobApplicationStatus.INTERVIEW_PASSED, com.jisiben.hrms.domain.entity.common.JobApplicationStatus.ON_BOARDED,"
        +" com.jisiben.hrms.domain.entity.common.JobApplicationStatus.ON_BOARDED_ONE_MONTH, com.jisiben.hrms.domain.entity.common.JobApplicationStatus.ON_BOARDED_THREE_MONTHS, com.jisiben.hrms.domain.entity.common.JobApplicationStatus.ON_BOARDED_SIX_MONTHS,"
        +" com.jisiben.hrms.domain.entity.common.JobApplicationStatus.RESIGNED) and (:fromTime is null or ja.applicationDate >= :fromTime) and (:toTime is null or ja.applicationDate <= :toTime) GROUP BY ja.job.company")
    List<Pair> findSuccessApplicantsByCompany(@Param("fromTime") Date fromTime, @Param("toTime")Date toTime);

    @Query("SELECT new com.jisiben.hrms.domain.dao.bean.Pair(ja.job.company.name, COUNT(ja)) FROM JobApplication ja WHERE SUBSTRING(ja.onboardDate, 1, 7) = :month and (:company is null or ja.job.company = :company)")
    List<Pair> findOnboardCountByCompany(@Param("company") String company, @Param("month") String month);

    @Query("SELECT new com.jisiben.hrms.domain.dao.bean.Pair(ja.job.company.name, COUNT(ja)) FROM JobApplication ja WHERE SUBSTRING(ja.resignDate, 1, 7) = :month and (:company is null or ja.job.company = :company)")
    List<Pair> findResignCountByCompany(@Param("company") String company, @Param("month") String month);

    @Query(value = "select DATE_FORMAT(ja.onboardDate, \"%Y-%m-%d\"), count(1) from jobApplication ja, job j, company c where c.name like CONCAT('%',?1,'%') and c.id=j.companyId and j.name like CONCAT('%',?2,'%') and j.id=ja.jobId and year(ja.onboardDate)=?3 and month(ja.onboardDate)=?4 group by DATE_FORMAT(ja.onboardDate, \"%Y-%m-%d\")", nativeQuery = true)
    List<Pair> countOnboards(String company, String jobName, String year, String month);

    @Query(value = "select DATE_FORMAT(ja.resignDate, \"%Y-%m-%d\"), count(1) from jobApplication ja, job j, company c where c.name like CONCAT('%',?1,'%') and c.id=j.companyId and j.name like CONCAT('%',?2,'%') and j.id=ja.jobId and year(ja.resignDate)=?3 and month(ja.resignDate)=?4 group by DATE_FORMAT(ja.resignDate, \"%Y-%m-%d\")", nativeQuery = true)
    List<Pair> countResigns(String company, String jobName, String year, String month);
}
