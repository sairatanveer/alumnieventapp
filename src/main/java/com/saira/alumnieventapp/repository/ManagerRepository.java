package com.saira.alumnieventapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.events.Event;

import java.util.List;
public interface ManagerRepository extends JpaRepository<Event,Long> {
    List<Event> findAllByOrOrderByPriority();
}

