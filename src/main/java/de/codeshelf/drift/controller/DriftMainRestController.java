package de.codeshelf.drift.controller;

import de.codeshelf.drift.data.Drift;
import de.codeshelf.drift.repositories.DriftRepositoryIF;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User: andy
 * Date: 28.06.15
 */
@RestController
@RequestMapping("/drift")
public class DriftMainRestController {

  static Log log = LogFactory.getLog(DriftMainRestController.class.getName());

  @Autowired
  DriftRepositoryIF dataProvider;

  @RequestMapping(method = RequestMethod.GET)
  public List<Drift> getDriftList() {
    log.info("getDriftList called()");

    return dataProvider.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public  Drift createNewDrift(@RequestParam("title") String title) {
    return dataProvider.save(new Drift(title));
  }
}
