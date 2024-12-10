package com.fitnova.mapper;

import com.fitnova.model.entity.Coach;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CoachesMapper {

    @Insert("INSERT INTO Coaches (coach_id, verification_status, specialty, bio, rating) " +
            "VALUES (#{coachId}, #{verificationStatus}, #{specialty}, #{bio}, #{rating})")
    int registerCoach(Coach coach);

    @Select("SELECT * FROM Coaches WHERE coach_id = #{coachId}")
    Coach findCoachById(Integer coachId);

    @Update("UPDATE Coaches SET verification_status = #{verificationStatus}, specialty = #{specialty}, bio = #{bio}, rating = #{rating} " +
            "WHERE coach_id = #{coachId}")
    int updateCoach(Coach coach);
}
