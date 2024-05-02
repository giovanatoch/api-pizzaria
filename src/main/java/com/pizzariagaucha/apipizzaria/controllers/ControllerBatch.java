package com.pizzariagaucha.apipizzaria.controllers;


import com.pizzariagaucha.apipizzaria.models.Batch;
import com.pizzariagaucha.apipizzaria.service.ServiceBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzaria")
public class ControllerBatch {

    @Autowired
    private ServiceBatch serviceBatch;

    @PostMapping("/registrar-batch")
    public ResponseEntity<?> registrarFornada(@RequestBody Batch batch) {
       return serviceBatch.registrarFornada(batch);
    }

    @GetMapping("/visualizar-fornadas")
    public ResponseEntity<List<Batch>> findAll(){
        return serviceBatch.findAll();
    }

    @GetMapping(value = "/visualizar-fornadas/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return serviceBatch.findById(id);
    }

    @DeleteMapping(value = "/excluir-fornada/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
       return serviceBatch.deleteById(id);
    }

    @PutMapping(value = "/editar-batch/{id}")
    public ResponseEntity<Batch> updateById(@RequestBody Batch batch, @PathVariable long id) {
        return serviceBatch.updateById(batch, id);
    }

}
