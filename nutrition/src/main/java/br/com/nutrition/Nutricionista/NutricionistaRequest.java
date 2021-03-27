package br.com.nutrition.Nutricionista;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class NutricionistaRequest {
	@NotBlank
	@JsonProperty("nome")
	private String nome;

	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@NotBlank
	@JsonProperty("codigo_registro")
	private String codigoRegistro;


	public NutricionistaRequest(@NotBlank String nome, @NotNull LocalDate dataNascimento, @NotBlank String codigoRegistro) {
		this.nome = nome;
		this.dataNascimento=dataNascimento;
		this.codigoRegistro = codigoRegistro;
	}

	public NutricionistaRequest() {
	}

	public Nutricionista toModelo(){
		return new Nutricionista(nome,dataNascimento,codigoRegistro);
	}
	@Override
	public String toString() {
		return "NutricionistaResource [nome=" + nome + ", dataNascimento=" + dataNascimento + ", codigoRegistro=" + codigoRegistro
				+ "]";
	}

}
