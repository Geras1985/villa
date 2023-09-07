package com.hotel.villa.service;

import com.hotel.villa.entity.Hotel;
import com.hotel.villa.repository.HotelRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel editHotelById(Long id);
    void deleteHotel(Long id);

}
