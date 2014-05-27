package net.bobgardner.scouts.track.client;

import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * The async counterpart of {@link LoginService}.
 * 
 * @author bobgardner (Bob Gardner)
 */
public interface LoginServiceAsync {
  void login(String requestUri, AsyncCallback<LoginInfo> callback);
}
