package br.com.nutrition.Handler;

import org.springframework.validation.FieldError;

public class ErrosResponse {
    private String campo;
    private String erro;

    public ErrosResponse(FieldError error) {
        this.campo = error.getField();
        this.erro = error.getDefaultMessage();
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
