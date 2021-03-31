package br.com.nutrition.Usuario;

import br.com.nutrition.Config.TokenService;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping()
public class UserController {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping("/usuarios")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid UsuarioRequest userRequest) {
        Usuario usuario = userRequest.toModelo();
        repository.save(usuario);
        return ResponseEntity.ok("Usuario: " + usuario.getNome() + " cadastrado com sucesso!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLogin userLogin) {
        Authentication authentication= manager.authenticate(userLogin.toAuth());
        String token=tokenService.gerarToken(authentication);
        return ResponseEntity.ok().headers(h->h.setBearerAuth(token)).body("Login feito com sucesso");

    }
}