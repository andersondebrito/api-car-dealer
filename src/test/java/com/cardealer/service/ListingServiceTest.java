package com.cardealer.service;

import com.cardealer.exception.TierLimitException;
import com.cardealer.model.Dealer;
import com.cardealer.model.Listing;
import com.cardealer.model.State;
import org.jeasy.random.EasyRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListingServiceTest {

    @Mock
    private ListingServiceImpl listingService;

    EasyRandom generator = new EasyRandom();


    @Test
    public void testGetAllListingOfDealer() {
        List<Listing> list = generator.objects(Listing.class, 5)
                .collect(Collectors.toList());

        when(listingService.getAllListingOfDealer(1,State.DRAFT)).thenReturn(list);

        List<Listing> listingList = listingService.getAllListingOfDealer(1, State.DRAFT);
        assertEquals(5,listingList.size());
    }

    @Test
    public void verifyTieLimitTest(){
        List<Listing> list = generator.objects(Listing.class, 2)
                .collect(Collectors.toList());
        list.forEach(listing -> listing.setState(State.PUBLISHED));

        Dealer dealer = new Dealer();
        dealer.setId(1);
        dealer.setTierLimit(2);
        dealer.setNome("Test");

        assertTrue(list.size() <= dealer.getTierLimit());
    }

    @Test
    public void verifyTieLimitTestFail(){
        List<Listing> list = generator.objects(Listing.class, 3)
                .collect(Collectors.toList());
        list.forEach(listing -> listing.setState(State.PUBLISHED));

        Dealer dealer = new Dealer();
        dealer.setId(1);
        dealer.setTierLimit(2);
        dealer.setNome("Test");

        assertFalse(list.size() <= dealer.getTierLimit());
    }

    @Test(expected = TierLimitException.class)
    public void testTierLimitException() {

        List<Listing> list = generator.objects(Listing.class, 3)
                .collect(Collectors.toList());
        list.forEach(listing -> listing.setState(State.PUBLISHED));

        Dealer dealer = new Dealer();
        dealer.setId(1);
        dealer.setTierLimit(2);
        dealer.setNome("Test");
        dealer.setListings(list);

        doThrow(new TierLimitException("test")).when(listingService).verifyTieLimit(dealer.getId());

        listingService.verifyTieLimit(dealer.getId());
    }

}
