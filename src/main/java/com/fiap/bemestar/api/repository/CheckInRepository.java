package com.fiap.bemestar.api.repository;

import com.fiap.bemestar.api.model.CheckIn;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CheckInRepository extends MongoRepository<CheckIn, String> {
    List<CheckIn> findByUserIdOrderByCreatedAtDesc(String userId);
}
