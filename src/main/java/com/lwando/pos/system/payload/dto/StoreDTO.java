package com.lwando.pos.system.payload.dto;

import com.lwando.pos.system.domain.StoreStatus;
import com.lwando.pos.system.modal.StoreContact;
import com.lwando.pos.system.modal.User;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class StoreDTO {

    private Long id;

    private String brand;

    private UserDto storeAdmin;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String description;

    private String storeType;

    private StoreStatus status;

    private StoreContact contact;
}
