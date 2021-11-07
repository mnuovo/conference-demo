package com.pluralsight.conferencedemo.mapping;

import com.pluralsight.conferencedemo.dao.SessionDTO;
import com.pluralsight.conferencedemo.models.Session;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring")
public interface SessionMapper {
    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    SessionDTO sessionToSessionDto(Session session);
    Session sessionDtoToSession(SessionDTO sessionDTO);
}
