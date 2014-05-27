// Copyright 2009 Bob Gardner. All Rights Reserved.

package net.bobgardner.scouts.track.server;

import com.google.appengine.api.datastore.KeyFactory;

import net.bobgardner.scouts.track.client.UnitInfo;
import net.bobgardner.scouts.track.client.UnitService;
import net.bobgardner.scouts.track.client.PersonInfo.SimplePersonInfo;
import net.bobgardner.scouts.track.client.UnitInfo.SimpleUnitInfo;
import net.bobgardner.scouts.track.server.model.Unit;
import net.bobgardner.scouts.track.server.model.Unit.Type;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

/**
 * The server side implementation of the unit RPC service.
 * 
 * @author bobgardner (Bob Gardner)
 */
public class UnitServiceImpl implements UnitService {
  private static final PersistenceManagerFactory PMF =
      JDOHelper.getPersistenceManagerFactory("transactions-optional");

  private PersistenceManager getPersistenceManager() {
    return PMF.getPersistenceManager();
  }

  public void addLeader(SimpleUnitInfo unit, SimplePersonInfo leader) {
    // TODO Auto-generated method stub

  }

  @Override
  public void addScout(SimpleUnitInfo unit, SimplePersonInfo scout) {
    // TODO Auto-generated method stub

  }

  @Override
  public String createUnit(SimpleUnitInfo unit) {
    PersistenceManager pm = getPersistenceManager();
    Unit newUnit = new Unit(Type.fromGwtType(unit.getType()), unit.getNumber());
    try {
      newUnit = pm.makePersistent(newUnit);
      return KeyFactory.keyToString(newUnit.getKey());
    } finally {
      pm.close();
    }
  }

  @Override
  public UnitInfo getUnit(String key) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<SimpleUnitInfo> getUnits() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void removeLeader(SimpleUnitInfo unit, SimplePersonInfo leader) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeScout(SimpleUnitInfo unit, SimplePersonInfo scout) {
    // TODO Auto-generated method stub

  }

  @Override
  public void updateUnit(SimpleUnitInfo unit) {
    // TODO Auto-generated method stub

  }
}
