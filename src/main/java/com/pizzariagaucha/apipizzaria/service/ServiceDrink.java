package com.pizzariagaucha.apipizzaria.service;

import com.pizzariagaucha.apipizzaria.models.Drink;
import com.pizzariagaucha.apipizzaria.repositories.RepositoryDrink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDrink {

    @Autowired
    private RepositoryDrink repositoryDrink;

    public ResponseEntity<?> cadastrarBebida(Drink drink) {
        try {
            if (drink.getIdDrink() != 0) {
                throw new IllegalArgumentException("O ID deve ser gerado automaticamente pelo banco de dados.");
            }

            Drink drinkExistente = repositoryDrink.findByNome(drink.getName());
            if (drinkExistente != null) {
                throw new IllegalArgumentException("Uma drink com este nome já foi cadastrada.");
            }

            Drink drinkCadastrada = repositoryDrink.save(drink);
            return new ResponseEntity<>(drinkCadastrada, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public List<Drink> findAll() {
        return repositoryDrink.findAll();
    }

    public ResponseEntity<?> findById(int id) {
        Optional<Drink> resultado = repositoryDrink.findById((long) id);

        if (resultado.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Drink não encontrada");
        } else {
            return ResponseEntity.ok(resultado.get());
        }
    }

    public ResponseEntity<?> deleteById(int id) {
        Optional<Drink> bebidaResultante = repositoryDrink.findById((long) id);

        if (bebidaResultante.isPresent()) {
            Drink drink = bebidaResultante.get();
            repositoryDrink.deleteById((long) id);
            return ResponseEntity.ok("Drink deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Drink não encontrada.");
        }
    }

    public ResponseEntity<Drink> updateById(Drink drinkAtualizada, long id) {
        Optional<Drink> optionalBebidaExistente = this.repositoryDrink.findById(id);

        if (optionalBebidaExistente.isPresent()) {
            Drink drinkExistente = optionalBebidaExistente.get();
            drinkExistente.setName(drinkAtualizada.getName());
            drinkExistente.setPrice(drinkAtualizada.getPrice());

            Drink drinkAtualizadaSalva = this.repositoryDrink.save(drinkExistente);
            return ResponseEntity.ok(drinkAtualizadaSalva);
        } else {
            throw new IllegalArgumentException("Drink não encontrada com o ID: " + id);
        }
    }
}
