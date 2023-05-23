package br.com.uniamerica.estacionamento.repository;

import br.com.uniamerica.estacionamento.entity.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModeloRepository extends JpaRepository<Modelo,Long> {
    Modelo findByNome(Modelo modelo);

    List<Modelo> findByAtivo(boolean b);
}
