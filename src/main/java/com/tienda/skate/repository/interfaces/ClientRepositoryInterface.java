package com.tienda.skate.repository.interfaces;

import com.tienda.skate.model.Client;
import org.springframework.data.repository.CrudRepository;


public interface ClientRepositoryInterface extends CrudRepository<Client, Integer> {
}
