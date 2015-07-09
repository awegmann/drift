package de.codeshelf.drift.repositories;

import de.codeshelf.drift.repositories.codeshelf.drift.data.Drift;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * User: andy
 * Date: 29.06.15
 */
public interface DriftRepositoryIF extends MongoRepository<Drift, String> {

  List<Drift> findByTitle(String title);

}
