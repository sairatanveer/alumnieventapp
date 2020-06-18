package com.saira.alumnieventapp.service;

import com.saira.alumnieventapp.entity.Event;
import com.saira.alumnieventapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    private EventRepository eventRepository;
    public List<Event> getAll()
    {
        return eventRepository.findAllByOrOrderByPriority();
    }
    public Event getById(Long id)
    { Optional<Event> event= eventRepository.findById(id);
        if(event.isPresent())
        {
            return event.get();

        }
        throw  new EventException("Wallet with "+id+"does not exists!");
    }

    public Event createOrUpdate(Event event) { if (event.getId() == null) {
        eventRepository.save(event);
    } else {
        eventRepository.save(event);
    }
        return event;
    }
    public boolean delete(Long id)
    {
        Optional<Event> event= eventRepository.findById(id);
        if(event.isPresent())
        {
            eventRepository.delete(event.get());
            return true;
        }
        throw  new EventException("Wallet with "+id+"does not exists!");
    }
}

