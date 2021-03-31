package br.com.nutrition.Consulta;

import br.com.nutrition.Nutricionista.Nutricionista;
import br.com.nutrition.Paciente.Paciente;

import br.com.nutrition.validator.ExistConsulta;
import br.com.nutrition.validator.ExistRegister;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;


;import java.time.LocalDateTime;


@ExistConsulta
public class ConsultaRequest {

    @NotNull
    @ExistRegister(domainClass = Paciente.class)
    private Long idPaciente;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime horario;

    @NotNull
    @ExistRegister(domainClass = Nutricionista.class)
    private Long idNutricionista;

    public ConsultaRequest(@NotNull Long idPaciente, LocalDateTime horario, @NotNull Long idNutricionista) {
        this.idPaciente = idPaciente;
        this.horario = horario;
        this.idNutricionista = idNutricionista;
    }

    public ConsultaRequest() {
    }

    public Long getIdPaciente() {
        return idPaciente;
    }


    public LocalDateTime getHorario() {
        return horario;
    }

    public Long getIdNutricionista() {
        return idNutricionista;
    }


    public Consulta toModelo(){
        return new Consulta(this.horario,new Paciente(this.idPaciente),new Nutricionista(this.idNutricionista));
    }
}
