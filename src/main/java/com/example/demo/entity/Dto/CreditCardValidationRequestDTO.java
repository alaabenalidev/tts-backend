package com.example.demo.entity.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardValidationRequestDTO {
    Long creditCard;
    Boolean status;
}
