package com.fitnova.mapper;

import com.fitnova.model.entity.SearchLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchLogsMapper {
    List<SearchLog> findByUserId(Integer userId);
    void insert(SearchLog searchLog);
}

