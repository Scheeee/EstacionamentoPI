package br.com.uniamerica.estacionamento.controller;
import br.com.uniamerica.estacionamento.entity.Condutor;
import br.com.uniamerica.estacionamento.entity.Config;
import br.com.uniamerica.estacionamento.repository.CondutorRepository;
import br.com.uniamerica.estacionamento.repository.MovimentacaoRepository;
import br.com.uniamerica.estacionamento.service.CondutorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.Optional;

@Controller
    @RequestMapping(value = "/api/condutor")
    public class CondutorController extends AbstractController {

        @Autowired
        private CondutorRepository condutorRep;
        private MovimentacaoRepository movimentacaoRep;
        @Autowired
        final CondutorService condutorService;
        public CondutorController(CondutorService condutorService) {
            this.condutorService = condutorService;
        }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        Optional<Condutor> condutorOptional = condutorService.findById(id);
        if(!condutorOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Condutor não encontrada");
        }
        return ResponseEntity.ok(condutorService.findById(id));
    }
    @GetMapping("/lista")
        public ResponseEntity <?> getALlCondutores(){
            return ResponseEntity.ok(condutorService.findAll());
        }

    @GetMapping("/ativo")
        public ResponseEntity<?> getByAtivo(){

        return ResponseEntity.ok(condutorService.findByAtivo());
    }

    @PostMapping
    public ResponseEntity<Object> saveCondutor(@RequestBody @Valid Condutor condutor){

       // Optional<Condutor> condutorOptional = condutorService.findByNome(nome);
        //if(condutorOptional.isPresent()) {
         //   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este condutor já foi cadastrado!");
        //}

        return ResponseEntity.status(HttpStatus.CREATED).body(condutorService.save(condutor));

    }

   @PutMapping("/{id}")
    public ResponseEntity<Object> updateCondutor(@PathVariable(value = "id")Long id,@RequestBody @Valid Condutor condutor){
        Optional<Condutor> condutorOptional = condutorService.findById(id);
        if(!condutorOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Condutor não encontrado");
        }

       var condutorNovo = condutorOptional.get();

       condutorNovo.setEdicao(condutor.getEdicao());
       condutorNovo.setNome(condutor.getNome());
       condutorNovo.setCpf(condutor.getCpf());
       condutorNovo.setTelefone(condutor.getTelefone());
       condutorNovo.setTempoPago(condutor.getTempoPago());
       condutorNovo.setTempoDesconto(condutor.getTempoDesconto());
        return ResponseEntity.status(HttpStatus.OK).body(condutorService.save(condutor));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCondutor(@PathVariable(value = "id") Long id){
        Optional<Condutor> condutorOptional = condutorService.findById(id);
        if(!condutorOptional.isPresent()){
            return  ResponseEntity.status(HttpStatus.OK).body(("Condutor não encontrado"));
        }
        condutorService.delete(condutorOptional.get());
        return  ResponseEntity.status(HttpStatus.OK).body("Condutor desativado/deletado com sucesso");

    }


    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return null;
    }
}


