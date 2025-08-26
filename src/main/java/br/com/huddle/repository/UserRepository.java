package br.com.huddle.repository;

import br.com.huddle.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);
}
