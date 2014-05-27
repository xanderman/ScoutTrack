// Copyright 2009 Bob Gardner. All Rights Reserved.

package net.bobgardner.scouts.track.client;

import java.util.Date;
import java.util.Map;
import java.util.Set;


/**
 * Client-side, GWT compatible version of
 * {@link net.bobgardner.soucts.track.server.model.Person}.
 * 
 * @author bobgardner (Bob Gardner)
 */
public class PersonInfo {
  private final String key;
  private String firstName;
  private String lastName;
  private String streetAddress;
  private String city;
  private String state;
  private String zipCode;
  private String phone;
  private String email;
  private Map<AchievementInfo, Date> earned;
  private Set<AchievementInfo> inProgress;

  public PersonInfo(String key, String firstName, String lastName, String streetAddress,
      String city, String state, String zipCode, String phone, String email,
      Map<AchievementInfo, Date> earned, Set<AchievementInfo> inProgress) {
    this.key = key;
    this.firstName = firstName;
    this.lastName = lastName;
    this.streetAddress = streetAddress;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    this.phone = phone;
    this.email = email;
    this.earned = earned;
    this.inProgress = inProgress;
  }

  public String getKey() {
    return key;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCity() {
    return city;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPhone() {
    return phone;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setEarned(Map<AchievementInfo, Date> earned) {
    this.earned = earned;
  }

  public Map<AchievementInfo, Date> getEarned() {
    return earned;
  }

  public void setInProgress(Set<AchievementInfo> inProgress) {
    this.inProgress = inProgress;
  }

  public Set<AchievementInfo> getInProgress() {
    return inProgress;
  }

  /**
   * Simplified PersonInfo, holding only what is needed to display a list of
   * names and link them to the actual PersonInfo. This should be used in a
   * collection instead of a PersonInfo when possible in order to keep data size
   * down.
   * 
   * @author bobgardner (Bob Gardner)
   */
  public static class SimplePersonInfo {
    private final String key;
    private final String name;

    public SimplePersonInfo(String key, String name) {
      this.key = key;
      this.name = name;
    }

    public String getKey() {
      return key;
    }

    public String getName() {
      return name;
    }
  }
}
