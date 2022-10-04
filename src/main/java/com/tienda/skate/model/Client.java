package com.tienda.skate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;
    @Column(length = 45)
    private String email;
    @Column(length = 250)
    private String password;
    @Column(length = 250)
    private String name;
    @Column
    private int age;

    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("client")
    private List<Message> messages;

    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;

    public Client() {
        this.reservations = new ArrayList<Reservation>();
        this.messages = new ArrayList<Message>();
    }

    public Client(int idClient) {
        this.idClient = idClient;
        this.reservations = new ArrayList<Reservation>();
        this.messages = new ArrayList<Message>();
    }

    public Client(int idClient, String email, String password, String name, int age) {
        this.idClient = idClient;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.reservations = new ArrayList<Reservation>();
        this.messages = new ArrayList<Message>();
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
}
