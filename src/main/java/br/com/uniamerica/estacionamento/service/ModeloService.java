package br.com.uniamerica.estacionamento.service;
import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;

    @Transactional(rollbackOn = Exception.class) //propagation
    public void cadastrar(final Modelo modelo){

        modeloRepository.save(modelo);
    }


}
