package com.memorybox.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MaturityInfoResponseDto(LocalDate startDate, LocalDate maturityDate, boolean isMaturity) {
}
