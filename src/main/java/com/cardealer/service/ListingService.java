package com.cardealer.service;

import com.cardealer.model.Dealer;
import com.cardealer.model.Listing;
import com.cardealer.model.State;

import java.util.List;

public interface ListingService {

    Dealer create(Dealer dealer);
    Listing update(Listing listing);
    List<Listing> getAllListingOfDealer(Integer dealerId, State state);
    Listing getListing(Integer id);
    Listing publish(Integer idListing);
    Listing unPublish(Integer idListing);

}
