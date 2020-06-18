package com.saira.alumnieventapp.controller;

import com.saira.alumnieventapp.entity.Event;
import com.saira.alumnieventapp.service.EventService;
import com.saira.alumnieventapp.service.ManagerService;
import com.saira.alumnieventapp.service.ValidationErrorService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class EventManagerController {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private ValidationErrorService validationService;
    @GetMapping("/{wallet_id}")
    ResponseEntity<?> getAll(@PathVariable Long wallet_id)
    {
        return new ResponseEntity<>(EventService.getAll(event_id), HttpStatus.OK);
    }
    @GetMapping("/{wallet_id}/id")
    public ResponseEntity<?> getById(@PathVariable Long event_id,@PathVariable Long id)
    {
        return new ResponseEntity<>(EventService.getById(event_id,id),HttpStatus.OK);
    }
    @PostMapping("/{wallet_id}")
    public ResponseEntity<?> create(@PathVariable Long wallet_id, @Valid @RequestBody Manager manager, BindingResult result)
    {
        ResponseEntity errors= validationService.vsalidate(result);
        if(errors !=null) return errors;
        Event eventSaved = managerService.createOrUpdate(event_id,manager);
        return new ResponseEntity<Manager>(manager,HttpStatus.CREATED);
    }
    @PutMapping("/{wallet_id}/{id}")
    public ResponseEntity<?> update(@PathVariable Long wallet_id,@PathVariable Long id, @Valid @RequestBody Manager manager, BindingResult result)
    {
        ResponseEntity errors= validationService.vsalidate(result);
        if(errors !=null) return errors;
        manager.setId(id);
        Manager transactionSaved = managerService.createOrUpdate(event_id,manager);
        return new ResponseEntity<Manager>(transactionSaved,HttpStatus.OK);
    }

    @DeleteMapping("/{wallet_id}/{id}")
    public ResponseEntity<?> delete(@PathVariable Long wallet_id,@PathVariable Long id)
    {
        managerService.delete(event_id,id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
