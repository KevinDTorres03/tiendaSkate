package com.tienda.skate.services;

import com.tienda.skate.model.Message;
import com.tienda.skate.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> listAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> get(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == 0) {
            return messageRepository.save(message);
        } else {
            Optional<Message> m = messageRepository.getMessage(message.getIdMessage());
            if (m.isPresent()) {
                return m.get();
            } else {
                return messageRepository.save(message);
            }
        }
    }

    public MessageService() {
    }

    public Message Update(Message message) {
        if (message.getIdMessage() != 0) {
            Optional<Message> ms = messageRepository.getMessage(message.getIdMessage());
            if (ms.isPresent()) {
                if (message.getMessageText() != null) {
                    ms.get().setMessageText(message.getMessageText());
                }
                if (message.getSkate() != null) {
                    ms.get().setSkate(message.getSkate());
                }
                if (message.getClient() != null) {
                    ms.get().setClient(message.getClient());
                }
                messageRepository.save(ms.get());
                return ms.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean delete(int id) {
        boolean marca = false;
        Optional<Message> m = messageRepository.getMessage(id);
        if (m.isPresent()) {
            messageRepository.delete(m.get());
            marca = true;
        }
        return marca;
    }
}
