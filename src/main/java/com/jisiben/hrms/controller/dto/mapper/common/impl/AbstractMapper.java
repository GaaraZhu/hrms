package com.jisiben.hrms.controller.dto.mapper.common.impl;

import com.jisiben.hrms.controller.dto.common.DTORoot;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.common.PersistentRoot;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public abstract class AbstractMapper<T extends PersistentRoot, D extends DTORoot> implements Mapper<T, D> {
    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());
    protected SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");

    protected D.Builder entityToDTO(T entity, D.Builder builder) {
        return builder.id(entity.getId())
                .creator(entity.getCreator())
                .createdTime(sm.format(entity.getCreatedTime()))
                .updater(entity.getLastUpdater())
                .updatedTime(sm.format(entity.getLastUpdatedTime()));
    }

}
