package br.com.nutrition.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.exception.NutricionistaResourceException;
import br.com.nutrition.repository.NutricionistaRepository;
import br.com.nutrition.resource.model.NutricionistaResource;
@Service
public class saveNutricionistaServiceImpl {
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	@Autowired
	private NutricionistaConversor serviceConversor;
	
	public static final Logger LOG=Logger.getLogger(saveNutricionistaServiceImpl.class);
	
	public void salvarNutricionista(@RequestBody NutricionistaResource nutricionistaResource) throws NutricionistaResourceException {
		Nutricionista nutricionista=serviceConversor.conversor(nutricionistaResource);
		LOG.info("Servico de salvar nutricionista sendo executado");
		nutricionistaRepository.save(nutricionista);
	}
	
}
