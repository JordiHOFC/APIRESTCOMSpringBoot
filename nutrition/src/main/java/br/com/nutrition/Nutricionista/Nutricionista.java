package br.com.nutrition.Nutricionista;

import br.com.nutrition.Agenda.Agenda;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="nutricionista")
public class Nutricionista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private LocalDate idade;

	@Column(name="codigo_registro",nullable = false,unique = true)
	private String codigoRegistro;
	@OneToOne(mappedBy = "nutricionista")
	private Agenda agenda;

	public Nutricionista() {
		
	}

	public Nutricionista(String nome, LocalDate idade, String codigoRegistro) {
		this.nome = nome;
		this.idade = idade;
		this.codigoRegistro = codigoRegistro;
	}

	public Nutricionista(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getIdade() {
		return idade;
	}

	public void setIdade(LocalDate idade) {
		this.idade = idade;
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

}
