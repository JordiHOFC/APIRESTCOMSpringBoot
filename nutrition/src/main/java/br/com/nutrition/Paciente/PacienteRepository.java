package br.com.nutrition.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PacienteRepository extends JpaRepository<Paciente,Long> {
    Optional<Paciente> findByCpf(String cpf);
}