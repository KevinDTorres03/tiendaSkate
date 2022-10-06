package com.tienda.skate.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@JsonIgnoreProperties("skates")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45)
    private String name;
    @Column(length = 250)
    private String description;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties("category")
    private List<Skate> skates ;

    public Category() {
        this.skates  = new ArrayList<Skate>();
    }

    public Category(Integer id) {
        this.id = id;
        this.skates  = new ArrayList<Skate>();
    }

    public Category(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.skates  = new ArrayList<Skate>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Skate> getSkates() {
        return skates ;
    }

    public void setSkates(List<Skate> skates ) {
        this.skates  = skates ;
    }
}
