package com.pizzariagaucha.apipizzaria.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDrink {

    public Long getIdOrderDrink() {
        return idOrderDrink;
    }
    public void setIdOrderDrink(Long idOrderDrink) {
        this.idOrderDrink = idOrderDrink;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public Drink getDrink() {
        return drink;
    }
    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBebidaPedida")
    private Long idOrderDrink;

    @ManyToOne
    @JoinColumn(name = "idPedido")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "idBebida")
    private Drink drink;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private int amount;

}
