// Copyright 2009 Bob Gardner. All Rights Reserved.

package net.bobgardner.scouts.track.client;

import java.util.List;

/**
 * Client-side, GWT compatible version of
 * {@link net.bobgardner.soucts.track.server.model.Achievement}.
 * 
 * @author bobgardner (Bob Gardner)
 */
public class AchievementInfo {
  private String key;
  private String name;
  private List<String> requirements;
  
  public AchievementInfo(String key, String name, List<String> requirements) {
    this.key = key;
    this.name = name;
    this.requirements = requirements;
  }
  
  public String getKey() {
    return key;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getName() {
    return name;
  }
  
  public void addRequirement(String requirement) {
    requirements.add(requirement);
  }
  
  public void removeRequirement(String requirement) {
    requirements.remove(requirement);
  }
  
  public List<String> getRequirements() {
    return requirements;
  }
}
