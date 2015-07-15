package de.codeshelf.drift.repositories;

import de.codeshelf.drift.data.User;
import org.apache.commons.collections.IteratorUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * User: andy
 * Date: 29.06.15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserRepositoryTest {

  @Autowired
  public UserRepositoryIF repository;

  @Before
  public void beforeTest() {
    repository.deleteAll();
  }

  @Test
  public void testEmptyRepo() {
    List<User> all = IteratorUtils.toList(repository.findAll().iterator());
    assertEquals("keine Objekte erwartet", 0, all.size());
  }

  @Test
  public void addSomeAndFindAll() {
    repository.save(new User("andy", "Andreas", "Wegmann", "andy@nowhere.de", "1232321"));
    List<User> all = IteratorUtils.toList(repository.findAll().iterator());

    assertEquals("Ein element erwartet", 1, all.size());
  }

  @Test
  public void addSomeAndFindByName() {
    repository.save(new User("alice","Alice","Allon",null,"1232321"));
    repository.save(new User("bob", "Bob", "Balloon", null, "1232321"));

    User carol = repository.findByUserName("Carol");
    assertNull("Kein element erwartet", carol);

    User alice = repository.findByUserName("alice");
    assertEquals("Alice erwartet", "Alice", alice.getFirstName());

    List<User> all = IteratorUtils.toList(repository.findAll().iterator());
    assertEquals("Zwei Elemente erwartet", 2, all.size());
  }
}