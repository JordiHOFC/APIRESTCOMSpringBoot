package br.com.nutrition.Paciente;

import br.com.nutrition.Endereco.EnderecoRequest;
import br.com.nutrition.validator.ExistRegister;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteRequest {
    @NotBlank
    @JsonProperty("nome")
    private String nome;
    @NotBlank
    @CPF
    @JsonProperty("cpf")
    @ExistRegister(domainClass = Paciente.class,field = "cpf")
    private String cpf;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("dataNascimento")
    private LocalDate dataNascimento;
    @NotNull
    @JsonProperty("enderecos")
    private List<EnderecoRequest> enderecos;

    public PacienteRequest(@NotBlank String nome, @NotBlank @CPF String cpf, @NotNull LocalDate dataNascimento, @NotNull List<EnderecoRequest> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.enderecos = enderecos;
    }

    public PacienteRequest() {
    }
    public Paciente toModelo(){
        return new Paciente(nome,cpf,dataNascimento,enderecos.stream().map(enderecoRequest -> enderecoRequest.toModelo()).collect(Collectors.toList()));
    }
}
