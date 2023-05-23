package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {

    Veiculo findByPlaca(Veiculo veiculo);

    List<Veiculo> findByAtivo(boolean b);
}
