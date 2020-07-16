package br.com.nutrition.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.nutrition.repository.NutricionistaRepository;
@Service
public class deleteNutricionistaServiceImpl {
	@Autowired
	private NutricionistaRepository nutricionistaRepository;
	public static final Logger LOG=Logger.getLogger(deleteNutricionistaServiceImpl.class);
	public void deletarNutricionista(@PathVariable(name="id",required = true)Long id) {
		LOG.info("Serviço de deletar nutricionista sendo executado");
		nutricionistaRepository.deleteById(id);
		
	}
	public void deletarTodosNutricionistas() {
		LOG.info("Serviço de deletar todos nutricionistas sendo executado");
		nutricionistaRepository.deleteAll();
	}
}
