package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.controller.dto.common.DTORoot;

public class PageableSearchResultDTO<T extends DTORoot> extends SearchResultDTO<T>{
    private int totalPages;
    private long totalElements;

    private PageableSearchResultDTO(Builder<T> builder) {
        super(builder);
        this.totalPages = builder.totalPages;
        this.totalElements = builder.totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public static class Builder<T extends DTORoot> extends SearchResultDTO.Builder<T, PageableSearchResultDTO.Builder>{
        private int totalPages;
        private long totalElements;

        public Builder<T> totalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public Builder<T> totalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public PageableSearchResultDTO build() { return new PageableSearchResultDTO(this); }
    }
}
