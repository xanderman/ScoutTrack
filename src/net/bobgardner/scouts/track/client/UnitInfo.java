// Copyright 2009 Bob Gardner. All Rights Reserved.

package net.bobgardner.scouts.track.client;

import net.bobgardner.scouts.track.client.PersonInfo.SimplePersonInfo;

import java.util.Set;


/**
 * Client-side, GWT compatible version of
 * {@link net.bobgardner.soucts.track.server.model.Unit}.
 * 
 * @author bobgardner (Bob Gardner)
 */
public class UnitInfo {
  public enum Type {
    TROOP, TEAM, CREW;
  }

  private String key;
  private Type type;
  private String number;
  private Set<SimplePersonInfo> leaders;
  private Set<SimplePersonInfo> scouts;

  public UnitInfo(String key, Type type, String number, Set<SimplePersonInfo> leaders,
      Set<SimplePersonInfo> scouts) {
    this.key = key;
    this.type = type;
    this.number = number;
    this.leaders = leaders;
    this.scouts = scouts;
  }

  public String getKey() {
    return key;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public Type getType() {
    return type;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getNumber() {
    return number;
  }

  public void addLeader(SimplePersonInfo leader) {
    leaders.add(leader);
  }

  public void removeLeader(SimplePersonInfo leader) {
    leaders.remove(leader);
  }

  public Set<SimplePersonInfo> getLeaders() {
    return leaders;
  }

  public void addScout(SimplePersonInfo scout) {
    scouts.add(scout);
  }

  public void removeScout(SimplePersonInfo scout) {
    scouts.remove(scout);
  }

  public Set<SimplePersonInfo> getScouts() {
    return scouts;
  }

  /**
   * Simplified UnitInfo, with enough information to identify the unit and
   * display a link. The simplified info is preferred when possible to reduce
   * transfered data size.
   * 
   * @author bobgardner (Bob Gardner)
   */
  public static class SimpleUnitInfo {
    private String key;
    private Type type;
    private String number;

    public SimpleUnitInfo(String key, Type type, String number) {
      this.key = key;
      this.type = type;
      this.number = number;
    }

    public String getKey() {
      return key;
    }

    public Type getType() {
      return type;
    }

    public String getNumber() {
      return number;
    }
  }
}
