package de.codeshelf.drift.repositories;

import de.codeshelf.drift.data.Posting;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * User: andy
 * Date: 18.07.15
 */
public interface PostingRepositoryIF extends MongoRepository<Posting,String> {
}
