package com.lwando.pos.system.model;

import com.lwando.pos.system.domain.PaymentType;
import lombok.Data;

@Data
public class PaymentSummary {

    private PaymentType paymentType;

    private Double totalAmount;

    private int transactionCount;

    private double percentage;
}
