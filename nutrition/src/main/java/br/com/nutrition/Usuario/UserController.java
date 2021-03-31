package br.com.nutrition.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public ResponseEntity<?> cadastrarUsuario(@RequestBody @Valid UsuarioRequest userRequest){
        Usuario usuario=userRequest.toModelo();
        repository.save(usuario);
        return ResponseEntity.ok("Usuario: "+usuario.getNome()+" cadastrado com sucesso!");
    }
    @GetMapping
    public String get(){
        return "Deu boa malandro!";
    }
}
