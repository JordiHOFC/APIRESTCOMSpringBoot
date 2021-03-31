package br.com.nutrition.Consulta;

import br.com.nutrition.Nutricionista.Nutricionista;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaRepository consultaRepository;

    public ConsultaController(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }
    @PostMapping
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> cadastrarConsulta(@RequestBody @Valid ConsultaRequest consultaRequest){
        Consulta consulta= consultaRequest.toModelo();
        return ResponseEntity.ok(new ConsultaReponse(  consultaRepository.save(consulta)));
    }
    @GetMapping
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> listarConsultas(){
        return ResponseEntity.ok(consultaRepository.findAll().stream().map(ConsultaReponse::new).collect(Collectors.toList()));
    }
}
