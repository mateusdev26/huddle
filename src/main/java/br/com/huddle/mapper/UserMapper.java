package br.com.huddle.mapper;

import br.com.huddle.domain.User;
import br.com.huddle.request.UserPostRequestBody;
import br.com.huddle.request.UserPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    public abstract User toUser(UserPostRequestBody userPostRequestBody);
    public abstract User toUser(UserPutRequestBody userPutRequestBody);
}
