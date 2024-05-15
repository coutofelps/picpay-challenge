package com.picpaychallenge.services;

import com.picpaychallenge.domain.user.User;
import com.picpaychallenge.domain.user.UserType;
import com.picpaychallenge.dtos.TransactionDTO;
import com.picpaychallenge.dtos.UserDTO;
import com.picpaychallenge.repositories.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TransactionServiceTest {
    @Mock
    private UserService userService;

    @Mock
    private TransactionRepository repository;

    @Mock
    private NotificationService notificationService;

    @Mock
    private AuthorizationService authorizationService;

    @Autowired
    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Should create transaction successfully when everything is ok")
    void createTransactionCaseOne() throws Exception {
        UserDTO senderDTO = new UserDTO("Marcos Felipe", "Rodrigues Couto", "12345678900", new BigDecimal(10), "0709.marcoscouto@gmail.com", "123456", UserType.COMMON);
        UserDTO receiverDTO = new UserDTO("Nathália", "Miguez da Fonseca", "99999999900", new BigDecimal(30), "nathalia.miguez16@gmail.com", "123456", UserType.COMMON);

        User sender = new User(senderDTO);
        User receiver = new User(receiverDTO);

        when(userService.findUserById(1L)).thenReturn(sender);
        when(userService.findUserById(2L)).thenReturn(receiver);

        when(authorizationService.authorizeTransaction(any(), any())).thenReturn(true);

        TransactionDTO request = new TransactionDTO(new BigDecimal(10), 1L, 2L);
        transactionService.createTransaction(request);

        verify(repository, times(1)).save(any());

        sender.setBalance(new BigDecimal(0));
        receiver.setBalance(new BigDecimal(40));
        verify(userService, times(2)).saveUser(any());

        verify(notificationService, times(1)).sendNotification(sender, "Transação realizada com sucesso");
        verify(notificationService, times(1)).sendNotification(receiver, "Transação realizada com sucesso");
    }

    @Test
    @DisplayName("Should throw exception when transaction authorization is not allowed")
    void createTransactionCaseTwo() throws Exception {
        UserDTO senderDTO = new UserDTO("Marcos Felipe", "Rodrigues Couto", "12345678900", new BigDecimal(10), "0709.marcoscouto@gmail.com", "123456", UserType.COMMON);
        UserDTO receiverDTO = new UserDTO("Nathália", "Miguez da Fonseca", "99999999900", new BigDecimal(30), "nathalia.miguez16@gmail.com", "123456", UserType.COMMON);

        User sender = new User(senderDTO);
        User receiver = new User(receiverDTO);

        when(userService.findUserById(1L)).thenReturn(sender);
        when(userService.findUserById(2L)).thenReturn(receiver);

        when(authorizationService.authorizeTransaction(any(), any())).thenReturn(false);

        Exception thrown = Assertions.assertThrows(Exception.class, () -> {
            TransactionDTO request = new TransactionDTO(new BigDecimal(10), 1L, 2L);
            transactionService.createTransaction(request);
        });

        Assertions.assertEquals("Transação não autorizada", thrown.getMessage());
    }
}