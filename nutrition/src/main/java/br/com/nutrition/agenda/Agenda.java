package br.com.nutrition.agenda;

import br.com.nutrition.Consulta.Consulta;
import br.com.nutrition.Nutricionista.Nutricionista;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "agenda")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Nutricionista nutricionista;

    @OneToMany
    private List<Consulta> consultas;

    public Agenda(Nutricionista nutricionista, List<Consulta> consultas) {
        this.nutricionista = nutricionista;
        this.consultas = consultas;
    }

    public Agenda() {
    }

}
