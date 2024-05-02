package com.pizzariagaucha.apipizzaria.service;

import com.pizzariagaucha.apipizzaria.models.Batch;
import com.pizzariagaucha.apipizzaria.repositories.RepositoryBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceBatch {

    @Autowired
    private RepositoryBatch repositoryBatch;

    public ResponseEntity<?> registrarFornada(Batch batch) {
        try {
            if (batch.getIdBatch() != 0) {
                throw new IllegalArgumentException("O ID deve ser gerado automaticamente pelo banco de dados.");
            }

            Batch batchCadastrada = repositoryBatch.save(batch);
            return new ResponseEntity<>(batchCadastrada, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    public ResponseEntity<List<Batch>> findAll(){
        List<Batch> batches = this.repositoryBatch.findAll();
        return new ResponseEntity<>(batches, HttpStatus.OK);
    }

    public ResponseEntity<?> findById(int id){
        Optional<Batch> resultado = this.repositoryBatch.findById((long) id);

        if (resultado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Batch não encontrada");
        } else {
            return ResponseEntity.ok(resultado.get());
        }
    }

    public ResponseEntity<?> deleteById(int id) {
        Optional<Batch> clienteResultante = repositoryBatch.findById((long) id);

        if (clienteResultante.isPresent()) {
            Batch batch = clienteResultante.get();
            repositoryBatch.deleteById((long) id);
            return ResponseEntity.ok("Batch deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Batch não encontrada.");
        }
    }

    public ResponseEntity<Batch> updateById(Batch batchAtualizada, long id) {
        Optional<Batch> optionalFornadaExistente = this.repositoryBatch.findById(id);

        if (optionalFornadaExistente.isPresent()) {
            Batch batchExistente = optionalFornadaExistente.get();
            batchExistente.setNumBatch(batchAtualizada.getNumBatch());
            batchExistente.setQtdPizzas(batchAtualizada.getQtdPizzas());

            Batch batchAtualizadaSalva = this.repositoryBatch.save(batchExistente);
            return ResponseEntity.ok(batchAtualizadaSalva);
        } else {
            throw new IllegalArgumentException("Batch não encontrada com o ID: " + id);
        }
    }

}
