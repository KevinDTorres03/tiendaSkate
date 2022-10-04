package com.tienda.skate.repository.interfaces;

import com.tienda.skate.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepositoryInterface extends CrudRepository<Message, Integer> {
}
