package rocks.astroid.astroid.html;

import rocks.astroid.astroid.core.Astroid;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class AstroidHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new Astroid();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
