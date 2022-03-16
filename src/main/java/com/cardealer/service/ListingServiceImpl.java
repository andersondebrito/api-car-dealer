package com.cardealer.service;

import com.cardealer.model.Dealer;
import com.cardealer.model.Listing;
import com.cardealer.model.State;
import com.cardealer.repository.DealerRepository;
import com.cardealer.repository.ListingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingServiceImpl implements ListingService{

    private DealerRepository dealerRepository;
    private ListingRepository listingRepository;

    public ListingServiceImpl(DealerRepository dealerRepository, ListingRepository listingRepository) {
        this.dealerRepository = dealerRepository;
        this.listingRepository = listingRepository;
    }

    @Override
    public void create(Dealer dealer) {

    }

    @Override
    public Listing update(Dealer dealer) {
        return null;
    }

    @Override
    public List<Listing> getAllListingOfDealer(Integer dealerId, State state) {
        return null;
    }

    @Override
    public List<Listing> publishListing(Dealer dealer) {
        return null;
    }

    @Override
    public void unPublishListing(Dealer dealer) {

    }
}
