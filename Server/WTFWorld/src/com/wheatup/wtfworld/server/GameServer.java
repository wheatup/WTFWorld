package com.wheatup.wtfworld.server;

import cc.wheatup.server.Server;

public class GameServer {
	
	private static GameCenter gameCenter;
	
	public static void start() {
		gameCenter = new GameCenter();
		Server.start(gameCenter);
	}
	
}
