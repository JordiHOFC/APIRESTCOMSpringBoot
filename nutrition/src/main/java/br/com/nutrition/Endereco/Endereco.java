package br.com.nutrition.Endereco;

import javax.persistence.*;

@Entity
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private String  bairro;

    @Column(nullable = false)
    private String  cep;

    @Column(nullable = false)
    private String cidade;

    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Column(nullable = false)
    private String pais;

    public Endereco(String logradouro, Integer numero, String bairro, String cep, String cidade, Estado estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais ="Brasil";
    }

    public Endereco() {
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado=" + estado +
                ", pais='" + pais + '\'' +
                '}';
    }
}
