package com.saira.alumnieventapp.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventManager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private Double amount;
    private String description;
    private int type;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "event_id",nullable = false)
    @JsonIgnore
    private Event wallet;

    @PrePersist
    public void setManagerDate(){ this.setManagerDate(); }

}
