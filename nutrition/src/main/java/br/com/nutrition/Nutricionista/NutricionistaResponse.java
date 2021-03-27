package br.com.nutrition.Nutricionista;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NutricionistaResponse {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("codigoRegistro")
    private String codigoRegistro;

    public NutricionistaResponse(Nutricionista nutricionista){
        this.nome= nutricionista.getNome();
        this.codigoRegistro= nutricionista.getCodigoRegistro();
    }

}
