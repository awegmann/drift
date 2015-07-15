package de.codeshelf.drift.repositories;

import de.codeshelf.drift.data.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * User: andy
 * Date: 30.06.15
 */
public interface UserRepositoryIF extends PagingAndSortingRepository<User, String> {

  User findByUserName(String username);
}
