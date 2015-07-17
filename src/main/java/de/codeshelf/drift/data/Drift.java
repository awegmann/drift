package de.codeshelf.drift.data;

import com.fasterxml.jackson.annotation.JsonView;
import de.codeshelf.drift.data.views.DriftView;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;



/**
 * User: andy
 * Date: 28.06.15
 */
@Document
public class Drift {

  @Id
  @JsonView(DriftView.Summary.class)
  private String id;

  @JsonView(DriftView.Summary.class)
  private String title;

  @JsonView(DriftView.Summary.class)
  private Date creationDate;

  private List<Posting> postings;

  @Override
  public String toString() {
    return "Drift{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", creationDate=" + creationDate +
            ", postings=" + postings +
            ", creator=" + creator +
            '}';
  }

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }

  @DBRef
  private User creator;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public List<Posting> getPostings() {
    return postings;
  }

  public void setPostings(List<Posting> postings) {
    this.postings = postings;
  }

  public void addPosting(Posting posting) {
    if (postings==null) {
      postings=new LinkedList<>();
    }

    this.postings.add(posting);
  }

  public Drift(String title) {
    this.title = title;
    this.creationDate = new Date();
  }

  public Drift() {
  }

}
