package com.pizzariagaucha.apipizzaria.repositories;

import com.pizzariagaucha.apipizzaria.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryClient extends JpaRepository<Client, Long> {
    Client findByLogin(String login);
}
