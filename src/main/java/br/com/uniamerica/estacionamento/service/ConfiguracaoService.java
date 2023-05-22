package br.com.uniamerica.estacionamento.service;
import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Config;
import br.com.uniamerica.estacionamento.repository.ConfigRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiguracaoService {

        @Autowired
        private ConfigRepository configRepository;

        @Transactional(rollbackOn = Exception.class)
        public void cadastrar(final Config config){

                configRepository.save(config);
        }

    public List<Config> findAll(){
        return configRepository.findAll();
    }

    public Optional<Config> findById(long id){
        return configRepository.findById(id);
    }

    @Transactional
    public Config save(Config config) {
            return configRepository.save(config);
    }

    @Transactional
    public void delete(Config config) {
            configRepository.delete(config);
    }
}
