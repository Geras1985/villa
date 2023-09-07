package com.hotel.villa.service.impl;

import com.hotel.villa.entity.Hotel;
import com.hotel.villa.repository.HotelRepo;
import com.hotel.villa.service.HotelService;

public class HotelServiceImpl implements HotelService {

    private final HotelRepo hotelRepo;

    public HotelServiceImpl(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    /**
     * This method adds or creates a hotel.
     */
    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    /**
     * This method edit hotel by id.
     * */
    @Override
    public Hotel editHotelById(Long id) {
        Hotel hotel = hotelRepo.findById(id).orElse(null);

        return null;
    }

    /**
     * This method delete the hotel by id.
     * */
    @Override
    public void deleteHotel(Long id) {

    }
}