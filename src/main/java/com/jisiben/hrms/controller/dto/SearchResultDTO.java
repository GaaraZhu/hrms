package com.jisiben.hrms.controller.dto;

import java.util.List;

public class SearchResultDTO<T> {
    private List<T> results;

    protected SearchResultDTO(Builder builder) {
        this.results = builder.results;
    }

    public List<T> getResults() {
        return results;
    }

    public static class Builder<T, D extends SearchResultDTO.Builder> {
        private List<T> results;

        public D results(List<T> results) {
            this.results = results;
            return (D)this;
        }

        public SearchResultDTO build() { return new SearchResultDTO(this); }
    }
}
