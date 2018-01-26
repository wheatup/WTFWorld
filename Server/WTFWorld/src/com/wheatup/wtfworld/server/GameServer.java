package com.wheatup.wtfworld.server;

import cc.wheatup.server.Server;

public class GameServer {
	
	private static GameCenter gameCenter;
	
	public static void start() {
		if(Server.isRunning()) return;
		gameCenter = new GameCenter();
		Server.start(gameCenter);
	}
	
	public static void stop() {
		if(!Server.isRunning()) return;
		Server.stop();
	}
	
}
