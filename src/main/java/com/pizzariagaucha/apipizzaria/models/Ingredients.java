package com.pizzariagaucha.apipizzaria.models;

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
public class Ingredients {

    public int getIdIngredients() {
        return idIngredients;
    }
    public void setIdIngredients(int idIngredients) {
        this.idIngredients = idIngredients;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public List<OrderPizza> getOrderPizzas() {
        return orderPizzas;
    }

    public void setOrderPizzas(List<OrderPizza> orderPizzas) {
        this.orderPizzas = orderPizzas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idIngredients;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private float price;

    @ManyToMany(mappedBy = "ingredients")
    private List<OrderPizza> orderPizzas;

}
