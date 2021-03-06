package br.com.nutrition.Nutricionista;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
	
	@GetMapping @Cacheable("nutricionistas")
	public ResponseEntity<?> buscarTodosNutricionistas() {
		return ResponseEntity.ok(repository.findAll().stream().map(NutricionistaResponse::new).collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable(name="id",required = true)Long id) {
		Optional<Nutricionista> nutricionista=repository.findById(id);
		if(nutricionista.isEmpty()){
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(new NutricionistaResponse(nutricionista.get()));
	}


	@PostMapping @CacheEvict(value = "nutricionistas",allEntries = true)
	public ResponseEntity<?> salvar(@RequestBody @Valid NutricionistaRequest nutricionista) {
		Nutricionista nutri= nutricionista.toModelo();
		return ResponseEntity.ok(new NutricionistaResponse(repository.save(nutri)));
	}

	@DeleteMapping("/{id}") @CacheEvict(value = "nutricionistas",allEntries = true)
	public ResponseEntity<?> deletarNutrucionistaPorId(@PathVariable(name="id",required = true)Long id) {
		Optional<Nutricionista> nutri = repository.findById(id);
		if (nutri.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
