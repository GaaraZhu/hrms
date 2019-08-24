package com.jisiben.hrms.controller.dto.mapper.common;

import com.jisiben.hrms.controller.dto.common.DTORoot;
import com.jisiben.hrms.domain.entity.common.PersistentRoot;

public interface Mapper<T extends PersistentRoot, D extends DTORoot> {

    D toDTO(T entity);

    T toEntity(D dto, T entity);

}
