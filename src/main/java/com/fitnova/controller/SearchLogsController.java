package com.fitnova.controller;

import com.fitnova.model.entity.SearchLog;
import com.fitnova.service.SearchLogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/search-logs")
public class SearchLogsController {
    @Autowired
    private SearchLogsService searchLogsService;

    // 获取指定用户的搜索日志
    @GetMapping("/user/{userId}")
    public List<SearchLog> getSearchLogsByUserId(@PathVariable Integer userId) {
        return searchLogsService.getSearchLogsByUserId(userId);
    }

    // 记录一次搜索日志
    @PostMapping
    public void logSearch(@RequestBody SearchLog searchLog) {
        searchLogsService.logSearch(searchLog);
    }
}

