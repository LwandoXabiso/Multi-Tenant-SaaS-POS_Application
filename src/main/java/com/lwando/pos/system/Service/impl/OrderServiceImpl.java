package com.lwando.pos.system.Service.impl;


import com.lwando.pos.system.Service.OrderService;
import com.lwando.pos.system.Service.UserService;
import com.lwando.pos.system.domain.OrderStatus;
import com.lwando.pos.system.domain.PaymentType;
import com.lwando.pos.system.mapper.OrderMapper;
import com.lwando.pos.system.model.*;
import com.lwando.pos.system.payload.dto.OrderDTO;
import com.lwando.pos.system.repository.OrderItemRepository;
import com.lwando.pos.system.repository.OrderRepository;
import com.lwando.pos.system.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) throws Exception {
        User cashier = userService.getCurrentUser();
        Branch branch = cashier.getBranch();

        if (branch == null) {
            throw new Exception("Cashier's branch does not found");
        }

        Order order = Order.builder()
                .branch(branch)
                .cashier(cashier)
                .customer(orderDTO.getCustomer())
                .paymentType(orderDTO.getPaymentType())
                .build();

        List<OrderItem> orderItems = orderDTO.getItems()
                .stream()
                .map(orderItemDTO -> {
                    Product product = productRepository.findById(orderItemDTO.getProductId())
                            .orElseThrow(() -> new EntityNotFoundException("Product does not found"));

                    // return orderItemRepository.save(orderItem);
                    return OrderItem.builder()
                            .product(product)
                            .quantity(orderItemDTO.getQuantity())
                            .price(product.getSellingPrice() * orderItemDTO.getQuantity())
                            .order(order)
                            .build();
                }).toList();

        double totalAmount = orderItems.stream().mapToDouble(OrderItem::getPrice).sum();
        order.setTotalAmount(totalAmount);
        order.setItems(orderItems);

        Order savedOrder = orderRepository.save(order);
        return OrderMapper.toDTO(savedOrder);
    }

    @Override
    public OrderDTO getOrderById(Long orderId) throws Exception {
        return orderRepository.findById(orderId)
                .map(OrderMapper::toDTO)
                .orElseThrow(() -> new Exception("Order with id: " + orderId + " does not found"));
    }


    @Override
    public List<OrderDTO> getOrdersByBranch(Long brandId, Long customerId, Long cashierId,
                                            PaymentType paymentType,
                                            OrderStatus orderStatus) throws Exception {

        return orderRepository.findByBranchId(brandId).stream()
                .filter(order -> customerId == null ||
                        (order.getCustomer() != null && order.getCustomer().getId().equals(customerId)))
                .filter(order -> cashierId == null ||
                        (order.getCashier() != null && order.getCashier().getId().equals(cashierId)))
                .filter(order -> paymentType == null ||
                        order.getPaymentType() == paymentType)
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderByCashierId(Long cashierId) {
        return orderRepository.findByCashierId(cashierId).stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long orderId) throws Exception {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new Exception("Order with id: " + orderId + " does not found"));
        orderRepository.delete(order);
    }

    @Override
    public List<OrderDTO> getTodayOrdersByBranchId(Long branchId) throws Exception {
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.plusDays(1).atStartOfDay();


        return orderRepository.findByBranchIdAndCreatedAtBetween(
                branchId,
                start,
                end
        ).stream().map(OrderMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByCustomerId(Long customerId) throws Exception {
        return orderRepository.findByCustomerId(customerId)
                .stream().map(OrderMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getTop5RecentOrdersByBranchId(Long branchId) throws Exception {
        return orderRepository.findTop5ByBranchIdOrderByCreatedAtDesc(branchId)
                .stream().map(OrderMapper::toDTO).collect(Collectors.toList());
    }
}
