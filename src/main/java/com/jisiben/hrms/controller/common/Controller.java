//package com.jisiben.hrms.controller.common;
//
//import com.jisiben.hrms.controller.dto.PageableSearchResultDTO;
//import com.jisiben.hrms.controller.dto.common.DTORoot;
//import com.jisiben.hrms.domain.entity.common.PersistentRoot;
//import com.jisiben.hrms.service.common.Service;
//import org.springframework.data.domain.PageRequest;
//
//import java.util.List;
//
//public abstract class Controller<T extends PersistentRoot<T>, D extends DTORoot<D>> {
//
//    protected PageableSearchResultDTO<D> doFindAll(List<Object> criteria, PageRequest pageRequest){
//
//    }
//
//    protected D doFind(Long id){
//
//    }
//
//    protected void doDelete(Long id){
//        getService().delete(id);
//    }
//
//    protected void doUpdate(Long id, D dto){
//
//    }
//
//    protected void doAdd(D dto){
//
//    }
//
//    public abstract Service<T> getService();
//}
