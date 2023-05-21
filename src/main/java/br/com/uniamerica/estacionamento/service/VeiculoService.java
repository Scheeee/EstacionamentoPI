package br.com.uniamerica.estacionamento.service;
import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional(rollbackOn = Exception.class) //propagation
    public void cadastrar(final Veiculo veiculo){

        veiculoRepository.save(veiculo);
    }
    public Veiculo editar(Long id, Veiculo veiculo) {
        Veiculo veiculo1 = veiculoRepository.findById(id).orElse(null);
        if ((veiculo1 == null) || veiculo1.equals(veiculo.getId())) {
            throw new RuntimeException("Não foi possível identificar o registro informado");
        }
        veiculo1.setPlaca(veiculo.getPlaca());
        return veiculoRepository.save(veiculo1);
    }


}
