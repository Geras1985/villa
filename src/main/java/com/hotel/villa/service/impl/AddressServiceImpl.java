package com.hotel.villa.service.impl;

import com.hotel.villa.entity.Address;
import com.hotel.villa.repository.AddressRepo;
import com.hotel.villa.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    public AddressServiceImpl(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    private final AddressRepo addressRepo;


    @Override
    public Address createAddress(Address address) {

        return addressRepo.save(address);
    }

    @Override
    public Address editeAddressById(Long id, Address address) {

        Address address1=addressRepo.getById(id);

        address1.setCountry(address.getCountry());
        return address1;
    }

    @Override
    public void deleteAddress(Long id) {
       addressRepo.deleteById(id);
    }

    public Optional<Address> getById(Long id) {

        return addressRepo.findById(id);
    }


}
