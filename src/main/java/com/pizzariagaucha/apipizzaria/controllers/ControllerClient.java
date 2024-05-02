package com.pizzariagaucha.apipizzaria.controllers;

import com.pizzariagaucha.apipizzaria.models.Client;
import com.pizzariagaucha.apipizzaria.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzaria")
public class ControllerClient {

    @Autowired
    private ServiceClient serviceClient;

    @PostMapping("/registrar-client")
    public ResponseEntity<?> registrarCliente(@RequestBody Client client) {
       return serviceClient.registrarCliente(client);
    }

    @GetMapping("/visualizar-clientes")
    public ResponseEntity<List<Client>> findAll(){
        return serviceClient.findAll();
    }

    @GetMapping(value = "/visualizar-clientes/{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
       return serviceClient.findById(id);
    }

    @DeleteMapping(value = "/excluir-cliente/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        return serviceClient.deleteById(id);
    }

    @PutMapping(value = "/editar-cliente/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Client clientAtualizado) {
        return serviceClient.updateById(id, clientAtualizado);
    }

}
