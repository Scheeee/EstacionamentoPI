package br.com.uniamerica.estacionamento.repository;
import br.com.uniamerica.estacionamento.entity.Condutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface CondutorRepository extends JpaRepository<Condutor,Long> {

    List<Condutor> findByAtivo(boolean ativo);

    Condutor getByCpf(String condutorCPF);

    Condutor findByCpf(String condutorCPF);
}
