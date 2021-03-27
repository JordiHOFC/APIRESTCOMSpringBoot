package br.com.nutrition.Consulta;

import br.com.nutrition.Nutricionista.Nutricionista;
import br.com.nutrition.Paciente.Paciente;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="consulta")
public class Consulta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
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
}
