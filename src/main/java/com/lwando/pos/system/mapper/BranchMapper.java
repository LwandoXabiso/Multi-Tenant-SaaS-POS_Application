package com.lwando.pos.system.mapper;

import com.lwando.pos.system.modal.Branch;
import com.lwando.pos.system.modal.Store;
import com.lwando.pos.system.payload.dto.BranchDTO;

import java.time.LocalDateTime;

public class BranchMapper {

    public static BranchDTO toDTO(Branch branch) {
        return BranchDTO.builder()
                .id(branch.getId())
                .name(branch.getName())
                .address(branch.getAddress())
                .phone(branch.getPhone())
                .email(branch.getEmail())
                .closingTime(branch.getClosingTime())
                .openingTime(branch.getOpeningTime())
                .workingDays(branch.getWorkingDays())
                .storeId(branch.getStore() != null ? branch.getStore().getId() : null)
                .createdAt(branch.getCreatedAt())
                .build();
    }

    public static Branch toEntity(BranchDTO dto, Store store) {
        return Branch.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .store(store)
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .closingTime(dto.getClosingTime())
                .openingTime(dto.getOpeningTime())
                .workingDays(dto.getWorkingDays())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
