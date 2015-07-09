package de.codeshelf.drift.repositories;

import de.codeshelf.drift.repositories.codeshelf.drift.data.Drift;
import de.codeshelf.drift.repositories.codeshelf.drift.data.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * User: andy
 * Date: 29.06.15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DriftRepositoryTest {

  @Autowired
  public DriftRepositoryIF driftRepository;

  @Autowired
  public UserRepositoryIF  userRepository;

  @Before
  public void beforeTest() {
    driftRepository.deleteAll();
    userRepository.deleteAll();
  }

  @Test
  public void testEmptyRepo() {
    List<Drift> all = driftRepository.findAll();
    assertEquals("keine Objekte erwartet", 0, all.size());
  }

  @Test
  public void addSomeAndFindAll() {
    driftRepository.save(new Drift("Alice 3"));
    List<Drift> all = driftRepository.findAll();

    assertEquals("Ein element erwartet", 1, all.size());
  }

  @Test
  public void addSomeAndFindByName() {
    driftRepository.save(new Drift("Alice 2"));
    driftRepository.save(new Drift("Bob"));
    driftRepository.save(new Drift("Carol"));
    driftRepository.save(new Drift("Dave"));

    List<Drift> carol = driftRepository.findByTitle("Carol");
    assertEquals("Ein element erwartet", 1, carol.size());

    List<Drift> alice = driftRepository.findByTitle("Alice 2");
    assertEquals("Ein element erwartet", 1, alice.size());

    List<Drift> all = driftRepository.findAll();
    assertEquals("Vier Elemente erwartet", 4, all.size());
  }

  @Test
  public void connectDriftToUser() {
    User user = new User("charlie", "Charlie", "Brown", null, null);
    userRepository.save(user);

    Drift drift = new Drift("Charlies Drift");
    drift.setCreator(user);

    driftRepository.save(drift);

    List<Drift> driftList = driftRepository.findByTitle("Charlies Drift");
    Drift loadedDrift = driftList.get(0);
    assertEquals("charlie", loadedDrift.getCreator().getUserName());
    assertFalse(drift == loadedDrift);
    drift.setTitle("new Title");
    assertTrue(drift.getTitle() != loadedDrift.getTitle());

    driftRepository.save(drift);
  }
}