package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.dao.SessionDTO;
import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {
    private final SessionRepository sessionRepository;

    public SessionController(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id){
        //Also need to check for children record before to delete
        sessionRepository.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public Session update(@PathVariable Long id, @RequestBody SessionDTO sessionDto){
        //because this is a PUT, we expect all attributes to be passed in
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Session existingSession = sessionRepository.getById(id);
        BeanUtils.copyProperties(sessionDto, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }
}
