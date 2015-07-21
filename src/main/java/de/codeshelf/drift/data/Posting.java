package de.codeshelf.drift.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * User: andy
 * Date: 15.07.15
 */
@Document
public class Posting {

  @Id
  private String id;
  private User creator;
  private String message;
  private Date creationTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  @Override
  public String toString() {
    return "Posting{" +
            "creator=" + creator +
            ", message='" + message + '\'' +
            ", creationTime=" + creationTime +
            '}';
  }
}
