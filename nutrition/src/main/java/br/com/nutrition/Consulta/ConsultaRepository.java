package br.com.nutrition.Consulta;

import br.com.nutrition.Nutricionista.Nutricionista;
import br.com.nutrition.Paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {
    Optional<Consulta> findFirstConsultaByNutricionistaIdOrderByIdDesc(Long idNutricionista);

}
