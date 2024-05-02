package com.pizzariagaucha.apipizzaria.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;

    @JsonIgnore
    @OneToMany(mappedBy = "pedido")
    private List<OrderPizza> orderPizzas;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Client client;

    public Long getIdOrder() {
        return idOrder;
    }
    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public List<OrderPizza> getOrderPizzas() {
        return orderPizzas;
    }
    public void setOrderPizzas(List<OrderPizza> orderPizzas) {
        this.orderPizzas = orderPizzas;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public Batch getBatch() {
        return batch;
    }
    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public List<OrderDrink> getOrderDrinks() {
        return orderDrinks;
    }
    public void setOrderDrinks(List<OrderDrink> orderDrinks) {
        this.orderDrinks = orderDrinks;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @ManyToOne
    @JoinColumn(name = "idFornada")
    private Batch batch;

    @JsonIgnore
    @OneToMany(mappedBy = "pedido")
    private List<OrderDrink> orderDrinks;

    @Column(nullable = false)
    private LocalDateTime dataHora;

}
