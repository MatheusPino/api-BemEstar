package com.fiap.bemestar.api.controller;

import com.fiap.bemestar.api.model.User;
import com.fiap.bemestar.api.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private final UserRepository repo;

    public LoginController(UserRepository repo) {
        this.repo = repo;
    }
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody User user) {
        // Busca o usuário no banco
        logger.info("Usuário {} autenticado com sucesso", user.toString());
        Optional<User> userOptional = repo.findByEmailAndSenha(
                user.getEmail(),
                user.getSenha()
        );

        // Se não encontrar, retorna erro
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Credenciais inválidas"));
        }

        // Gera o token: timestamp + id do usuário
        long timestamp = System.currentTimeMillis();
        String token = timestamp + user.getId();

        // Retorna o token
        return ResponseEntity.ok(Map.of(
                "token", token,
                "userId", user.getId(),
                "username", user.getNome()
        ));
    }
}
