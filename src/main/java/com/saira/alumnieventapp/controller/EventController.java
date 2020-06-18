package com.saira.alumnieventapp.controller;


import com.saira.alumnieventapp.entity.Event;
import com.saira.alumnieventapp.service.EventService;
import com.saira.alumnieventapp.service.ValidationErrorService;
import com.saira.event_app.entity.Event;
import com.saira.event_app.service.EventService;
import com.saira.event_app.service.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
@CrossOrigin
public class EventController {
    @Autowired
    private EventService eventservice;

    @Autowired
    private ValidationErrorService validationService;

    @GetMapping ResponseEntity<?> getAll()
    {
        return new ResponseEntity<>(eventservice.getAll(),HttpStatus.OK);
    }
    @GetMapping("/id")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        return new ResponseEntity<>(eventservice.getById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody Event wallet, BindingResult result)
    {
        ResponseEntity errors= validationService.vsalidate(result);
        if(errors !=null) return errors;
        Event eventSaved = eventservice.createOrUpdate(event);
        return new ResponseEntity<Event>(eventSaved,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Validated @RequestBody Event event, BindingResult result)
    {
        ResponseEntity errors= validationService.vsalidate(result);
        if(errors !=null) return errors;
        event.setId(id);
        Event walletSaved = eventservice.createOrUpdate(event);
        return new ResponseEntity<Event>(eventsaved,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        eventservice.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}




