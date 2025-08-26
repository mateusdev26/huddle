package br.com.huddle.mapper;

import br.com.huddle.domain.Message;
import br.com.huddle.request.MessagePostRequestBody;
import br.com.huddle.request.MessagePutRequestBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-24T16:39:13-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Ubuntu)"
)
@Component
public class MessageMapperImpl extends MessageMapper {

    @Override
    public Message toMessage(MessagePostRequestBody messagePostRequestBody) {
        if ( messagePostRequestBody == null ) {
            return null;
        }

        Message.MessageBuilder message = Message.builder();

        message.content( messagePostRequestBody.getContent() );
        message.senderId( messagePostRequestBody.getSenderId() );
        message.recipientId( messagePostRequestBody.getRecipientId() );
        message.sendingTime( messagePostRequestBody.getSendingTime() );

        return message.build();
    }

    @Override
    public Message toMessage(MessagePutRequestBody messagePutRequestBody) {
        if ( messagePutRequestBody == null ) {
            return null;
        }

        Message.MessageBuilder message = Message.builder();

        message.id( messagePutRequestBody.getId() );
        message.content( messagePutRequestBody.getContent() );
        message.senderId( messagePutRequestBody.getSenderId() );
        message.recipientId( messagePutRequestBody.getRecipientId() );
        message.sendingTime( messagePutRequestBody.getSendingTime() );

        return message.build();
    }
}
