package br.com.nutrition.Paciente;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {
    private final PacienteRepository repository;

    public PacienteController(PacienteRepository repository) {
        this.repository = repository;
    }
    @PostMapping
    public ResponseEntity<?> cadastrarPaciente(@RequestBody @Valid PacienteRequest pacienteRequest){
        Paciente paciente= pacienteRequest.toModelo();
        PacienteResponse pacienteResponse= new PacienteResponse(repository.save(paciente));
        return ResponseEntity.ok(pacienteResponse);
    }
}
