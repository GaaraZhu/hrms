package com.jisiben.hrms.service.impl;

import com.jisiben.hrms.domain.dao.PersonalReportDao;
import com.jisiben.hrms.domain.dao.JobApplicationDao;
import com.jisiben.hrms.domain.dao.UserDao;
import com.jisiben.hrms.domain.dao.bean.Pair;
import com.jisiben.hrms.domain.dao.common.Dao;
import com.jisiben.hrms.domain.entity.JobApplication;
import com.jisiben.hrms.domain.entity.PersonalReport;
import com.jisiben.hrms.domain.entity.common.PersonalReportType;
import com.jisiben.hrms.service.PersonalReportService;
import com.jisiben.hrms.service.common.impl.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonalReportServiceImpl extends AbstractService<PersonalReport> implements PersonalReportService {
    @Autowired
    private PersonalReportDao reportDao;

    @Autowired
    private JobApplicationDao applicationDao;

    @Autowired
    private UserDao userDao;

    @Override
    protected Dao<PersonalReport, Long> getDao() {
        return reportDao;
    }

    @Override
    public Page<PersonalReport> search(Map<String, Optional<Object>> criteria, int currentPage, int pageSize) {
        Date fromDate = criteria.get("fromDate").map(Date.class::cast).map(date-> DateUtils.truncate(date, Calendar.DATE)).orElse(null);
        Date toDate = criteria.get("toDate").map(Date.class::cast).map(date-> DateUtils.addDays(date, 1)).map(date-> DateUtils.truncate(date, Calendar.DATE)).orElse(null);
        String name = criteria.get("name").map(Object::toString).orElse(null);
        String typeString = criteria.get("type").map(Object::toString).orElse(null);
        PersonalReportType type = StringUtils.isEmpty(typeString)?null:PersonalReportType.valueOf(typeString);

        return reportDao.findJobApplicationReports(fromDate, toDate, name, type, new PageRequest(currentPage - 1, pageSize));
    }

    @Override
    @Scheduled(cron = "0 0 2 * * Mon") // runs at 2:00 am every monday
    public void generateApplicationWeeklyReport() {
        Date firstDayOfTheWeek = Date.from(LocalDate.now().with(DayOfWeek.MONDAY).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date firstDayOfNextWeek = Date.from(LocalDate.now().plusWeeks(1).with(DayOfWeek.MONDAY).atStartOfDay(ZoneId.systemDefault()).toInstant());
        generateReport(firstDayOfTheWeek, firstDayOfNextWeek, PersonalReportType.WEEKLY);
    }

    @Override
    @Scheduled(cron = "0 0 2 1 * ?") // runs at 2:00 am 1st day of every month
    public void generateApplicationMonthlyReport() {
        Date firstDayOfTheMonth = Date.from(LocalDate.now().withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date firstDayOfNextMonth = Date.from(LocalDate.now().plusMonths(1).withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        generateReport(firstDayOfTheMonth, firstDayOfNextMonth, PersonalReportType.MONTHLY);
    }

    private void generateReport(Date start, Date end, PersonalReportType type) {
        Date firstDayOfTheMonth = Date.from(LocalDate.now().withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date firstDayOfNextMonth = Date.from(LocalDate.now().plusMonths(1).withDayOfMonth(1).atStartOfDay(ZoneId.systemDefault()).toInstant());

        Map<String, Long> newAppliedResult = applicationDao.findNewlyApplied(firstDayOfTheMonth, firstDayOfNextMonth).stream()
                .collect(Collectors.groupingBy(JobApplication::getCreator, Collectors.counting()));
        Map<String, Long> newInterviewedResult = applicationDao.findNewlyInterviewed(firstDayOfTheMonth, firstDayOfNextMonth).stream()
                .collect(Collectors.groupingBy(JobApplication::getCreator, Collectors.counting()));
        Map<String, Long> newOnboardedResult = applicationDao.findNewlyOnboarded(firstDayOfTheMonth, firstDayOfNextMonth).stream()
                .collect(Collectors.groupingBy(JobApplication::getCreator, Collectors.counting()));

        userDao.findAll().forEach(user->{
            String account = user.getAccount();
            Long newApplied = newAppliedResult.keySet().contains(account)?newAppliedResult.get(account):0L;
            Long newInterviewed = newInterviewedResult.keySet().contains(account)?newInterviewedResult.get(account):0L;
            Long newOnboarded = newOnboardedResult.keySet().contains(account)?newOnboardedResult.get(account):0L;
            reportDao.save(
                    new PersonalReport.Builder()
                            .user(user)
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
