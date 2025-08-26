package br.com.huddle.mapper;

import br.com.huddle.domain.Message;
import br.com.huddle.request.MessagePostRequestBody;
import br.com.huddle.request.MessagePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MessageMapper {
    public static final MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);
    public abstract Message toMessage(MessagePostRequestBody messagePostRequestBody);
    public abstract Message toMessage(MessagePutRequestBody messagePutRequestBody);
}
