package de.codeshelf.drift.service.user;

import de.codeshelf.drift.data.User;
import de.codeshelf.drift.repositories.UserRepositoryIF;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoAdmin;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * User: andy
 * Date: 19.07.15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("../test-context.xml")
public class UserServiceTest {

  @Autowired
  UserService userService;

  @Autowired
  UserRepositoryIF userRepository;

  @Before
  public void setUp() throws Exception {
    for (User user : userRepository.findAll()) {
      userRepository.delete(user);
    }
  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testCreateNewUser() throws Exception {
    User newUser=new User("testuser","test","user","test@user.de","1234");
    User createdUser = userService.createNewUser(newUser);

    assert(newUser.equals(createdUser));

  }

  @Test
  public void testCreateNewUserNullCheck() throws Exception {
    try {
      User createdUser = userService.createNewUser(null);
      fail("Exception erwartet");
    } catch (IllegalStateException e) {
      ;
    }


  }

  @Test
  public void testSaveUser() throws Exception {

  }

  @Test
  public void testFindUserByUserName() throws Exception {

  }
}