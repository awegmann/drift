package de.codeshelf.drift.service.user;

import de.codeshelf.drift.data.User;
import de.codeshelf.drift.repositories.UserRepositoryIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service um User zu verwalten. Dazu gehören Neuanlage, Löschen, Suchen, Ändern.
 * User: andy
 * Date: 19.07.15
 */
@Service
@Transactional
public class UserService {

  @Autowired
  UserRepositoryIF userRepository;

  /**
   * Create new User. The values for the new user are taken from the newUser Parameter,
   * checked, if a user with this userName does not already exists. If validity checks
   * are ok, the User object ist saved. The newly created User object is returned.
   *
   * @param newUser the parameter object for creating the new user
   * @return a newly created User object
   * @throws UserAlreadyExistException thrown if a User with that userName already exists.
   */
  User createNewUser(User newUser) throws UserAlreadyExistException {
    if (newUser == null) {
      throw new IllegalStateException("newUser is null");
    }

    // test is user name is already used
    User userByName = userRepository.findByUserName(newUser.getUserName());
    if (userByName != null)
      throw new UserAlreadyExistException();

    User savedUser = userRepository.save(newUser);
    return savedUser;
  }

  /**
   * Save modified User Object. The parameter object is checked if already exists in
   * the database. Further the userName may not be modified.
   *
   * @param modifiedUser modified User object to be saved.y
   */
  void saveUser(User modifiedUser) {
    if (modifiedUser == null)
      throw new IllegalStateException("modifiedUser is null");

    if (modifiedUser.getId() == null) {
      throw new IllegalStateException("user may not be created with modifedUser method.");
    }

    // test is user name is already used
    User userById = userRepository.findOne(modifiedUser.getId());
    if (userById != null && userById.getUserName() != modifiedUser.getUserName())
      throw new IllegalStateException("username may not be modified.");

    userRepository.save(modifiedUser);
  }

  /**
   * Find a user by it's userName.
   *
   * @param userName the username to be searched for.
   * @return the User object found, or null if no corresponding user was found.
   */
  User findUserByUserName(String userName) {
    if (userName == null)
      throw new IllegalStateException("userName is null");

    User user = userRepository.findByUserName(userName);

    return user;
  }
}
