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
public class Size {

    public Long getIdSize() {
        return idSize;
    }
    public void setIdSize(Long idSize) {
        this.idSize = idSize;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getDiscount() {
        return discount;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public List<OrderPizza> getOrderPizzas() {
        return orderPizzas;
    }
    public void setOrderPizzas(List<OrderPizza> orderPizzas) {
        this.orderPizzas = orderPizzas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "TINYINT", nullable = false)
    private Long idSize;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private float discount;

    @OneToMany(mappedBy = "tamanho")
    private List<OrderPizza> orderPizzas;

}
