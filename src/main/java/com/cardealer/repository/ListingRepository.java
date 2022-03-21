package com.cardealer.repository;

import com.cardealer.model.Listing;
import com.cardealer.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Integer> {
    List<Listing> findByDealerIdAndState(Integer dealerId, State state);
}
