package br.com.nutrition.Usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequest {
    @JsonProperty("nome")
    @NotBlank
    private String nome;
    @JsonProperty("email")
    @NotBlank
    @Email
    private String email;
    @JsonProperty("senha")
    @NotBlank
    @Size(min = 8,max = 16)
    private String senha;

    public UsuarioRequest(  @NotBlank String nome,  @NotBlank @Email String email,  @NotBlank @Size(min = 8, max = 16) String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario toModelo(){
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        String password=encoder.encode(this.senha);
        return new Usuario(this.nome,this.email,password);
    }


}
