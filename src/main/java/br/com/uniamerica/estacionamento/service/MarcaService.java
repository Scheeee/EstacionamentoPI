package br.com.uniamerica.estacionamento.service;
import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Marca;
import br.com.uniamerica.estacionamento.repository.MarcaRepository;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;


@Service
public class MarcaService {
    @Autowired
    final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Transactional//(rollbackOn = Exception.class)
    public Marca save(Marca marca) {
        return marcaRepository.save(marca);
    }

    public List<Marca> findAll(){
        return marcaRepository.findAll();
    }

    public Optional<Marca> findById(long id){
        return marcaRepository.findById(id);
    }

    @Transactional
    public void delete(Marca marca) {
        marcaRepository.delete(marca);
    }
    public List<Marca> findByAtivo() {
        return marcaRepository.findByAtivo(true);
    }

}
