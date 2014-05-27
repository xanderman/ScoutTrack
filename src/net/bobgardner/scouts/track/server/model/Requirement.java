// Copyright 2009 Bob Gardner. All Rights Reserved.

package net.bobgardner.scouts.track.server.model;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * A requirement that must be completed to acquire an {@link Achievement}
 * 
 * @author bobgardner (Bob Gardner)
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Requirement {
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Key key;
  @Persistent
  private String description;

  public Requirement(String description) {
    setDescription(description);
  }

  public Key getKey() {
    return key;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
