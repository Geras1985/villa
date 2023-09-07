package com.hotel.villa.controller;

import com.hotel.villa.entity.Address;
import com.hotel.villa.entity.Card;
import com.hotel.villa.entity.Hotel;
import com.hotel.villa.entity.User;
import com.hotel.villa.service.impl.AddressServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/address")
public class AddressController {

    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    private  final AddressServiceImpl addressService;



    @PostMapping("/add")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){

        Address address1=new Address();

        address1.setResidenceAddress(address.getResidenceAddress());
        address1.setRegistrationAddress(address.getRegistrationAddress());
        address1.setCity(address.getCity());
        address1.setPostalCode(address.getPostalCode());
        address1.setCountry(address.getCountry());
        return new ResponseEntity<>(address1, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id){
        if (id!=null){
            Optional<Address> address = addressService.getById(id);
            if (address!=null) {
                addressService.deleteAddress(id);
            }return new ResponseEntity<>("The "+address+" was deleted successfully", HttpStatus.OK);
        }

        return new ResponseEntity<>("This ID card was not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Address> getAddress(@PathVariable Long id){

        Optional<Address> address=addressService.getById(id);
        System.out.println(address);
        if(address!=null){

            return new ResponseEntity(address, HttpStatus.OK);
        }
        return null;
    }

    @PatchMapping("/editAddress/{id}")
    public ResponseEntity<Address> editAddress(@PathVariable Long id, @RequestBody Address address){
        Address address1 = addressService.editeAddressById(id, address);

return  new ResponseEntity<>(address1,HttpStatus.OK);

    }
}
