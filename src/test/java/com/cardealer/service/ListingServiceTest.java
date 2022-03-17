package com.cardealer.service;

import com.cardealer.repository.DealerRepository;
import com.cardealer.repository.ListingRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ListingServiceTest {

    @Mock
    private DealerRepository dealerRepository;

    @Mock
    private ListingRepository listingRepository;

    @InjectMocks
    ListingService listingService;



    @Before
    void init() {
        MockitoAnnotations.initMocks(this);
        listingService = new ListingServiceImpl(dealerRepository,listingRepository);

    }

    @Test
    void testGetAllListingOfDealer() {

    }

    @Test
    void createTest() {

    }

    @Test
    void updateTest(){

    }

    @Test
    void publishListingTest(){

    }

    @Test
    void unPublishListingTest() {
        
    }
}
