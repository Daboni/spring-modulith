package com.skt.nova.product.adapter.in.web.dto;

import java.time.LocalDate;
import java.util.UUID;

public record UserResult(
        UUID userId,
        String name,
        LocalDate birthDate,
        LocalDate registrationDate
) {
}
