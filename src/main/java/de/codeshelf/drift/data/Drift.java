package de.codeshelf.drift.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * User: andy
 * Date: 28.06.15
 */
@Document
public class Drift {

  @Id
  private String id;
  private String title;
  private Date creationDate;

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

  public Drift(String title) {
    this.title = title;
  }

  public Drift() {
  }

  @Override
  public String toString() {
    return "Drift{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", creationDate=" + creationDate +
            ", creator=" + creator +
            '}';
  }

}
