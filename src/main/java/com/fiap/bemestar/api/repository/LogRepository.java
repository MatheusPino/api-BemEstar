package com.fiap.bemestar.api.repository;

import com.fiap.bemestar.api.model.LogEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogEvent, String> {}
