package com.example.demo.entity.Dto;

import lombok.Builder;

@Builder
public record ContactSaveRequestDTO(Integer status, String message) {
}
