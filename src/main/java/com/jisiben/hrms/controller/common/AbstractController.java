package com.jisiben.hrms.controller.common;

import com.google.common.collect.Streams;
import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
import com.jisiben.hrms.controller.dto.common.DTORoot;
import com.jisiben.hrms.controller.dto.mapper.common.Mapper;
import com.jisiben.hrms.domain.entity.common.PersistentRoot;
import com.jisiben.hrms.service.common.Service;
import org.springframework.data.domain.Page;

import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public abstract class AbstractController<T extends PersistentRoot<T>, D extends DTORoot<D>, U extends PersistentRoot.Builder<U, T>> {

    protected Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    protected PageableSearchResultDTO<D> doFindAll(Map<String, Optional<Object>> criteria, int currentPage, int pageSize){
        Page<T> es = getService()
                .search(criteria, currentPage, pageSize);
        return new PageableSearchResultDTO.Builder<D>()
                .totalElements(es.getTotalElements())
                .totalPages(es.getTotalPages())
                .results(
                        Streams.stream(es.iterator())
                                .map(getMapper()::toDTO)
                                .collect(Collectors.toList()))
                .build();
    }

    protected D doFind(Long id){
        return getService().findById(id)
                .map(getMapper()::toDTO).orElseThrow(
                        () -> new IllegalArgumentException(
                                String.format("Resource with Id %s doesn't exist", id)));
    }

    protected void doDelete(Long id){
        getService().delete(id);
    }

    protected void doUpdate(Long id, D dto){
        getService().findById(id)
                .ifPresent((T e)->
                        getService().save(getMapper().toEntity(dto, e)));
    }

    protected void doAdd(D dto){
        getService().save(
                getMapper().toEntity(dto, getEntityBuilder().build()));
    }

    protected abstract Service<T> getService();

    protected abstract Mapper<T, D> getMapper();

    protected abstract U getEntityBuilder();

}
