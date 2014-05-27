// Copyright 2009 Bob Gardner. All Rights Reserved.

package net.bobgardner.scouts.track.client;

import java.io.Serializable;

/**
 * Exception for services to throw when the user is not logged in.
 * 
 * @author bobgardner (Bob Gardner)
 */
public class NotLoggedInException extends Exception implements Serializable {

  public NotLoggedInException() {
    // No work to do
  }

  public NotLoggedInException(String message) {
    super(message);
  }

  public NotLoggedInException(Throwable cause) {
    super(cause);
  }

  public NotLoggedInException(String message, Throwable cause) {
    super(message, cause);
  }
}
