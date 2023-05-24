package br.com.uniamerica.estacionamento.service;
import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
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
    @Autowired
    final ModeloRepository modeloRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, ModeloRepository modeloRepository) {
        this.veiculoRepository = veiculoRepository;
        this.modeloRepository = modeloRepository;
    }

    @Transactional//(rollbackOn = Exception.class)
    public Veiculo save(Veiculo veiculo) {
        Long modeloId = veiculo.getModelo().getId();

       veiculo.setModelo(modeloRepository.getById(modeloId));
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
        boolean ativo = veiculo.isAtivo();

        if(ativo == true){
            veiculo.setAtivo(false);
        }
        else {
            veiculoRepository.delete(veiculo);
        }
    }

    public List<Veiculo> findByAtivo() {
        return veiculoRepository.findByAtivo(true);
    }


}
