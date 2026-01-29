package com.lwando.pos.system.payload.dto;


import com.lwando.pos.system.domain.PaymentType;
import com.lwando.pos.system.model.ShiftReport;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefundDTO {

    private Long id;

    private OrderDTO order;

    private Long orderId;

    private String reason;

    private Double amount;

    // private ShiftReport shiftReport;

    private Long shiftReportId;

    private UserDTO cashier;

    private String cashierName;

    private BranchDTO branch;

    private Long branchId;

    private LocalDateTime createdAt;

    private PaymentType paymentType;
}
