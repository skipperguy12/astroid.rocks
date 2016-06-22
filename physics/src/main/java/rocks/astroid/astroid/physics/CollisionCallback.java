package rocks.astroid.astroid.physics;

public interface CollisionCallback
{

	public void handleCollision( Manifold m, Body a, Body b );
}
