package br.com.huddle.service;

import br.com.huddle.domain.User;
import br.com.huddle.mapper.UserMapper;
import br.com.huddle.repository.UserRepository;
import br.com.huddle.request.UserPostRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository ;
    public User findByIdOrThrowBadRequestException(long id){
        return findAll().
                stream().
                filter(user -> user.getId().equals(id)).
                findFirst().
                orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"No users found"));

    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public void delete (long id){
      userRepository.deleteById(id);
    }
    public User save(UserPostRequestBody userPostRequestBody){
        User user = UserMapper.INSTANCE.toUser(userPostRequestBody);
       return userRepository.save(user);
    }

    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }
}
