package com.lwando.pos.system.mapper;

import com.lwando.pos.system.model.Order;
import com.lwando.pos.system.payload.dto.OrderDTO;

import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDTO toDTO(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .totalAmount(order.getTotalAmount())
                .branchId(order.getBranch().getId())
                .cashier(UserMapper.toDTO(order.getCashier()))
                .customer(order.getCustomer())
                .paymentType(order.getPaymentType())
                .createdAt(order.getCreatedAt())
                .items(order.getItems().stream()
                        .map(OrderItemMapper::toDTO)
                        .collect(Collectors.toList()))
                .build();
    }
}

// 8:33:49
