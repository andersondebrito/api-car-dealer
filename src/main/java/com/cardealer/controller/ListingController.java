package com.cardealer.controller;

import com.cardealer.dto.DealerDTO;
import com.cardealer.dto.ListingDTO;
import com.cardealer.model.Dealer;
import com.cardealer.model.Listing;
import com.cardealer.model.State;
import com.cardealer.service.ListingService;
import com.cardealer.util.DealearConvert;
import com.cardealer.util.ListingConvert;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/listing")
public class ListingController {

    Logger logger = LoggerFactory.getLogger(ListingController.class);

    @Autowired
    private ModelMapper modelMapper;

    private ListingService service;

    ListingController(ListingService listingService){
        this.service = listingService;
    }

    @PostMapping
    public ResponseEntity<?> createListing(@RequestBody DealerDTO dealerDTO){
        Dealer dealer = service.create(DealearConvert.convertDtoToEntity(dealerDTO,modelMapper));
        return new ResponseEntity<>(DealearConvert.convertToDto(dealer,modelMapper), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateListing(@RequestBody ListingDTO listingDTO){
        Listing listing = service.update(ListingConvert.convertDtoToEntity(listingDTO,modelMapper));
        return new ResponseEntity<>(ListingConvert.convertToDto(listing,modelMapper), HttpStatus.OK);
    }

    @GetMapping("/{dealerId}/{state}")
    public ResponseEntity<?> getAllListingOfDealerWhitState(@PathVariable Integer dealerId, @PathVariable State state){
        List<Listing> listings = service.getAllListingOfDealer(dealerId, state);
        List<ListingDTO> listDTO = listings.stream()
                                    .map(listing -> ListingConvert.convertToDto(listing,modelMapper))
                                    .collect(Collectors.toList());
        return new ResponseEntity<>(listDTO, HttpStatus.OK);
    }

    @PatchMapping("/publish")
    public ResponseEntity<?> publishListing(@RequestBody Integer idListing){
        return new ResponseEntity<>(ListingConvert.convertToDto(service.publish(idListing),modelMapper), HttpStatus.OK);
    }

    @PatchMapping("/unPublish")
    public ResponseEntity<?> unPublishListing(@RequestBody Integer idListing) {
        return new ResponseEntity<>(ListingConvert.convertToDto(service.unPublish(idListing),modelMapper), HttpStatus.OK);
    }

}
