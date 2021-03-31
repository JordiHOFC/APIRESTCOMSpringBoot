package br.com.nutrition.Usuario;

import br.com.nutrition.Validator.ExistRegister;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;

public class UserLogin {
    @JsonProperty("email")
    @NotBlank
    private String email;
    @JsonProperty("senha")
    @NotBlank
    private String senha;

    public UserLogin(@NotBlank String email, @NotBlank String senha) {
        this.email = email;
        this.senha = senha;
    }

    public UsernamePasswordAuthenticationToken toAuth(){
        return  new UsernamePasswordAuthenticationToken(email,senha);
    }

}
