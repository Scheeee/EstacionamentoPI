package br.com.uniamerica.estacionamento.service;
import br.com.uniamerica.estacionamento.entity.Marca;
import br.com.uniamerica.estacionamento.repository.MarcaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;

    @Transactional(rollbackOn = Exception.class)

    public void cadastrar(final Marca marca) {
        marcaRepository.save(marca);
    }

}
