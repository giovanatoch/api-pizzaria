package com.pizzariagaucha.apipizzaria.service;

import com.pizzariagaucha.apipizzaria.models.Pizza;
import com.pizzariagaucha.apipizzaria.repositories.RepositoryPizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePizza {

    @Autowired
    private RepositoryPizza repositoryPizza;

    public ResponseEntity<?> registrarPizza(Pizza pizza) {
        try {
            Pizza pizzaExistente = repositoryPizza.findByNome(pizza.getName());

            if (pizzaExistente != null) {
                throw new IllegalArgumentException("Uma pizza com este nome já foi cadastrada.");
            }

            Pizza pizzaCadastrada = repositoryPizza.save(pizza);
            return new ResponseEntity<>(pizzaCadastrada, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity<List<Pizza>> findAllPizzas() {
        List<Pizza> pizzas = repositoryPizza.findAll();
        return new ResponseEntity<>(pizzas, HttpStatus.OK);
    }

    public ResponseEntity<?> findById(int id) {
        Pizza pizza = this.repositoryPizza.findById((long) id).orElse(null);

        if (pizza == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pizza não encontrada");
        } else {
            return ResponseEntity.ok(pizza);
        }
    }

    public ResponseEntity<?> deleteById(int id) {
        Optional<Pizza> pizzaResultante = repositoryPizza.findById((long) id);

        if (pizzaResultante.isPresent()) {
            Pizza pizza = pizzaResultante.get();
            repositoryPizza.deleteById((long) id);
            return ResponseEntity.ok("Pizza deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pizza não encontrada.");
        }
    }

    public ResponseEntity<Pizza> updateById(Pizza pizza, int id) throws Exception {
        Pizza pizzaExistente = this.repositoryPizza.findById((long) id)
                .orElseThrow(() -> new Exception("Pizza não encontrada com o ID: " + id));

        pizzaExistente.setName(pizza.getName());
        pizzaExistente.setBasePrice(pizza.getBasePrice());
        pizzaExistente.setPersonalizada(pizza.isPersonalizada());

        Pizza pizzaAtualizada = this.repositoryPizza.save(pizzaExistente);

        return ResponseEntity.ok(pizzaAtualizada);
    }
}
