package com.tienda.skate.repository;

import com.tienda.skate.model.Skate;
import com.tienda.skate.repository.interfaces.SkateRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SkateRepository {

    @Autowired
    private SkateRepositoryInterface skateRepositoryInterface;

    public List<Skate> getAll(){
        return (List<Skate>) skateRepositoryInterface.findAll();
    }
    public Optional<Skate> getSkate(int id){
        return skateRepositoryInterface.findById(id);
    }
    public Skate save(Skate skate){
        return skateRepositoryInterface.save(skate);
    }
    public void delete(Skate skate){
        skateRepositoryInterface.delete(skate);
    }
}
