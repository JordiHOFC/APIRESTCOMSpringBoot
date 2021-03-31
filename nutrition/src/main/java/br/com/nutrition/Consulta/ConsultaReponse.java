package br.com.nutrition.Consulta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ConsultaReponse {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("paciente")
    private Long paciente;
    @JsonProperty("nutricionista")
    private Long nutricionista;
    @JsonProperty("horario")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime horario;


    public ConsultaReponse(Consulta consulta) {
        this.id=consulta.getId();
        this.nutricionista=consulta.getNutricionista().getId();
        this.paciente=consulta.getPaciente().getId();
        this.horario=consulta.getHorario();
    }

}
