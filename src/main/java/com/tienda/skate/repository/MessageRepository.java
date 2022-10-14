package com.tienda.skate.repository;

import com.tienda.skate.model.Message;
import com.tienda.skate.repository.interfaces.MessageRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageRepositoryInterface messageRepositoryInterface;

    public MessageRepository() {
    }

    public List<Message> getAll(){
        return (List<Message>) messageRepositoryInterface.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepositoryInterface.findById(id);
    }
    public Message save(Message message){
        return messageRepositoryInterface.save(message);
    }
    public void delete(Message message){
        messageRepositoryInterface.delete(message);
    }
}
