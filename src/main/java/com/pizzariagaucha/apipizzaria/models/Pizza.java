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
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPizza;

    public int getIdPizza() {
        return idPizza;
    }
    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getBasePrice() {
        return basePrice;
    }
    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isPersonalizada() {
        return personalizada;
    }
    public void setPersonalizada(boolean personalizada) {
        this.personalizada = personalizada;
    }

    public List<OrderPizza> getOrderPizzas() {
        return orderPizzas;
    }
    public void setOrderPizzas(List<OrderPizza> orderPizzas) {
        this.orderPizzas = orderPizzas;
    }

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private float basePrice;

    @Column(columnDefinition = "BOOL")
    private boolean personalizada;

    @JsonIgnore
    @OneToMany(mappedBy = "pizza")
    private List<OrderPizza> orderPizzas;

}
