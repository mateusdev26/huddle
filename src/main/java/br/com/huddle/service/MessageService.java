package br.com.huddle.service;

import br.com.huddle.domain.Message;
import br.com.huddle.mapper.MessageMapper;
import br.com.huddle.repository.MessageRepository;
import br.com.huddle.request.MessagePostRequestBody;
import br.com.huddle.request.MessagePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public Message findByIdOrThrowBadRequestException(long id) {
        return messageRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.BAD_REQUEST, "Message not found with ID: " + id));
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public void delete(long id) {
        messageRepository.deleteById(id);
    }

    public Message save(MessagePostRequestBody messagePostRequestBody) {
        Message message = MessageMapper.INSTANCE.toMessage(messagePostRequestBody);
        return messageRepository.save(message);
    }

    public List<Message> getMessagesBetweenTwoUsers(long sender_id, long recipient_id) {
        return messageRepository.findBySenderIdAndRecipientIdOrderBySendingTime(sender_id, recipient_id);
    }

    public List<Message> getAllMessagesRead() {
        return messageRepository.findByIsReadTrueOrderBySendingTime();
    }

    public List<Message> getAllMessagesNotRead() {
        return messageRepository.findByIsReadFalseOrderBySendingTime();
    }

    public List<Message> getAllMessagesNotReadBetweenTwoUsers(long senderId, long recipientId) {
        return messageRepository.findBySenderIdAndRecipientIdAndIsReadFalseOrderBySendingTime(senderId, recipientId);
    }

    public List<Message> getAllMessagesReadBetweenTwoUsers(long senderId, long recipientId) {
        return messageRepository.findBySenderIdAndRecipientIdAndIsReadTrueOrderBySendingTime(senderId, recipientId);
    }

    public Message markAsRead(long id) {
        Message message = findByIdOrThrowBadRequestException(id);
        message.setRead(true);
        return messageRepository.save(message);
    }

    public Message updateMessage(long id, MessagePutRequestBody messagePutRequestBody) {
        Message existingMessage = findByIdOrThrowBadRequestException(id);
        existingMessage.setContent(messagePutRequestBody.getContent());
        return messageRepository.save(existingMessage);
    }

    public Message editMessage(long id, String newContent) {
        Message foundById = findByIdOrThrowBadRequestException(id);
        foundById.setContent(newContent);
        messageRepository.deleteById(id);
        return messageRepository.save(foundById);
    }
}