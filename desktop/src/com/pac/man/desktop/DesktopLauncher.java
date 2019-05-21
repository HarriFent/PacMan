package com.pac.man.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pac.man.Globals;
import com.pac.man.Main;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Globals.WIDTH;
		config.height = Globals.HEIGHT;
		config.title = "PACMAN";
		config.resizable = false;
		new LwjglApplication(new Main(), config);
	}
}
