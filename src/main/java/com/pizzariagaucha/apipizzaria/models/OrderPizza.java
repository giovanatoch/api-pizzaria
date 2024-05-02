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
public class OrderPizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrderPizza;

    @ManyToOne
    @JoinColumn(name = "idPedido", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "idPizza", nullable = false)
    private Pizza pizza;

    public Long getIdOrderPizza() {
        return idOrderPizza;
    }
    public void setIdOrderPizza(Long idOrderPizza) {
        this.idOrderPizza = idOrderPizza;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }

    public Pizza getPizza() {
        return pizza;
    }
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Size getSize() {
        return size;
    }
    public void setSize(Size size) {
        this.size = size;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }
    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    @ManyToOne
    @JoinColumn(name = "idTamanho", nullable = false)
    private Size size;

    @Column(nullable = false)
    private int amount;

    @ManyToMany
    @JoinTable(
            name = "PizzaPedida_has_Ingrediente",
            joinColumns = @JoinColumn(name = "idPizzaPedida"),
            inverseJoinColumns = @JoinColumn(name = "idIngrediente")
    )
    private List<Ingredients> ingredients;

}
