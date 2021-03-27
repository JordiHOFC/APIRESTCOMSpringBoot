package br.com.nutrition.Paciente;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PacienteResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nome")
    private String nome;

    public PacienteResponse(Paciente paciente){
        this.id=paciente.getId();
        this.nome= paciente.getNome();
    }
}
