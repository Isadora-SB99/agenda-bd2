package com.example.agenda.repository;

import com.example.agenda.model.CompromissoModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompromissoRepository extends MongoRepository<CompromissoModel, String> {
}
