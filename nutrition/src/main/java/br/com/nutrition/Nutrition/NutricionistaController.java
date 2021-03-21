package br.com.nutrition.Nutrition;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(value="/api/nutricionista")
public class NutricionistaController {

	@Autowired
	private NutricionistaRepository repository;
	
	@GetMapping
	public List<Nutricionista> buscarTodosNutricionistas() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name="id",required = true)Long id) {
		Optional<Nutricionista> nutricionista=repository.findById(id);
		if(nutricionista.isEmpty()){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(nutricionista.get());
	}


	@PostMapping
	public void salvar(@RequestBody @Valid NutricionistaRequest nutricionista) {
		Nutricionista nutri= nutricionista.toModelo();
		repository.save(nutri);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarNutrucionistaPorId(@PathVariable(name="id",required = true)Long id) {
		Optional<Nutricionista> nutri = repository.findById(id);
		if (nutri.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
