package br.com.uniamerica.estacionamento.repository;
import br.com.uniamerica.estacionamento.entity.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CondutorRepository extends JpaRepository<Condutor,Long> {

}
