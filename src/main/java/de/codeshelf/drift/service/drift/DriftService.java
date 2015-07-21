package de.codeshelf.drift.service.drift;

import de.codeshelf.drift.data.Drift;
import de.codeshelf.drift.repositories.DriftRepositoryIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * User: andy
 * Date: 09.07.15
 */
@Controller
public class DriftService {

  @Autowired
  DriftRepositoryIF driftRepository;


  List<Drift> listAllDrifts() {
    return driftRepository.findByCreationDate(sortByCreationDateDesc());
  }


  /**
   * Returns a Sort object which sorts drifts by creation date descending.
   *
   * @return the Sort object
   */
  private Sort sortByCreationDateDesc() {
    return new Sort(Sort.Direction.DESC, "creationDate");
  }
}
