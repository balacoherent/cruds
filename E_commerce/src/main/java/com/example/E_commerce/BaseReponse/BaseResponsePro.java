package com.example.E_commerce.BaseReponse;

import lombok.*;

@Data
@Builder
public class BaseResponsePro<T> {

    @Builder.Default
    private int statusCode = 200;

    @Builder.Default
    private String statusMessage = "success";

    private T Data;

}
