package com.fitnova.service.impl;

import com.fitnova.mapper.SearchLogsMapper;
import com.fitnova.model.entity.SearchLog;
import com.fitnova.service.SearchLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchLogsServiceImpl implements SearchLogsService {
    @Autowired
    private SearchLogsMapper searchLogsMapper;

    @Override
    public List<SearchLog> getSearchLogsByUserId(Integer userId) {
        return searchLogsMapper.findByUserId(userId);
    }

    @Override
    public void logSearch(SearchLog searchLog) {
        searchLogsMapper.insert(searchLog);
    }
}

