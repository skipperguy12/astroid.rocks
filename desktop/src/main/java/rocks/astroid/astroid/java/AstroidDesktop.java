package rocks.astroid.astroid.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import rocks.astroid.astroid.core.Astroid;

public class AstroidDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.vSyncEnabled = true;
		config.useGL30 = true;
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new Astroid(), config);
	}
}
