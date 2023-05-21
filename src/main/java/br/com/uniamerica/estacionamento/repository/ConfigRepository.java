package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Config;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Config,Long> {
}
