package com.fitnova.mapper;

import com.fitnova.model.entity.UserEvent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserEventsMapper {

    @Select("SELECT * FROM UserEvents")
    List<UserEvent> findAllEvents();

    @Select("SELECT * FROM UserEvents WHERE event_id = #{eventId}")
    UserEvent findEventById(@Param("eventId") Integer eventId);

    @Select("SELECT * FROM UserEvents WHERE created_by = #{createdBy}")
    List<UserEvent> findEventsByCreator(@Param("createdBy") Integer createdBy);

    @Insert("INSERT INTO UserEvents (title, description, location, date, time, created_by, is_reported) " +
            "VALUES (#{title}, #{description}, #{location}, #{date}, #{time}, #{createdBy}, #{isReported})")
    @Options(useGeneratedKeys = true, keyProperty = "eventId")
    int insertEvent(UserEvent userEvent);

    @Update("UPDATE UserEvents SET " +
            "title = #{title}, description = #{description}, location = #{location}, " +
            "date = #{date}, time = #{time}, is_reported = #{isReported} " +
            "WHERE event_id = #{eventId}")
    int updateEvent(UserEvent userEvent);

    @Delete("DELETE FROM UserEvents WHERE event_id = #{eventId}")
    int deleteEvent(@Param("eventId") Integer eventId);
}
