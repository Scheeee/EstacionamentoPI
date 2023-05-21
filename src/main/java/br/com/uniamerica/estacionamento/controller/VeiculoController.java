package br.com.uniamerica.estacionamento.controller;
import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/Veiculo")

public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRep;

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable("id") final Long id){
        return ResponseEntity.ok(new Veiculo());
    }
    @GetMapping("/lista")
    public ResponseEntity <?> ListaCompleta(){
        return ResponseEntity.ok(this.veiculoRep.findAll());
    }

}
