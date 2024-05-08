package com.picpaychallenge.services;

import com.picpaychallenge.dtos.TransactionDTO;
import com.picpaychallenge.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository repository;

    private void createTransaction(TransactionDTO transaction) {

    }
}
