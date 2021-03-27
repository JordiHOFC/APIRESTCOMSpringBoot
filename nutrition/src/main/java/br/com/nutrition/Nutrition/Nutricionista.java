package br.com.nutrition.Nutrition;

import br.com.nutrition.Paciente.Paciente;
import br.com.nutrition.agenda.Agenda;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
