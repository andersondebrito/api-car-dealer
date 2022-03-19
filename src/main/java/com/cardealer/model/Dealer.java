package com.cardealer.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_dealer", nullable = false)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tier_limit", nullable = false)
    private int tierLimit;

    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    private Set<Listing> cars = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTierLimit() {
        return tierLimit;
    }

    public void setTierLimit(int tierLimit) {
        this.tierLimit = tierLimit;
    }

    public Set<Listing> getCars() {
        return cars;
    }

    public void setCars(Set<Listing> cars) {
        this.cars = cars;
    }
}
