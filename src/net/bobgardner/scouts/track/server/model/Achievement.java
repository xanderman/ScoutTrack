// Copyright 2009 Bob Gardner. All Rights Reserved.

package net.bobgardner.scouts.track.server.model;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import net.bobgardner.scouts.track.client.AchievementInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * An achievement that a {@link Person} can earn.
 * 
 * @author bobgardner (Bob Gardner)
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Achievement {
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Key key;
  @Persistent
  private String name;
  @Persistent
  private List<Requirement> requirements;

  public Achievement(String name) {
    setName(name);
    requirements = new ArrayList<Requirement>();
  }

  public Achievement(String name, List<Requirement> requirements) {
    setName(name);
    setRequirements(requirements);
  }

  public Key getKey() {
    return key;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setRequirements(List<Requirement> requirements) {
    this.requirements = new ArrayList<Requirement>(requirements);
  }

  public void addRequirement(Requirement requirement) {
    requirements.add(requirement);
  }

  public void removeRequirement(Requirement requirement) {
    requirements.remove(requirement);
  }

  public List<Requirement> getRequirements() {
    return Collections.unmodifiableList(requirements);
  }

  public AchievementInfo toInfo() {
    List<String> reqs = new ArrayList<String>();
    for (Requirement req : requirements) {
      reqs.add(req.getDescription());
    }
    return new AchievementInfo(KeyFactory.keyToString(key), name, reqs);
  }
}
