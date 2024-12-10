package com.fitnova.mapper;

import com.fitnova.model.entity.Income;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IncomeMapper {

    @Insert("INSERT INTO Income (coach_id, source, amount, created_at) " +
            "VALUES (#{coachId}, #{source}, #{amount}, NOW())")
    int addIncome(Income income);

    @Select("SELECT * FROM Income WHERE coach_id = #{coachId}")
    List<Income> findIncomeByCoachId(Integer coachId);
}
