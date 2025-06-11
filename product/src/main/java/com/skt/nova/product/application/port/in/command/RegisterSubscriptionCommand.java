package com.skt.nova.product.application.port.in.command;

import com.skt.nova.product.adapter.in.event.payload.SubscriptionEvent;
import com.skt.nova.product.adapter.in.web.dto.ProductRequest;
import com.skt.nova.product.constants.SubscriptionStatus;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RegisterSubscriptionCommand {

    private Long productId;
    private Long userId;
    private LocalDate startDate;
    private SubscriptionStatus active;

    @Builder
    public RegisterSubscriptionCommand(final Long productId, final Long userId, final LocalDate startDate, final SubscriptionStatus active) {
        this.productId = productId;
        this.userId = userId;
        this.startDate = startDate;
        this.active = active;
    }

    public static RegisterSubscriptionCommand of(final SubscriptionEvent subscriptionEvent) {
        return RegisterSubscriptionCommand.builder()
                .productId(subscriptionEvent.productId())
                .userId(subscriptionEvent.userId())
                .startDate(LocalDate.now())
                .active(SubscriptionStatus.ACTIVE)
                .build();
    }

}
