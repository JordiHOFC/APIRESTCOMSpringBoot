package br.com.nutrition.Controller;

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

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.exception.NutricionistaNotFoundException;
import br.com.nutrition.exception.NutricionistaResourceException;
import br.com.nutrition.repository.NutricionistaRepository;
import br.com.nutrition.resource.model.NutricionistaResource;
import br.com.nutrition.service.BuscarNutricionistaServiceImpl;
import br.com.nutrition.service.deleteNutricionistaServiceImpl;
import br.com.nutrition.service.saveNutricionistaServiceImpl;

@RestController
@RequestMapping(value="/api")
public class NutricionistaController {
	
	@Autowired
	private BuscarNutricionistaServiceImpl serviceBuscar;
	@Autowired
	private saveNutricionistaServiceImpl serviceSalvar;
	@Autowired
	private deleteNutricionistaServiceImpl serviceDeletar;
	
	@GetMapping(path="/nutricionista")
	public List<Nutricionista> buscar() {
		return serviceBuscar.buscarTodosNutricionistas();
	}
	@GetMapping(path="/nutricionista/id/{id}")
	public Nutricionista buscarPorId(@PathVariable(name="id",required = true)Long id) throws NutricionistaNotFoundException {
		return serviceBuscar.buscarNutricionistaPorId(id);
	}
	@PostMapping(path="/nutricionista/save")
	public void salvar(@RequestBody NutricionistaResource nutricionista) throws NutricionistaResourceException {
		serviceSalvar.salvarNutricionista(nutricionista);
	}
	@DeleteMapping(path="/nutricionista/delete/{id}")
	public void deletarNutrucionistaPorId(@PathVariable(name="id",required = true)Long id) {
		serviceDeletar.deletarNutricionista(id);
		
	}
	@DeleteMapping(path="/nutricionista/delete")
	public void deletarNutrucionistaPorId() {
		serviceDeletar.deletarTodosNutricionistas();
		
	}
}
