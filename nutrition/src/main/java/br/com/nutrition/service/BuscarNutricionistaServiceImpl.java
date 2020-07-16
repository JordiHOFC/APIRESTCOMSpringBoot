package br.com.nutrition.service;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.exception.NutricionistaNotFoundException;
import br.com.nutrition.repository.NutricionistaRepository;
@Service
public class BuscarNutricionistaServiceImpl {
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	public static final Logger LOG=Logger.getLogger(BuscarNutricionistaServiceImpl.class);
	
	public List<Nutricionista> buscarTodosNutricionistas(){
		LOG.info("Serviço de buscar todos nutricionistas sendo executado");
		List<Nutricionista>listaNutricionista=nutricionistaRepository.findAll();
		return listaNutricionista;
		
	}
	public Nutricionista buscarNutricionistaPorId(@PathVariable(name="id",required = true)Long id) throws NutricionistaNotFoundException {
		LOG.info("Serviço de buscar um nutricionistas sendo executado");
		Optional<Nutricionista> optionalNutricionista=nutricionistaRepository.findById(id);
		Nutricionista nutricionista=null;
		if(!optionalNutricionista.isPresent()) {
			throw new NutricionistaNotFoundException("Nutricionista não encontrado atraves do Id:"+id);
		}else {
			nutricionista=optionalNutricionista.get();
		}
		return nutricionista;
		
		
		
	}
}
