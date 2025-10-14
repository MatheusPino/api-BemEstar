package com.fiap.bemestar.api.repository;

import com.fiap.bemestar.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmailAndSenha(String email, String senha);
}
