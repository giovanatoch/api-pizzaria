package com.pizzariagaucha.apipizzaria.repositories;

import com.pizzariagaucha.apipizzaria.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryPizza extends JpaRepository<Pizza, Long> {
    Pizza findByNome(String nome);
}
