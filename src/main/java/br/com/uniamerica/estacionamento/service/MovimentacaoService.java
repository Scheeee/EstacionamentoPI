package br.com.uniamerica.estacionamento.service;
import br.com.uniamerica.estacionamento.entity.Movimentacao;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import br.com.uniamerica.estacionamento.repository.ConfigRepository;
import br.com.uniamerica.estacionamento.repository.MovimentacaoRepository;
import br.com.uniamerica.estacionamento.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class MovimentacaoService {
    @Autowired
    final MovimentacaoRepository movimentacaoRepository;
    @Autowired
    final VeiculoRepository veiculoRepository;
    @Autowired
    final CondutorRepository condutorRepository;
    @Autowired
    final ConfigRepository configRepository;

    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository, VeiculoRepository veiculoRepository, CondutorRepository condutorRepository, ConfigRepository configRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.veiculoRepository = veiculoRepository;
        this.condutorRepository = condutorRepository;
        this.configRepository = configRepository;
    }

    @Transactional//(rollbackOn = Exception.class)
    public Movimentacao save(Movimentacao movimentacao) {
        Long veiculoId = movimentacao.getVeiculo().getId();
        String condutorCPF = movimentacao.getCondutor().getCpf();
        //Assert.isTrue(veiculoRepository.findById(veiculoId).get()!= null, "Veiculo não encontrada!");
        movimentacao.setVeiculo(veiculoRepository.getById(veiculoId));
        movimentacao.setCondutor(condutorRepository.getByCpf(condutorCPF));

        return movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> findAll(){
        return movimentacaoRepository.findAll();
    }

    public Optional<Movimentacao> findById(long id){
        return movimentacaoRepository.findById(id);
    }

    @Transactional
    public void delete(Movimentacao movimentacao) {
        movimentacaoRepository.delete(movimentacao);
    }

    public List<Movimentacao> findByAtivo() {
        return movimentacaoRepository.findByAtivo(true);
    }

    /*public boolean notNull(Movimentacao movimentacao){
        Long veiculoId = movimentacao.getVeiculo().getId();
        String condutorCPF = movimentacao.getCondutor().getCpf();
        //Assert.isTrue(veiculoRepository.findById(veiculoId).get()!= null, "Veiculo não encontrada!");
       // Assert.isTrue(!(null == condutorRepository.findByCpf(condutorCPF).get()), "Veiculo não encontrada!");

        return true;
    }*/

}
