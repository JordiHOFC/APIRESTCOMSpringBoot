package br.com.nutrition.agenda;

import br.com.nutrition.Nutrition.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
