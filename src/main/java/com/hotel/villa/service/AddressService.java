package com.hotel.villa.service;

import com.hotel.villa.entity.Address;

public interface AddressService {
    Address createAddress(Address address);
    Address editeAddressById(Long id,Address address);
    void deleteAddress(Long id);


}
