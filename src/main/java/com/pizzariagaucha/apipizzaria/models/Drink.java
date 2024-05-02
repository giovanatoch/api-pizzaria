package com.pizzariagaucha.apipizzaria.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Drink {

    public int getIdDrink() {
        return idDrink;
    }
    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
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

    public List<OrderDrink> getOrderDrinks() {
        return orderDrinks;
    }

    public void setOrderDrinks(List<OrderDrink> orderDrinks) {
        this.orderDrinks = orderDrinks;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDrink;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private float price;

    @JsonIgnore
    @OneToMany(mappedBy = "drink")
    private List<OrderDrink> orderDrinks;

}
