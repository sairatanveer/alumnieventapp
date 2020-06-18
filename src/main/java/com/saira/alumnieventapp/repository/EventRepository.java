package com.saira.alumnieventapp.repository;

import com.saira.alumnieventapp.entity.Event;
import org.apache.catalina.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transaction;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Manager,Long> {
    List<Transaction> findByWallet(Event event);
}
