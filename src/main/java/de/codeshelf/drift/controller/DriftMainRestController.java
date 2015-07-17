package de.codeshelf.drift.controller;

import com.fasterxml.jackson.annotation.JsonView;
import de.codeshelf.drift.data.Drift;
import de.codeshelf.drift.data.Posting;
import de.codeshelf.drift.data.views.DriftView;
import de.codeshelf.drift.repositories.DriftRepositoryIF;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.search.facet.FacetExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
  @JsonView(DriftView.Summary.class)
  public List<Drift> getDriftList() {
    log.info("getDriftList called()");

    return IteratorUtils.toList(dataProvider.findAll().iterator());
  }

  /**
   * List all postings for a Drift.
   * @param driftId
   * @return
   */
  @RequestMapping(value = "{driftId}/posting", method = RequestMethod.GET)
  public List<Posting> getPostingsForDrift(@PathVariable String driftId) {
    Drift drift = dataProvider.findOne(driftId);
    return drift.getPostings();
  }

  /**
   * post new message on a Drift.
   * @param driftId
   * @return
   */
  @RequestMapping(value = "{driftId}/posting", method = RequestMethod.POST)
  public Posting getPostingsForDrift(@PathVariable String driftId, @RequestBody Posting posting) {
    Drift drift = dataProvider.findOne(driftId);
    if (posting.getCreationTime()==null) {
      posting.setCreationTime(new Date());
    }
    drift.addPosting(posting);
    dataProvider.save(drift);
    return posting;
  }


  @RequestMapping(method = RequestMethod.POST)
  public  Drift createNewDrift(@RequestParam("title") String title) {
    return dataProvider.save(new Drift(title));
  }
}
