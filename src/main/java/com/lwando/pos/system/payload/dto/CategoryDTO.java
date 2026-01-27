package com.lwando.pos.system.payload.dto;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private  Long id;

    private  String name;

    //private Store store;

    private  Long storeId;
}
