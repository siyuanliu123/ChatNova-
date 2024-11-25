package com.fitnova.service;

import com.fitnova.model.entity.SearchLog;

import java.util.List;

public interface SearchLogsService {
    List<SearchLog> getSearchLogsByUserId(Integer userId);
    void logSearch(SearchLog searchLog);
}

