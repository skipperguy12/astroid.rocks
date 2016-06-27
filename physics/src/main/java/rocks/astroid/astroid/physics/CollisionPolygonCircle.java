package rocks.astroid.astroid.physics;

public class CollisionPolygonCircle implements CollisionCallback 
{

	public static final CollisionPolygonCircle instance = new CollisionPolygonCircle();
	
	@Override
	public void handleCollision(Manifold m, Body a, Body b) 
	{
		CollisionCirclePolygon.instance.handleCollision(m, b, a); 
		
		if ( m.contactCount > 0 )
		{
			m.normal.negi();
		}
	}

}
