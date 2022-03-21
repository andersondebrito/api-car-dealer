package com.cardealer.util;

import com.cardealer.dto.DealerDTO;
import com.cardealer.model.Dealer;
import org.modelmapper.ModelMapper;

import java.util.stream.Collectors;

public class DealearConvert {

    public static DealerDTO convertToDto(Dealer dealer, ModelMapper modelMapper) {
        DealerDTO dealerDTO = modelMapper.map(dealer, DealerDTO.class);
        dealerDTO.setListing(dealer.getListings()
                .stream()
                .map(listing -> ListingConvert.convertToDto(listing, modelMapper))
                .collect(Collectors.toList()));

        return dealerDTO;
    }

    public static Dealer convertDtoToEntity(DealerDTO dealerDto, ModelMapper modelMapper) {
        Dealer dealer = modelMapper.map(dealerDto, Dealer.class);
        dealer.setListings(dealerDto.getListing()
                .stream()
                .map(listingDTO -> ListingConvert.convertDtoToEntity(listingDTO,modelMapper))
                .collect(Collectors.toList()));

        return dealer;
    }

}
