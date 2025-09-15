package com.tpelikan.store;

import org.springframework.stereotype.Service;

@Service(value="paypal")
public class PayPalPaymentService implements PaymentService {

    @java.lang.Override
    public void processPayment(double amount) {
        System.out.println("Paypal");
        System.out.println("amount:" + amount);
    }

}
