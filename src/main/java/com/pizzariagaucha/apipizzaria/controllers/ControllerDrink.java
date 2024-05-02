package com.pizzariagaucha.apipizzaria.controllers;

import com.pizzariagaucha.apipizzaria.models.Drink;
import com.pizzariagaucha.apipizzaria.service.ServiceDrink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzaria")
public class ControllerDrink {

    @Autowired
    private ServiceDrink serviceDrink;

    @PostMapping("/cadastro-drink")
    public ResponseEntity<?> cadastrarBebida(@RequestBody Drink drink) {
        return serviceDrink.cadastrarBebida(drink);
    }

    @GetMapping("/visualizar-bebidas")
    public ResponseEntity<List<Drink>> findAll() {
        List<Drink> drinks = serviceDrink.findAll();
        return ResponseEntity.ok(drinks);
    }

    @GetMapping(value = "/visualizar-bebidas/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return serviceDrink.findById(id);
    }

    @DeleteMapping(value = "/excluir-bebida/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return serviceDrink.deleteById(id);
    }

    @PutMapping(value = "/editar-drink/{id}")
    public ResponseEntity<Drink> updateById(@RequestBody Drink drink, @PathVariable long id) {
        return serviceDrink.updateById(drink, id);
    }

}
