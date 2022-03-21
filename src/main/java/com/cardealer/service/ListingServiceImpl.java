package com.cardealer.service;

import com.cardealer.exception.DealerNotFoundException;
import com.cardealer.exception.TierLimitException;
import com.cardealer.model.Dealer;
import com.cardealer.model.Listing;
import com.cardealer.model.State;
import com.cardealer.repository.DealerRepository;
import com.cardealer.repository.ListingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListingServiceImpl implements ListingService{

    Logger logger = LoggerFactory.getLogger(ListingServiceImpl.class);

    private DealerRepository dealerRepository;
    private ListingRepository listingRepository;

    public ListingServiceImpl(DealerRepository dealerRepository, ListingRepository listingRepository) {
        this.dealerRepository = dealerRepository;
        this.listingRepository = listingRepository;
    }

    @Override
    public Dealer create(Dealer dealer) {
        try {
            return dealerRepository.save(dealer);
        } catch (Exception e) {
            logger.error("Dealer not created " + e);
            throw new DealerNotFoundException("Dealer not created " + dealer);
        }
    }

    @Override
    public Listing update(Listing listing) {
        try {
            verifyTieLimit(listing.getDealer().getId());
            return listingRepository.save(listing);
        } catch (DataIntegrityViolationException e) {
            logger.error("Dealer id does not exist " + e);
            throw new DealerNotFoundException("Dealer id: " + listing.getDealer().getId() + " does not exist ");
        } catch (TierLimitException e) {
            logger.error("Dealer does not updated  " + e);
            throw new DealerNotFoundException(e.getMessage());
        } catch (Exception e) {
            logger.error("Dealer does not updated  " + e);
            throw new DealerNotFoundException("Dealer does not updated ");
        }
    }

    /**
     * Get all listings of a dealer with a given state
     * @param dealerId
     * @param state
     * @return
     */
    @Override
    public List<Listing> getAllListingOfDealer(Integer dealerId, State state) {
        return listingRepository.findByDealerIdAndState(dealerId,state);
    }

    @Override
    public Listing getListing(Integer id) {
        try {
            return listingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        } catch (EntityNotFoundException e) {
            logger.error("Listing not found for id: " + id + " " + e);
            throw new DealerNotFoundException("Listing not found for id: " + id);
        } catch (Exception e) {
            logger.error("Listing not found for id: " + id + " " + e);
            throw new DealerNotFoundException("Listing not found for id: " + id);
        }
    }

    /**
     * Change the status for this list to PUBLISHED
     * @param idListing
     * @return Listing
     */
    @Override
    public Listing publish(Integer idListing) {
        Listing listing = this.getListing(idListing);
        listing.setState(State.PUBLISHED);
        this.update(listing);
        return listing;
    }

    /**
     * Change the status for this list to DRAFT, this list will not be available
     * @param idListing
     * @return Listing
     */
    @Override
    public Listing unPublish(Integer idListing) {
        Listing listing = this.getListing(idListing);
        listing.setState(State.DRAFT);
        this.updatePublish(listing);
        return listing;
    }

    private  void updatePublish(Listing listing) {
        listingRepository.save(listing);
    }

    /**
     * Verify the number of published listings for a dealer is less or equal to the dealer's tier limit.
     */
    protected void verifyTieLimit(Integer dealerId){
        Dealer dealer = dealerRepository.getById(dealerId);
        List<Listing> list = dealer.getListings()
                .stream()
                .filter(listing -> listing.getState() == State.PUBLISHED)
                .collect(Collectors.toList());

        if(list.size() > dealer.getTierLimit()){
                throw new TierLimitException("Dealer " +dealer.getNome()+
                        " should be less or equal to the dealer's tier limit. " +
                        "Your tier limit is " + dealer.getTierLimit() +
                        " You need to increase the tier limit");
        }

    }
}
