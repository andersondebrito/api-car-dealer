package com.cardealer.controller;

import com.cardealer.model.Dealer;
import com.cardealer.service.DealerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dealer")
public class DealerController {

    private DealerService service;

    DealerController(DealerService dealerService){
        this.service = dealerService;
    }

    @GetMapping
    public ResponseEntity getDealer(@PathVariable Long id){
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createDealer(@RequestBody Dealer dealer){
        return new ResponseEntity<>("Dealer created", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteDealer(@PathVariable Long id){
        return new ResponseEntity<>("Dealer deleted", HttpStatus.OK);
    }

}
