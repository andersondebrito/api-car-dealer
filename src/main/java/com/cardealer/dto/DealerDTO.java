package com.cardealer.dto;

import java.util.ArrayList;
import java.util.List;

public class DealerDTO {

    private Integer id;
    private String nome;
    private int tierLimit;
    private List<ListingDTO> listing = new ArrayList<>();

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

    public List<ListingDTO> getListing() {
        return listing;
    }

    public void setListing(List<ListingDTO> listing) {
        this.listing = listing;
    }
}
