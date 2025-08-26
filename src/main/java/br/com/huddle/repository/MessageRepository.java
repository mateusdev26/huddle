package br.com.huddle.repository;

import br.com.huddle.domain.Message;
import br.com.huddle.domain.User;
import br.com.huddle.request.MessagePutRequestBody;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message,Long> {


    List<Message> findBySenderIdAndRecipientIdOrderBySendingTime(Long senderId, Long recipientId);

    List<Message> findByIsReadTrueOrderBySendingTime();

    List<Message> findByIsReadFalseOrderBySendingTime();

    List<Message> findBySenderIdAndRecipientIdAndIsReadTrueOrderBySendingTime(Long senderId, Long recipientId);

    List<Message> findBySenderIdAndRecipientIdAndIsReadFalseOrderBySendingTime(Long senderId, Long recipientId);

    Optional<Message> findById(Long id);

}
