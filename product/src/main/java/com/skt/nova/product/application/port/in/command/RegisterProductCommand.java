package com.skt.nova.product.application.port.in.command;

import com.skt.nova.product.adapter.in.web.dto.ProductRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RegisterProductCommand {
    String name;
    int monthlyRate;
    int talk;
    int sms;
    int data;

    @Builder
    private RegisterProductCommand(final String name, final int monthlyRate, final int talk, final int sms, final int data) {
        this.name = name;
        this.monthlyRate = monthlyRate;
        this.talk = talk;
        this.sms = sms;
        this.data = data;
    }

    public static RegisterProductCommand of(ProductRequest productRequest) {
        return RegisterProductCommand.builder()
                .name(productRequest.name())
                .monthlyRate(productRequest.monthlyRate())
                .talk(productRequest.talk())
                .sms(productRequest.sms())
                .data(productRequest.data())
                .build();
    }

}
