package br.com.uniamerica.estacionamento.service;

import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.tokens.Token;

import java.util.List;
import java.util.Optional;


@Service
public class CondutorService {
    @Autowired
    final CondutorRepository condutorRepository;
    public CondutorService(CondutorRepository condutorRepository) {
        this.condutorRepository = condutorRepository;
    }
    @Transactional//(rollbackOn = Exception.class)
    public Condutor save(Condutor condutor) {
        return condutorRepository.save(condutor);
    }

    public List<Condutor> findAll(){
        return condutorRepository.findAll();
    }

    public Optional<Condutor> findById(long id){
        return condutorRepository.findById(id);
    }

    @Transactional
    public void delete(Condutor condutor) {
        condutorRepository.delete(condutor);
    }
}
