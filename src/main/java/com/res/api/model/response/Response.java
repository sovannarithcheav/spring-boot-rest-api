package com.res.api.model.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Getter @Setter
public class Response {

    private String errorCode;
    private String errorMessage;
    private Object data;

    public void setSuccess(Object data){
        this.errorCode = "SUC-01";
        this.errorMessage = "successful";
        this.data = data;
    }
}
