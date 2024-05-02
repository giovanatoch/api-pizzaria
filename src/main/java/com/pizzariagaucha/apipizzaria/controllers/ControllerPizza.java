package com.pizzariagaucha.apipizzaria.controllers;

import com.pizzariagaucha.apipizzaria.models.Pizza;
import com.pizzariagaucha.apipizzaria.service.ServicePizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzaria")
public class ControllerPizza {

    @Autowired
    private ServicePizza servicePizza;

    @PostMapping("/registrar-pizza")
    public ResponseEntity<?> registrarPizza(@RequestBody Pizza pizza) {
        return servicePizza.registrarPizza(pizza);
    }

    @GetMapping("/visualizar-pizzas")
    public ResponseEntity<List<Pizza>> findAll() {
        return servicePizza.findAllPizzas();
    }

    @GetMapping("/visualizar-pizzas/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
      return servicePizza.findById(id);
    }

    @DeleteMapping(value = "/excluir-pizza/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return servicePizza.deleteById(id);
    }

    @PutMapping(value = "/editar-pizza/{id}")
    public ResponseEntity<Pizza> updateById(@RequestBody Pizza pizza, @PathVariable int id) throws Exception {
        return servicePizza.updateById(pizza, id);
    }

}