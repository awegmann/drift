package de.codeshelf.drift.repositories;

import de.codeshelf.drift.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * User: andy
 * Date: 30.06.15
 */
public interface UserRepositoryIF extends MongoRepository<User, String> {

  User findByUserName(String username);
}
