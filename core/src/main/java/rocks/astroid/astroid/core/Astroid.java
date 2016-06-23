package rocks.astroid.astroid.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;
import rocks.astroid.astroid.core.client.GlobalFunctions;
import rocks.astroid.astroid.core.logic.weapons.Projectile;
import rocks.astroid.astroid.core.screens.Play;

import java.util.ArrayList;

public class Astroid extends Game {
	public static final String TITLE = "astroid.rocks",
								VERSION = "0.0.1";

	private Texture texture;
	private SpriteBatch batch;
	private Music backgroundMusic;

	@Override
	public void create () {
		setScreen(new Play());
		GlobalFunctions.projectiles = new ArrayList<Projectile>();
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("background.mp3"));
		backgroundMusic.play();
	}

	@Override
	public void resize (int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void pause () {
		super.pause();
	}

	@Override
	public void resume () {
		super.resume();
	}

	@Override
	public void dispose () {
		super.dispose();
		backgroundMusic.dispose();
	}
}
