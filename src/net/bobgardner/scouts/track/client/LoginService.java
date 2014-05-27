package net.bobgardner.scouts.track.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


/**
 * The client side stub for the login RPC service.
 * 
 * @author bobgardner (Bob Gardner)
 */
@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
  /**
   * Gets the {@link LoginInfo} for the current user. If the user is not logged
   * in, the loginUrl will be set.
   * 
   * @param requestUri the URI to forward the user to after login/logout
   * @return the current user's {@link LoginInfo}
   */
  LoginInfo login(String requestUri);
}
