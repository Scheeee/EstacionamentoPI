package br.com.uniamerica.estacionamento.service;
import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Modelo;
import br.com.uniamerica.estacionamento.repository.MarcaRepository;
import br.com.uniamerica.estacionamento.repository.ModeloRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.AssertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class ModeloService {
    @Autowired
    private ModeloRepository modeloRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    @Transactional//(rollbackOn = Exception.class)
    public Modelo save(Modelo modelo) {

        Long marcaId = modelo.getMarca().getId();
        //boolean existe = marcaRepository.findById(marcaId).get()!= null;

        //if (marcaRepository.findById(marcaId).get()!= null) {

        //}
        Assert.isTrue(marcaRepository.findById(marcaId).get()!= null, "Marca não encontrada!");
        modelo.setMarca(marcaRepository.getById(marcaId));

        return modeloRepository.save(modelo);
    }

    public List<Modelo> findAll(){
        return modeloRepository.findAll();
    }

    public Optional<Modelo> findById(long id){
        return modeloRepository.findById(id);
    }

    @Transactional
    public void delete(Modelo modelo) {
        modeloRepository.delete(modelo);
    }


}
