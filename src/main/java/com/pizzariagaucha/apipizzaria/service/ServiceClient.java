package com.pizzariagaucha.apipizzaria.service;

import com.pizzariagaucha.apipizzaria.models.Client;
import com.pizzariagaucha.apipizzaria.repositories.RepositoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceClient {

    @Autowired
    private RepositoryClient repositoryClient;

    public ResponseEntity<?> registrarCliente(@RequestBody Client client) {
        try {
            if (client.getIdClient() != null) {
                throw new IllegalArgumentException("O ID deve ser gerado automaticamente pelo banco de dados.");
            }

            Client clientExistente = repositoryClient.findByLogin(client.getLogin());

            if (clientExistente != null) {
                throw new IllegalArgumentException("Um client com este login já foi cadastrado.");
            }

            Client clientCadastrado = repositoryClient.save(client);
            return new ResponseEntity<>(clientCadastrado, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity<List<Client>> findAll(){
        List<Client> clients = this.repositoryClient.findAll();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    public ResponseEntity<?> findById(long id){
        Optional<Client> resultado = this.repositoryClient.findById(id);

        if (resultado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client não encontrado.");
        } else {
            return ResponseEntity.ok(resultado.get());
        }
    }

    public ResponseEntity<?> deleteById(long id) {
        Optional<Client> clienteResultante = repositoryClient.findById(id);

        if (clienteResultante.isPresent()) {
            Client client = clienteResultante.get();
            repositoryClient.deleteById(id);
            return ResponseEntity.ok("Client deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client não encontrado.");
        }
    }

    public ResponseEntity<?> updateById(Long id, Client clientAtualizado) {
        try {
            Client clientExistente = repositoryClient.findById(id)
                    .orElseThrow(() -> new Exception("Client não encontrado com o ID: " + id));

            clientExistente.setName(clientAtualizado.getName());
            clientExistente.setNumber(clientAtualizado.getNumber());
            clientExistente.setStreet(clientAtualizado.getStreet());
            clientExistente.setLogin(clientAtualizado.getLogin());
            clientExistente.setPassword(clientAtualizado.getPassword());

            Client clientAtualizadoSalvo = repositoryClient.save(clientExistente);

            return ResponseEntity.ok(clientAtualizadoSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
