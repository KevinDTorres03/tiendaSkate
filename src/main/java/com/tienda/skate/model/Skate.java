package com.tienda.skate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String brand;
    @Column(length = 4)
    private Integer year;
    @Column(length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    @JsonIgnoreProperties("skates")
    private Category category;

    @OneToMany(mappedBy = "skate", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"skate", "client"})
    private List<Message> messages;

    @OneToMany(mappedBy = "skate", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties({"skate", "messages"})
    private List<Reservation> reservations;
    //geter and seter
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Skate() {
        this.reservations = new ArrayList<Reservation>();
        this.messages = new ArrayList<Message>();
    }

    public Skate(Integer id) {
        this.id = id;
        this.reservations = new ArrayList<Reservation>();
        this.messages = new ArrayList<Message>();
    }

    public Skate(Integer id, String name, String brand, Integer year,
                 String description, Category category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.year = year;
        this.description = description;
        this.category = category;
        this.reservations = new ArrayList<Reservation>();
        this.messages = new ArrayList<Message>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}




