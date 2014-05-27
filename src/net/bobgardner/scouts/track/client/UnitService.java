// Copyright 2009 Bob Gardner. All Rights Reserved.

package net.bobgardner.scouts.track.client;

import com.google.gwt.user.client.rpc.RemoteService;

import net.bobgardner.scouts.track.client.PersonInfo.SimplePersonInfo;
import net.bobgardner.scouts.track.client.UnitInfo.SimpleUnitInfo;

import java.util.List;

/**
 * Service for interacting with Units in a general sense.
 * 
 * @author bobgardner (Bob Gardner)
 */
public interface UnitService extends RemoteService {
  /**
   * Get a list of all known units.
   * 
   * @return a list of {@link SimpleUnitInfo}
   */
  public List<SimpleUnitInfo> getUnits();

  /**
   * Get the detailed info for a specific unit.
   * 
   * @param key the unit's key
   * 
   * @return the unit's info
   */
  public UnitInfo getUnit(String key);

  /**
   * Create a new unit with the given info.
   * 
   * @param unit the unit to create
   * @return the new unit's key
   */
  public String createUnit(SimpleUnitInfo unit);

  /**
   * Save changes to the given unit. This only saves type/number. To change the
   * roster, use the appropriate add/remove methods.
   * 
   * @param unit the unit to update
   */
  public void updateUnit(SimpleUnitInfo unit);

  /**
   * Add a leader to this unit's roster.
   * 
   * @param leader the leader to add (only the key need be set)
   */
  public void addLeader(SimpleUnitInfo unit, SimplePersonInfo leader);

  /**
   * Remove a leader from this unit's roster.
   * 
   * @param leader the leader to remove (only the key need be set)
   */
  public void removeLeader(SimpleUnitInfo unit, SimplePersonInfo leader);

  /**
   * Add a scout to this unit's roster.
   * 
   * @param scout the scout to add (only the key need be set)
   */
  public void addScout(SimpleUnitInfo unit, SimplePersonInfo scout);

  /**
   * Remove a scout from this unit's roster.
   * 
   * @param scout the scout to remove (only the key need be set)
   */
  public void removeScout(SimpleUnitInfo unit, SimplePersonInfo scout);
}
