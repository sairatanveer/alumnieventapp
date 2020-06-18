package com.saira.alumnieventapp.service;
import com.saira.alumnieventapp.entity.Event;
import com.saira.alumnieventapp.exception.EventException;
import com.saira.alumnieventapp.repository.EventRepository;
import com.saira.alumnieventapp.repository.ManagerRepository;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.util.List;
import java.util.Optional;
@Service
public class EventService {
    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    public EventRepository eventRepository;
    public List<Transaction> getAll(Long walletId)
    {
        Optional<Event> event = eventRepository.findById(eventId);
        if(event.isPresent()){
            return eventRepository.findByWallet(event.get());

        }
        return null;
    }
    public Manager getById(Long wallet_id,Long id) {
        Optional<Manager> wallet = eventRepository.findById(wallet_id);
        if (wallet.isPresent()) {
            Optional<Manager> transaction = eventRepository.findById(id);
            if (transaction.isPresent()) {
                return transaction.get();

            }
            throw new EventException("Transaction with " + id + "does not exists!");
        }
        return null;
    }

    public Transaction createOrUpdate(Long walletId, Transaction transaction) {
        Optional<Event> wallet = Repository.findById(walletId);
        if (wallet.isPresent()) {
            managerRepository.setEvent(wallet.get());
            managerRepository.save(transaction);
            return transaction;
        }
        return null;
    }
    public boolean delete(Long event_id,Long id)
    {
        Optional<Event> event = eventRepository.findById(event_id);
        if (event.isPresent()) {
            Optional<Transaction> transaction = managerRepository.findById(id);
            if (transaction.isPresent()) {
                managerRepository.delete(transaction.get());
                return true;
            }
        }
        throw  new EventException("Transaction with "+id+"does not exists!");
    }
}