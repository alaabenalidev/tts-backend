package com.example.demo.entity.Dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactValidationRequestDTO {
    private long id;
    private Boolean status;
}
