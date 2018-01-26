package com.wheatup.wtfworld.server;

import java.util.Map;

import cc.wheatup.server.MessageCenter;
import cc.wheatup.server.Pack;
import cc.wheatup.server.User;

public class GameCenter extends MessageCenter{

	@Override
	public void onUserConnected(User user) {
		System.out.println("User connected!");
	}

	@Override
	public void onUserDisconnected(User user) {
		System.out.println("User disconnected!");
	}

	@Override
	public void handleMessage(User user, String type, Map<String, Object> map) {
		System.out.println(type);
		if("$MESSAGE".equals(type)){
			user.send(Pack.buildKVPack("$MESSAGE", "text", "你好啊，你刚说了：" + map.get("text")));
		}
	}

}
