package br.com.uniamerica.estacionamento.service;
import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class VeiculoService {
    @Autowired
    final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @Transactional//(rollbackOn = Exception.class)
    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> findAll(){
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> findById(long id){
        return veiculoRepository.findById(id);
    }

    @Transactional
    public void delete(Veiculo veiculo) {
        veiculoRepository.delete(veiculo);
    }

    public List<Veiculo> findByAtivo() {
        return veiculoRepository.findByAtivo(true);
    }


}
