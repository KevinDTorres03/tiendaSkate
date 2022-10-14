package com.tienda.skate.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
    @Column()
    private Date startDate;
    @Column
    private Date devolutionDate;
    @Column
    private String status = "created";

    @ManyToOne
    @JoinColumn(name = "skate", referencedColumnName = "id")
    @JsonIgnoreProperties("reservations")
    private Skate skate;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "idClient")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("reservation")
    private Score score;

    public void setScore(Score score) {
        this.score = score;
    }

    public Skate getSkate() {
        return skate;
    }

    public void setSkate(Skate skate) {
        this.skate = skate;
    }


    public Reservation() {

    }

    public Reservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Reservation(int idReservation, Date startDate, Date devolutionDate, String status, Skate skate, Client client, Score score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.skate = skate;
        this.client = client;
        this.score = score;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Score getScore() {
        return score;
    }
}