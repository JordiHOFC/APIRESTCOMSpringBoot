package br.com.nutrition.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;

public class ApiError {
    private int status;
    private String message;
    private List<ErrosResponse> erros;

    public ApiError(List<ErrosResponse> erros){
        this.status = HttpStatus.BAD_REQUEST.value();
        this.message=HttpStatus.BAD_REQUEST.getReasonPhrase();
        this.erros=erros;

    }

    public ApiError() {
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<ErrosResponse> getErros() {
        return erros;
    }
}
