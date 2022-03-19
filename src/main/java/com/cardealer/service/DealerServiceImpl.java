package com.cardealer.service;

import com.cardealer.model.Dealer;
import com.cardealer.repository.DealerRepository;

public class DealerServiceImpl implements DealerService{

    private DealerRepository repository;

    DealerServiceImpl(DealerRepository dealerRepository){
        this.repository = dealerRepository;
    }

    @Override
    public void create(Dealer dealer) {
        repository.save(dealer);
    }

    @Override
    public void delete(Dealer dealer) {
        repository.delete(dealer);
    }
}
