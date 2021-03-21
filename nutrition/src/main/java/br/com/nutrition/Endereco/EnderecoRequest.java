package br.com.nutrition.Endereco;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnderecoRequest {
    @NotBlank
    @JsonProperty("logradouro")
    private String logradouro;
    @NotNull
    @JsonProperty("numero")
    private Integer numero;
    @NotBlank
    @JsonProperty("bairro")
    private String bairro;
    @NotBlank
    @JsonProperty("cep")
    private String cep;
    @NotBlank
    @JsonProperty("cidade")
    private String cidade;
    @NotBlank
    @JsonProperty("estado")
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
