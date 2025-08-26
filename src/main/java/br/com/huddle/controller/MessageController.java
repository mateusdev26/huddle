package br.com.huddle.controller;

import br.com.huddle.domain.Message;
import br.com.huddle.request.MessagePostRequestBody;
import br.com.huddle.request.MessagePutRequestBody;
import br.com.huddle.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("huddle/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping
    public ResponseEntity<List<Message>> findAll() {
        return ResponseEntity.ok(messageService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Message> findById(@PathVariable long id) {
        return ResponseEntity.ok(messageService.findByIdOrThrowBadRequestException(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        messageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody MessagePostRequestBody messagePostRequestBody) {
        return new ResponseEntity<>(messageService.save(messagePostRequestBody), HttpStatus.CREATED);
    }

    @GetMapping("/getMessagesBetweenTwoUsers")
    public ResponseEntity<List<Message>> getMessagesBetweenTowUsers(@RequestParam long sender_id, @RequestParam long recipient_id) {
        return ResponseEntity.ok(messageService.getMessagesBetweenTwoUsers(sender_id, recipient_id));
    }

    @GetMapping("/getNotRead")
    public ResponseEntity<List<Message>> getNotRead() {
        return ResponseEntity.ok(messageService.findAll()
                .stream()
                .filter(m -> !m.isRead())
                .toList());
    }

    @GetMapping("/getRead")
    public ResponseEntity<List<Message>> getRead() {
        return ResponseEntity.ok(messageService.getAllMessagesRead());
    }

    @GetMapping("getNotReadBetweenTwoUsers")
    public ResponseEntity<List<Message>> getAllMessagesNotReadBetweenTwoUsers(@RequestParam long sender_id, @RequestParam long recipient_id) {
        return ResponseEntity.ok(messageService.getAllMessagesNotReadBetweenTwoUsers(sender_id, recipient_id));
    }

    @GetMapping("getReadBetweenTwoUsers")
    public ResponseEntity<List<Message>> getAllMessagesReadBetweenTwoUsers(@RequestParam long sender_id, @RequestParam long recipient_id) {
        return ResponseEntity.ok(messageService.getAllMessagesReadBetweenTwoUsers(sender_id, recipient_id));
    }

    @PatchMapping("/{id}/markAsRead")
    public ResponseEntity<Message> markAsRead(@PathVariable long id) {
        return ResponseEntity.ok(messageService.markAsRead(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable long id, @RequestBody MessagePutRequestBody messagePutRequestBody) {
        return ResponseEntity.ok(messageService.updateMessage(id, messagePutRequestBody));
    }
    @PutMapping("/edit")
    public ResponseEntity<Message> editMessage(@RequestParam long id,@RequestParam String newContent){
        return ResponseEntity.ok(messageService.editMessage(id,newContent));
    }

}
