package br.com.uniamerica.estacionamento.service;
import br.com.uniamerica.estacionamento.entity.Config;
import br.com.uniamerica.estacionamento.repository.ConfigRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfiguracaoService {

        @Autowired
        private ConfigRepository configRepository;

        @Transactional(rollbackOn = Exception.class)
        public void cadastrar(final Config config){

                configRepository.save(config);
        }

}
