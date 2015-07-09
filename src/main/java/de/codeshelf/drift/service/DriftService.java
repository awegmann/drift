package de.codeshelf.drift.repositories.codeshelf.drift.service;

import de.codeshelf.drift.repositories.DriftRepositoryIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * User: andy
 * Date: 09.07.15
 */
@Controller
public class DriftService {

  @Autowired
  DriftRepositoryIF driftRepository;



}
