package net.bobgardner.scouts.track.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.VerticalPanel;


/**
 * Entry point for ScoutTrack.
 * 
 * @author bobgardner (Bob Gardner)
 */
public class ScoutTrack implements EntryPoint {
  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final LoginServiceAsync loginService = GWT.create(LoginService.class);

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    TabPanel tabs = new TabPanel();

    VerticalPanel welcome = new VerticalPanel();
    welcome.add(new HTML("<h1>Welcome!</h1>"));
    welcome.add(new HTML("<p>Here you can track your scouting organization.</p>"));
    welcome.add(new HTML("<p>More to come!</p>"));
    tabs.add(welcome, "Welcome");

    RootPanel.get().add(tabs);
    tabs.selectTab(0);
  }
}
