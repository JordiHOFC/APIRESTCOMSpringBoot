package br.com.nutrition.Consulta;

import br.com.nutrition.Nutricionista.Nutricionista;
import br.com.nutrition.Paciente.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="consulta")
public class Consulta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime horario;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Nutricionista nutricionista;


    public Consulta(LocalDateTime horario, Paciente paciente, Nutricionista nutricionista) {
        this.horario = horario;
        this.paciente = paciente;
        this.nutricionista = nutricionista;
    }

    public Consulta() {
    }

    public Long getId() {
        return id;
    }

    public Nutricionista getNutricionista() {
        return nutricionista;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", horario=" + horario +
                ", paciente=" + paciente +
                ", nutricionista=" + nutricionista +
                '}';
    }
}
