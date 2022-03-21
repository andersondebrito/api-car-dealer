package com.cardealer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dealer", nullable = false)
    private Integer id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tier_limit", nullable = false)
    private int tierLimit;

    @JsonBackReference
    @OneToMany(mappedBy = "dealer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Listing> listings;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> cars) {
        this.listings = cars;
    }
}
