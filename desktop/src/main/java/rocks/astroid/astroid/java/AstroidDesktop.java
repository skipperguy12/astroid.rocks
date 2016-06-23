package rocks.astroid.astroid.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import rocks.astroid.astroid.core.Main;

public class AstroidDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.vSyncEnabled = true;
		config.title = Main.TITLE + " v" + Main.VERSION;
		//config.useGL30 = true;
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new Main(), config);
	}
}
