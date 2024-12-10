package com.fitnova.mapper;

import com.fitnova.model.entity.UserEvent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserEventsMapper {

    @Insert("INSERT INTO UserEvents (user_id, event_name, event_type, event_date) " +
            "VALUES (#{userId}, #{eventName}, #{eventType}, #{eventDate})")
    int addEvent(UserEvent event);

    @Select("SELECT * FROM UserEvents WHERE user_id = #{userId}")
    List<UserEvent> findEventsByUserId(Integer userId);

    @Update("UPDATE UserEvents SET event_name = #{eventName}, event_type = #{eventType}, event_date = #{eventDate} " +
            "WHERE event_id = #{eventId}")
    int updateEvent(UserEvent event);

    @Delete("DELETE FROM UserEvents WHERE event_id = #{eventId}")
    int deleteEvent(Integer eventId);
}
