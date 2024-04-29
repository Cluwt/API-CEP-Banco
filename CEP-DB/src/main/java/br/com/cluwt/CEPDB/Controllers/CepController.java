package br.com.cluwt.CEPDB.Controllers;

import br.com.cluwt.CEPDB.Models.Cep;
import br.com.cluwt.CEPDB.Repository.CepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ceps")
public class CepController {

    @Autowired
    private CepRepository cepRepository;

    @GetMapping("/{cep}")
    public ResponseEntity<Cep> getCep(@PathVariable String cep) {
        Cep foundCep = cepRepository.findByCep(cep);
        return foundCep != null ? ResponseEntity.ok(foundCep) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Cep> createCep(@RequestBody Cep newCep) {
        Cep savedCep = cepRepository.save(newCep);
        return ResponseEntity.created(URI.create("/ceps/" + savedCep.getId())).body(savedCep);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cep> updateCep(@PathVariable Long id, @RequestBody Cep updatedCep) {
        if (!cepRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedCep.setId(id);
        Cep savedCep = cepRepository.save(updatedCep);
        return ResponseEntity.ok(savedCep);
    }


    @GetMapping("/all")
    public List<Cep> getAllCeps() {
        return cepRepository.findAll();
    }
}
