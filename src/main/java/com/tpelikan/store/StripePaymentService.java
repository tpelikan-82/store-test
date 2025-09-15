package com.tpelikan.store;

import org.springframework.stereotype.Service;

@Service(value="stripe")
public class StripePaymentService implements PaymentService {

    @java.lang.Override
    public void processPayment(double amount) {
        System.out.println("Stripe ");
        System.out.println("amount:" + amount);
    }

}
