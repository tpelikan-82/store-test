package com.tpelikan.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    @Qualifier("stripe")
    PaymentService paymentService;

    public void placeOrder() {
        paymentService.processPayment(10);
    }

}
