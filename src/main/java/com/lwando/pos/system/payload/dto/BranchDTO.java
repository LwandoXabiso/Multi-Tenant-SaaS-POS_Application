package com.lwando.pos.system.payload.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchDTO {

    private Long id;

    private String name;

    private String address;

    private String phone;

    private String email;

    private List<String> workingDays;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private StoreDTO store;

    private Long storeId;

    private UserDTO manager;

}
