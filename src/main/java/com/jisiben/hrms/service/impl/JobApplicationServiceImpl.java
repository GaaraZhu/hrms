package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.ApplicationReportDao;
import com.jisiben.hrms.domain.dao.JobApplicationDao;
import com.jisiben.hrms.domain.dao.UserDao;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.ApplicationReport;
import com.jisiben.hrms.domain.entity.JobApplication;
import com.jisiben.hrms.domain.entity.User;
import com.jisiben.hrms.domain.entity.common.ApplicationReportType;
import com.jisiben.hrms.domain.entity.common.JobApplicationStatus;
import com.jisiben.hrms.service.JobApplicationService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class JobApplicationServiceImpl extends AbstractService<JobApplication> implements JobApplicationService {
    @Autowired
    private JobApplicationDao dao;

    @Autowired
    private ApplicationReportDao reportDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Dao<JobApplication, Long> getDao() {
        return dao;
    }

    public JobApplicationDao getJobApplicationDao() {
        return dao;
    }

    public void setJobApplicationDao(JobApplicationDao dao) {
        this.dao = dao;
    }

    @Override
    public Page<JobApplication> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        String company = criteria.get("company").map(Object::toString).orElse(null);
        String city = criteria.get("city").map(Object::toString).orElse(null);
        String jobName = criteria.get("jobName").map(Object::toString).orElse(null);
        Boolean hasReferee = criteria.get("hasReferee").map(Boolean.class::cast).orElse(null);
        String candidate = criteria.get("candidate").map(Object::toString).orElse(null);
        String referee = criteria.get("referee").map(Object::toString).orElse(null);
        String statusString = criteria.get("status").map(Object::toString).orElse(null);
        JobApplicationStatus status = StringUtils.isEmpty(statusString)?null:JobApplicationStatus.valueOf(statusString);
        Date fromTime = criteria.get("fromTime").map(Date.class::cast).orElse(null);
        Date toTime = criteria.get("toTime").map(Date.class::cast).orElse(null);
        String createdBy = SecurityContextHolder.getContext().getAuthentication().getName();
        return dao.findJobApplications(company, city, jobName, hasReferee, candidate, referee, status, fromTime, toTime, createdBy, new PageRequest(currentPage - 1, pageSize));
    }

    @Override
    public Long findActiveJobApplicationCount(String candidateIdNumber, Long jobId) {
        return dao.countByCandidateIdNumber(candidateIdNumber, jobId);
    }

    @Override
    public void migrateJobApplications(Long originalUserId, Long targetUserId) {
        dao.migrateJobApplications(originalUserId, targetUserId);
    }

    @Override
    @Scheduled(cron = "0 0 2 * * Mon") // runs at 2:00 am every monday
    public void generateApplicationWeeklyReport() {
        Date firstDayOfTheWeek = Date.from(LocalDate.now().with(DayOfWeek.MONDAY).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date firstDayOfNextWeek = Date.from(LocalDate.now().plusWeeks(1).with(DayOfWeek.MONDAY).atStartOfDay(ZoneId.systemDefault()).toInstant());
        generateReport(firstDayOfTheWeek, firstDayOfNextWeek, ApplicationReportType.WEEKLY);
    }

    @Override
    @Scheduled(cron = "0 0 2 1 * ?") // runs at 2:00 am 1st day of every month
    public void generateApplicationMonthlyReport() {
        Date firstDayOfTheMonth = Date.from(LocalDate.now().withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date firstDayOfNextMonth = Date.from(LocalDate.now().plusMonths(1).withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        generateReport(firstDayOfTheMonth, firstDayOfNextMonth, ApplicationReportType.MONTHLY);
    }

    private void generateReport(Date start, Date end, ApplicationReportType type) {
        Date firstDayOfTheMonth = Date.from(LocalDate.now().withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date firstDayOfNextMonth = Date.from(LocalDate.now().plusMonths(1).withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());

        Map<User, Long> newAppliedResult = dao.findNewlyApplied(firstDayOfTheMonth, firstDayOfNextMonth).stream()
                .collect(Collectors.groupingBy(JobApplication::getCreator, Collectors.counting()));
        Map<User, Long> newInterviewedResult = dao.findNewlyInterviewed(firstDayOfTheMonth, firstDayOfNextMonth).stream()
                .collect(Collectors.groupingBy(JobApplication::getCreator, Collectors.counting()));
        Map<User, Long> newOnboardedResult = dao.findNewlyOnboarded(firstDayOfTheMonth, firstDayOfNextMonth).stream()
                .collect(Collectors.groupingBy(JobApplication::getCreator, Collectors.counting()));

        userDao.findAll().forEach(user->{
            Long newApplied = newAppliedResult.keySet().contains(user)?newAppliedResult.get(user):0L;
            Long newInterviewed = newInterviewedResult.keySet().contains(user)?newInterviewedResult.get(user):0L;
            Long newOnboarded = newOnboardedResult.keySet().contains(user)?newOnboardedResult.get(user):0L;
            reportDao.save(
                    new ApplicationReport.Builder()
                            .type(type)
                            .start(start)
                            .end(end)
                            .newApplied(newApplied)
                            .newInterviewed(newInterviewed)
                            .newOnboarded(newOnboarded)
                            .build());
        });
    }
}