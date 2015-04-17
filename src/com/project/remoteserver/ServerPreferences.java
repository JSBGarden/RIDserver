package com.project.remoteserver;

import java.util.prefs.Preferences;

public class ServerPreferences {
	Preferences pref ;
	public ServerPreferences() {
		pref=Preferences.userRoot().node(this.getClass().getName());
		// TODO Auto-generated constructor stub
	}
	
	public void setPassword(String pass){
		pref.put("pass",pass);
	}
	public void setPort(int port){
		pref.putInt("port",port);
	}
	
	
	public String getPassword()	{
		return pref.get("pass","a");
	}
	
	public int getPort()	{
		return pref.getInt("port",8081);
	}
	
	
}
