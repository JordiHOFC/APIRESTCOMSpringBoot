package br.com.nutrition.Paciente;

import br.com.nutrition.Endereco.Endereco;
import br.com.nutrition.Nutrition.Nutricionista;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    @Column(unique = true,nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private List<Endereco> enderecos;

    @ManyToOne
    private Nutricionista nutricionista;

    public Paciente(String nome, String cpf, LocalDate dataNascimento, List<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
    }

    public Paciente() {
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", enderecos=" + enderecos.stream().toString() +
                '}';
    }
}
