// Copyright 2009 Bob Gardner. All Rights Reserved.

package net.bobgardner.scouts.track.server.model;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import net.bobgardner.scouts.track.client.AchievementInfo;
import net.bobgardner.scouts.track.client.PersonInfo;
import net.bobgardner.scouts.track.client.PersonInfo.SimplePersonInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * A person is attached to a {@link Unit} and can earn {@link Achievement}s.
 * 
 * @author bobgardner (Bob Gardner)
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Person {
  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Key key;
  @Persistent
  private ContactInfo info;
  @Persistent
  private Map<Achievement, Date> earned;
  @Persistent
  private Map<Achievement, List<Requirement>> inProgress;

  public Person(ContactInfo info) {
    this.info = info;
    this.earned = new HashMap<Achievement, Date>();
    this.inProgress = new HashMap<Achievement, List<Requirement>>();
  }

  public Person(ContactInfo info, Map<Achievement, Date> earned,
      Map<Achievement, List<Requirement>> inProgress) {
    setInfo(info);
    setEarned(earned);
    setInProgress(inProgress);
  }

  public Key getKey() {
    return key;
  }

  public void setInfo(ContactInfo info) {
    this.info = info;
  }

  public ContactInfo getInfo() {
    return info;
  }

  public void setEarned(Map<Achievement, Date> earned) {
    this.earned = new HashMap<Achievement, Date>(earned);
  }

  public void addEarned(Achievement achievement, Date date) {
    earned.put(achievement, date);
  }

  public void removeEarned(Achievement achievement) {
    earned.remove(achievement);
  }

  public Map<Achievement, Date> getEarned() {
    return Collections.unmodifiableMap(earned);
  }

  public void setInProgress(Map<Achievement, List<Requirement>> inProgress) {
    this.inProgress = new HashMap<Achievement, List<Requirement>>(inProgress);
  }

  public void addInProgress(Achievement achievement) {
    inProgress.put(achievement, new ArrayList<Requirement>());
  }

  public void removeInProgress(Achievement achievement) {
    inProgress.remove(achievement);
  }

  public void addCompletedRequirement(Achievement achievement, Requirement requirement) {
    inProgress.get(achievement).add(requirement);
  }

  public Map<Achievement, List<Requirement>> getInProgress() {
    return Collections.unmodifiableMap(inProgress);
  }

  public PersonInfo toInfo() {
    Map<AchievementInfo, Date> earnedInfo = new HashMap<AchievementInfo, Date>();
    for (Map.Entry<Achievement, Date> entry : earned.entrySet()) {
      earnedInfo.put(entry.getKey().toInfo(), entry.getValue());
    }
    Set<AchievementInfo> inProgressInfo = new HashSet<AchievementInfo>();
    for (Achievement achievement : inProgress.keySet()) {
      inProgressInfo.add(achievement.toInfo());
    }
    return new PersonInfo(KeyFactory.keyToString(key), info.getFirstName(), info.getLastName(),
        info.getStreetAddress(), info.getCity(), info.getState(), info.getZipCode(), info
            .getPhone(), info.getEmail(), earnedInfo, inProgressInfo);
  }

  public SimplePersonInfo toSimpleInfo() {
    return new SimplePersonInfo(KeyFactory.keyToString(key), info.getFullName());
  }
}
