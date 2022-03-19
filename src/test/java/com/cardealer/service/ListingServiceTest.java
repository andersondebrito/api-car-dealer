package com.cardealer.service;

import com.cardealer.model.Listing;
import com.cardealer.model.State;
import com.cardealer.repository.DealerRepository;
import com.cardealer.repository.ListingRepository;
import org.jeasy.random.EasyRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListingServiceTest {

    @Mock
    private DealerRepository dealerRepository;

    @Mock
    private ListingRepository listingRepository;

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
    public void createTest() {

    }

    @Test
    public void updateTest(){

    }

    @Test
    public void publishListingTest(){

    }

    @Test
    public void unPublishListingTest() {
        
    }
}
