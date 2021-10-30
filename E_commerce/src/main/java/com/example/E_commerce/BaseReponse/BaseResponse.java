package com.example.E_commerce.BaseReponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

    @Builder.Default
    private int statusCode = 200;

    @Builder.Default
    private String statusMessage = "success";

    @Builder.Default
    private Object data="null";

    @Builder.Default
    private Object error = "empty";

}