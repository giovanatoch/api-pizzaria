package com.pizzariagaucha.apipizzaria.repositories;


import com.pizzariagaucha.apipizzaria.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryDrink extends JpaRepository<Drink, Long> {
    Drink findByNome(String nome);

}
