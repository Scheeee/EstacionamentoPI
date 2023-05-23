package br.com.uniamerica.estacionamento.controller;
import br.com.uniamerica.estacionamento.entity.Veiculo;
import br.com.uniamerica.estacionamento.repository.VeiculoRepository;
import br.com.uniamerica.estacionamento.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/api/Veiculo")

public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRep;
    @Autowired
    final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id")  Long id){
        Optional<Veiculo> veiculoOptional = veiculoService.findById(id);
        if(!veiculoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado");
        }
        return ResponseEntity.ok(veiculoService.findById(id));
    }

    @GetMapping("/lista")
    public ResponseEntity <?> getALlVeiculo(){
        return ResponseEntity.ok(veiculoService.findAll());
    }
    @PostMapping
    public ResponseEntity<Object> saveVeiculo(@RequestBody @Valid Veiculo veiculo){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.save(veiculo));
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }

    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVeiculo(@PathVariable(value = "id")Long id,@RequestBody @Valid Veiculo veiculo){
        Optional<Veiculo> veiculoOptional = veiculoService.findById(id);
        if(veiculoOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Veiculo não encontrado");
        }

        var veiculoNovo = veiculoOptional.get();

        veiculoNovo.setPlaca(veiculo.getPlaca());
        veiculoNovo.setModelo(veiculo.getModelo());
        veiculoNovo.setCor(veiculo.getCor());
        veiculoNovo.setTipo(veiculo.getTipo());
        veiculoNovo.setAno(veiculo.getAno());

        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.save(veiculo));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVeiculo(@PathVariable(value = "id") Long id){
        Optional<Veiculo> veiculoOptional = veiculoService.findById(id);
        if(!veiculoOptional.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(("Veiculo não encontrado"));
        }
        veiculoService.delete(veiculoOptional.get());
        return  ResponseEntity.status(HttpStatus.OK).body("Veiculo deletado com sucesso");

    }
}
