package com.hotel.villa.service.impl;

import com.hotel.villa.entity.Card;
import com.hotel.villa.entity.User;
import com.hotel.villa.repository.CardRepo;
import com.hotel.villa.repository.UserRepo;
import com.hotel.villa.service.CardService;
import com.hotel.villa.util.Helper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    private final CardRepo cardRepo;
    private final UserRepo userRepo;

    public CardServiceImpl(CardRepo cardRepo, UserRepo userRepo) {
        this.cardRepo = cardRepo;
        this.userRepo = userRepo;
    }

    @Override
    public ResponseEntity<Card> createCard(Long userId, String cardName) {
        return null;
    }

    /**
     * This method get all cards and returns as a list .
     */
    public List<Card> getAll() {
        return cardRepo.findAll();
    }

    @Override
    public Card findByUsername(String username) {
        return null;
    }





    /**
     * This method delete the card by id.
     */
    @Override
    public void deleteCard(Long id) {
        cardRepo.deleteById(id);
    }

    @Override
    public Card getById(Long id) {
        return cardRepo.getById(id);
    }
}
