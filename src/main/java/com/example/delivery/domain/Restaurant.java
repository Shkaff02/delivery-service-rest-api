package com.example.delivery.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity @Table(name = "restaurants")  @NoArgsConstructor

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String cuisine;

    private int rating;

    public Restaurant(Long id, String name, String address, String cuisine, int rating, Set<Dish> dishes, Set<Courier> couriers, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cuisine = cuisine;
        this.rating = rating;
        this.dishes = dishes;
        this.couriers = couriers;
        this.orders = orders;
    }

    public Restaurant(String name, String address, String cuisine, int rating, Set<Dish> dishes, Set<Courier> couriers, Set<Order> orders) {
        this.name = name;
        this.address = address;
        this.cuisine = cuisine;
        this.rating = rating;
        this.dishes = dishes;
        this.couriers = couriers;
        this.orders = orders;
    }

    @ManyToMany
    @JoinTable(name = "rest_dishes",
    joinColumns = {@JoinColumn(name = "rest_id")},
    inverseJoinColumns = {@JoinColumn(name = "dish_id")})
    private Set<Dish> dishes = new HashSet<>();

    @OneToMany(mappedBy = "restaurant")
    private Set<Courier> couriers = new HashSet<>();


    @OneToMany(mappedBy = "restaurant")
    private Set<Order> orders = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    @JsonIgnore
    public Set<Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(Set<Courier> couriers) {
        this.couriers = couriers;
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
