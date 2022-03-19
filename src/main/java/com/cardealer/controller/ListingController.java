package com.cardealer.controller;

import com.cardealer.model.Listing;
import com.cardealer.model.State;
import com.cardealer.service.ListingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/listing")
public class ListingController {

    private ListingService service;

    ListingController(ListingService listingService){
        this.service = listingService;
    }

    @PostMapping
    public ResponseEntity createListing(@RequestBody Listing listing){
        return new ResponseEntity<>("Listing created", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateListing(@RequestBody Listing listing, @PathVariable Long id){
        return new ResponseEntity<>("Listing updated", HttpStatus.OK);
    }

    @GetMapping("/{dealerId}/{state}")
    public ResponseEntity getAllListingOfDealerWhitState(@PathVariable Integer dealerId, @PathVariable State state){
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PatchMapping("/publish")
    public ResponseEntity publishListing(){
        return new ResponseEntity<>("published", HttpStatus.OK);
    }

    @PatchMapping("/unPublish")
    public ResponseEntity unPublishListing(Listing listing) {
        return new ResponseEntity<>("unpublished", HttpStatus.OK);
    }

}
