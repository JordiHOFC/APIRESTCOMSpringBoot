package br.com.nutrition.Nutrition;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class NutricionistaRequest {
	
	@JsonProperty("nome_nutricionista")
	private String nome;
	@JsonProperty("idade")
	private LocalDate idade;
	@JsonProperty("codigo_registro")
	private String codigoRegistro;
	
	@JsonProperty("id_paciente")
	private Long idPaciente;

	public NutricionistaRequest(String nome, Long idPaciente) {

		this.nome = nome;
		this.idPaciente = idPaciente;
	}

	public NutricionistaRequest() {
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

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Nutricionista toModel(){
		return new Nutricionista(nome,idade,codigoRegistro,idPaciente);
	}
	@Override
	public String toString() {
		return "NutricionistaResource [nome=" + nome + ", idade=" + idade + ", codigoRegistro=" + codigoRegistro
				+ ", idPaciente=" + idPaciente + "]";
	}

}
