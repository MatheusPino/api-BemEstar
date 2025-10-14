package com.fiap.bemestar.api.repository;

import com.fiap.bemestar.api.model.Tip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TipRepository extends MongoRepository<Tip, String> {

    // Busca a última tip ordenada por ID em ordem decrescente
    @Query(value = "{}", sort = "{ '_id': -1 }")
    Tip findTopByOrderByIdDesc();
}