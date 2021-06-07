package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.model.MessageDto;
import com.example.demo.service.MessageServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private MessageServiceImpl messageService;

    MessageController(MessageServiceImpl messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getAllMessages() {
        return messageService.findAll();
    }

    @RequestMapping(path = "/from/{id}", method = RequestMethod.GET)
    public List<Message> getFromMessagesById(@PathVariable Long id) {
        return messageService.findToFromMessage(id, "from");
    }

    @RequestMapping(path = "/to/{id}", method = RequestMethod.GET)
    public List<Message> getToMessagesById(@PathVariable Long id) {
        return messageService.findToFromMessage(id, "to");
    }

    @RequestMapping(method = RequestMethod.POST)
    public Message postMessage(@RequestBody Message message) {
        return messageService.save(message);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Message putMessageById(@PathVariable Long id, @RequestBody Message message) {
        message.setId(id);
        return messageService.save(message);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public MessageDto.Deleted deleteMessageById(@PathVariable Long id) {
        if (messageService.delete(id)) {
            return new MessageDto.Deleted(id);
        } else {
            throw new IllegalArgumentException("존재하지 않는 메시지입니다.");
        }
    }
}
