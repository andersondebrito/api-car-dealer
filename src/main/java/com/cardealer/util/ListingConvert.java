package com.cardealer.util;

import com.cardealer.dto.ListingDTO;
import com.cardealer.model.Listing;
import org.modelmapper.ModelMapper;

public class ListingConvert {

    public static ListingDTO convertToDto(Listing listing, ModelMapper modelMapper) {
        ListingDTO listingDTO = modelMapper.map(listing, ListingDTO.class);
        return listingDTO;
    }

    public static Listing convertDtoToEntity(ListingDTO listingDto, ModelMapper modelMapper) {
        Listing listing = modelMapper.map(listingDto, Listing.class);
        return listing;
    }
}
