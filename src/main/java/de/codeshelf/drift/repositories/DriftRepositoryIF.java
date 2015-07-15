package de.codeshelf.drift.repositories;

import de.codeshelf.drift.data.Drift;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * User: andy
 * Date: 29.06.15
 */
public interface DriftRepositoryIF extends PagingAndSortingRepository<Drift, String> {

  List<Drift> findByTitle(String title);

  List<Drift> findByCreationDate(Sort orders);
}
