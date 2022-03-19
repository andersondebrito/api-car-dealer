package com.cardealer.service;

import com.cardealer.model.Listing;
import com.cardealer.model.State;

import java.util.List;

public interface ListingService {

    void create(Listing listing);
    Listing update(Listing listing);
    List<Listing> getAllListingOfDealer(Integer dealerId, State state);
    List<Listing> publishListing(Listing listing);
    void unPublishListing(Listing listing);

}
