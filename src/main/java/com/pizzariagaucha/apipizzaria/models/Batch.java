package com.pizzariagaucha.apipizzaria.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Batch {

    public int getIdBatch() {
        return idBatch;
    }
    public void setIdBatch(int idBatch) {
        this.idBatch = idBatch;
    }

    public int getNumBatch() {
        return numBatch;
    }
    public void setNumBatch(int numBatch) {
        this.numBatch = numBatch;
    }

    public int getQtdPizzas() {
        return qtdPizzas;
    }
    public void setQtdPizzas(int qtdPizzas) {
        this.qtdPizzas = qtdPizzas;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "TINYINT")
    private int idBatch;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private int numBatch;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private int qtdPizzas;

    @JsonIgnore
    @OneToMany(mappedBy = "batch")
    private List<Order> orders;

}
