package com.cardealer.service;

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
    public void create(Listing listing) {

    }

    @Override
    public Listing update(Listing listing) {
        return null;
    }

    @Override
    public List<Listing> getAllListingOfDealer(Integer dealerId, State state) {
        return null;
    }

    @Override
    public List<Listing> publishListing(Listing listing) {
        return null;
    }

    @Override
    public void unPublishListing(Listing listing) {

    }
}
