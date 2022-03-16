package com.cardealer.service;

import com.cardealer.model.Dealer;
import com.cardealer.model.Listing;
import com.cardealer.model.State;

import java.util.List;

public interface ListingService {

    public void create(Dealer dealer);
    public Listing update(Dealer dealer);
    public List<Listing> getAllListingOfDealer(Integer dealerId, State state);
    public List<Listing> publishListing(Dealer dealer);
    public void unPublishListing(Dealer dealer);

}
