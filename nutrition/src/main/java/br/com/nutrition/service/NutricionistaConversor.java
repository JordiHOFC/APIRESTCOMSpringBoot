package br.com.nutrition.service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.com.nutrition.datasource.model.Nutricionista;
import br.com.nutrition.exception.NutricionistaResourceException;
import br.com.nutrition.resource.model.NutricionistaResource;
import net.bytebuddy.implementation.bytecode.Throw;

@Component
public class NutricionistaConversor {
	
	
	public Nutricionista conversor(NutricionistaResource nutricionistaResource) throws NutricionistaResourceException {
		try {
			
			Nutricionista nutricionista= new Nutricionista();
			Long idPaciente=checkId(nutricionistaResource.getIdPaciente());
			LocalDate idade=checkIdade(nutricionistaResource.getIdade());
			nutricionista.setIdade(idade);
			nutricionista.setIdPaciente(idPaciente);
			nutricionista.setNome(nutricionistaResource.getNome());
			nutricionista.setCodigoRegistro(nutricionistaResource.getCodigoRegistro());
			return nutricionista;
			
		}catch (Exception e) {
			throw new NutricionistaResourceException("Falha ao converter o resource para entidade, resource: "+nutricionistaResource);
		}
	}
	private Long checkId(String id) {
		return Long.parseLong(id);
	}
	private LocalDate checkIdade(String idade) {
		return LocalDate.parse(idade);
	}
		
}
