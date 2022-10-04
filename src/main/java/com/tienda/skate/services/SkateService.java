package com.tienda.skate.services;

import com.tienda.skate.model.Skate;
import com.tienda.skate.repository.SkateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkateService {

    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getAll() {
        return skateRepository.getAll();
    }

    public Skate get(Integer id) {
        return skateRepository.getSkate(id).get();
    }

    public Optional<Skate> get(int id) {
        return skateRepository.getSkate(id);
    }


    public Skate save(Skate skate) {
        if (skate.getId() == null) {
            return skateRepository.save(skate);
        } else {
            Optional<Skate> m = skateRepository.getSkate(skate.getId());
            if (m.isPresent()) {
                return m.get();
            } else {
                return skateRepository.save(skate);
            }
        }
    }

    public Skate update(Skate skate) {
        if (skate.getId() != null) {
            Optional<Skate> sk = skateRepository.getSkate(skate.getId());
            if (sk.isPresent()) {
                if (skate.getName() != null) {
                    sk.get().setName(skate.getName());
                }
                if (skate.getBrand() != null) {
                    sk.get().setBrand(skate.getBrand());
                }
                if (skate.getYear() != 0) {
                    sk.get().setYear(skate.getYear());
                }
                if (skate.getDescription() != null) {
                    sk.get().setDescription(skate.getDescription());
                }
                if (skate.getCategory() != null) {
                    sk.get().setCategory(skate.getCategory());
                }
                if (skate.getMessages() != null) {
                    sk.get().setMessages(skate.getMessages());
                }
                if (skate.getReservations() != null) {
                    sk.get().setReservations(skate.getReservations());
                }
                skateRepository.save(sk.get());
                return sk.get();
            } else {
                return skate;
            }
        }
        return skate;

    }

    public boolean delete(int id) {
        boolean marca = false;
        Optional<Skate> mt = skateRepository.getSkate(id);
        if (mt.isPresent()) {
            skateRepository.delete(mt.get());
            marca = true;
        }
        return marca;
    }
}