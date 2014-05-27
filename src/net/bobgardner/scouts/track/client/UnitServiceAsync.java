// Copyright 2009 Bob Gardner. All Rights Reserved.

package net.bobgardner.scouts.track.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import net.bobgardner.scouts.track.client.PersonInfo.SimplePersonInfo;
import net.bobgardner.scouts.track.client.UnitInfo.SimpleUnitInfo;

import java.util.List;

/**
 * Asynchronous interface for {@link UnitService}.
 * 
 * @author bobgardner (Bob Gardner)
 */
public interface UnitServiceAsync {

  /**
   * @see UnitService#addLeader(SimpleUnitInfo, SimplePersonInfo)
   */
  void addLeader(SimpleUnitInfo unit, SimplePersonInfo leader, AsyncCallback<Void> callback);

  /**
   * @see UnitService#addScout(SimpleUnitInfo, SimplePersonInfo)
   */
  void addScout(SimpleUnitInfo unit, SimplePersonInfo scout, AsyncCallback<Void> callback);

  /**
   * @see UnitService#createUnit(SimpleUnitInfo)
   */
  void createUnit(SimpleUnitInfo unit, AsyncCallback<String> callback);

  /**
   * @see UnitService#getUnit(java.lang.String)
   */
  void getUnit(String key, AsyncCallback<UnitInfo> callback);

  /**
   * @see UnitService#getUnits()
   */
  void getUnits(AsyncCallback<List<SimpleUnitInfo>> callback);

  /**
   * @see UnitService#removeLeader(SimpleUnitInfo, SimplePersonInfo)
   */
  void removeLeader(SimpleUnitInfo unit, SimplePersonInfo leader, AsyncCallback<Void> callback);

  /**
   * @see UnitService#removeScout(SimpleUnitInfo, SimplePersonInfo)
   */
  void removeScout(SimpleUnitInfo unit, SimplePersonInfo scout, AsyncCallback<Void> callback);

  /**
   * @see UnitService#updateUnit(SimpleUnitInfo)
   */
  void updateUnit(SimpleUnitInfo unit, AsyncCallback<Void> callback);

}
