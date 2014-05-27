// Copyright 2009 Bob Gardner. All Rights Reserved.

package net.bobgardner.scouts.track.server.model;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import net.bobgardner.scouts.track.client.UnitInfo;
import net.bobgardner.scouts.track.client.PersonInfo.SimplePersonInfo;
import net.bobgardner.scouts.track.client.UnitInfo.SimpleUnitInfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * A Scouting Unit (Troop, Crew, etc).
 * 
 * @author bobgardner (Bob Gardner)
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Unit {
  public enum Type {
    TROOP {
      @Override
      public net.bobgardner.scouts.track.client.UnitInfo.Type toGwtType() {
        return UnitInfo.Type.TROOP;
      }
    },
    TEAM {
      @Override
      public net.bobgardner.scouts.track.client.UnitInfo.Type toGwtType() {
        return UnitInfo.Type.TEAM;
      }
    },
    CREW {
      @Override
      public net.bobgardner.scouts.track.client.UnitInfo.Type toGwtType() {
        return UnitInfo.Type.CREW;
      }
    };

    public abstract UnitInfo.Type toGwtType();

    public static Type fromGwtType(UnitInfo.Type type) {
      switch (type) {
        case CREW:
          return CREW;
        case TEAM:
          return TEAM;
        case TROOP:
          return TROOP;
      }
      throw new AssertionError("You forgot to add a case for type " + type);
    }
  }

  @PrimaryKey
  @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
  private Key key;
  @Persistent
  private Type type;
  @Persistent
  private String number;
  @Persistent
  private Set<Person> leaders;
  @Persistent
  private Set<Person> scouts;

  public Unit(Type type, String number) {
    this.type = type;
    this.number = number;
    this.leaders = new HashSet<Person>();
    this.scouts = new HashSet<Person>();
  }

  public Unit(Type type, String number, Set<Person> leaders, Set<Person> scouts) {
    setType(type);
    setNumber(number);
    setLeaders(leaders);
    setScouts(scouts);
  }

  public Key getKey() {
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

  public void setLeaders(Set<Person> leaders) {
    this.leaders = new HashSet<Person>(leaders);
  }

  public void addLeader(Person leader) {
    leaders.add(leader);
  }

  public void removeLeader(Person leader) {
    leaders.remove(leader);
  }

  public Set<Person> getLeaders() {
    return Collections.unmodifiableSet(leaders);
  }

  public void setScouts(Set<Person> scouts) {
    this.scouts = new HashSet<Person>(scouts);
  }

  public void addScout(Person scout) {
    scouts.add(scout);
  }

  public void removeScout(Person scout) {
    scouts.remove(scout);
  }

  public Set<Person> getScouts() {
    return Collections.unmodifiableSet(scouts);
  }

  public UnitInfo toInfo() {
    Set<SimplePersonInfo> leaderInfos = new HashSet<SimplePersonInfo>();
    for (Person leader : leaders) {
      leaderInfos.add(leader.toSimpleInfo());
    }
    Set<SimplePersonInfo> scoutInfos = new HashSet<SimplePersonInfo>();
    for (Person scout : scouts) {
      scoutInfos.add(scout.toSimpleInfo());
    }
    return new UnitInfo(KeyFactory.keyToString(key), type.toGwtType(), number, leaderInfos,
        scoutInfos);
  }

  public SimpleUnitInfo toSimpleInfo() {
    return new SimpleUnitInfo(KeyFactory.keyToString(key), type.toGwtType(), number);
  }
}
