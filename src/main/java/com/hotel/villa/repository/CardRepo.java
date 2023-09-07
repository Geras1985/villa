package com.hotel.villa.repository;

import com.hotel.villa.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Long> {
    Card findCardByCardNumber(String cardNumber);
}
