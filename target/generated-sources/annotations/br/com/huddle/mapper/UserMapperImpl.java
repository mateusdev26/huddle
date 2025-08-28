package br.com.huddle.mapper;

import br.com.huddle.domain.User;
import br.com.huddle.request.UserPostRequestBody;
import br.com.huddle.request.UserPutRequestBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-28T13:42:50-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Ubuntu)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public User toUser(UserPostRequestBody userPostRequestBody) {
        if ( userPostRequestBody == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( userPostRequestBody.getUsername() );
        user.password( userPostRequestBody.getPassword() );
        user.email( userPostRequestBody.getEmail() );

        return user.build();
    }

    @Override
    public User toUser(UserPutRequestBody userPutRequestBody) {
        if ( userPutRequestBody == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userPutRequestBody.getId() );
        user.username( userPutRequestBody.getUsername() );
        user.password( userPutRequestBody.getPassword() );
        user.email( userPutRequestBody.getEmail() );

        return user.build();
    }
}
