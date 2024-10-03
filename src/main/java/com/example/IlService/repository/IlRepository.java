package com.example.IlService.repository;

import com.example.IlService.model.Il;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IlRepository extends MongoRepository<Il, String> {
}
