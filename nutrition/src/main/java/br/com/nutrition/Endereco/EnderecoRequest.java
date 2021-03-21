package br.com.nutrition.Endereco;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnderecoRequest {
    @NotBlank
    private String logradouro;
    @NotNull
    private Integer numero;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cep;
    @NotBlank
    private String cidade;
    @NotBlank
    private Estado estado;

    public EnderecoRequest(@NotBlank String logradouro, @NotNull Integer numero, @NotBlank String bairro, @NotBlank String cep, @NotBlank String cidade, @NotBlank Estado estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public EnderecoRequest() {
    }

    public Endereco toModelo(){
        return new Endereco(logradouro,numero,bairro,cep,cidade,estado);
    }

}
