package com.tienda.skate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;
    @Column(length = 250)
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "skate", referencedColumnName = "id")
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Skate skate;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "idClient")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    public Message() {

    }

    public Message(int idMessage) {
        this.idMessage = idMessage;
    }

    public Message(int idMessage, String messageText, Skate skate, Client client) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.skate = skate;
        this.client = client;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Skate getSkate() {
        return skate;
    }

    public void setSkate(Skate skate) {
        this.skate = skate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
