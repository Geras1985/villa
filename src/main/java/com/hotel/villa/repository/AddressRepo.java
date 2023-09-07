package com.hotel.villa.repository;

import com.hotel.villa.entity.Address;
import com.hotel.villa.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
    Address save(Long id);

    //Address findAddressName(String addressName);
}
