package com.cardealer.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    private Set<Listing> cars = new HashSet<>();
}
