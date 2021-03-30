package br.com.nutrition.Consulta;

import br.com.nutrition.Nutricionista.Nutricionista;
import br.com.nutrition.Paciente.Paciente;

import br.com.nutrition.validator.ExistConsulta;
import br.com.nutrition.validator.ExistRegister;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

;import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ExistConsulta
public class ConsultaRequest {

    @NotNull
    @ExistRegister(domainClass = Paciente.class)
    private Long idPaciente;

    @NotBlank
    private String horario;

    @NotNull
    @ExistRegister(domainClass = Nutricionista.class)
    private Long idNutricionista;

    public ConsultaRequest(@NotNull Long idPaciente, String horario, @NotNull Long idNutricionista) {
        this.idPaciente = idPaciente;
        this.horario = horario;
        this.idNutricionista = idNutricionista;
    }

    public ConsultaRequest() {
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public String getHorario() {
        return horario;
    }

    public Long getIdNutricionista() {
        return idNutricionista;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Consulta toModelo(){
        LocalDateTime time=LocalDateTime.parse(this.horario, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return new Consulta(time,new Paciente(this.idPaciente),new Nutricionista(this.idNutricionista));
    }
}
