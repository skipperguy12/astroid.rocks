package rocks.astroid.astroid.physics;

public class Collisions
{

	public static CollisionCallback[][] dispatch =
	{
		{ CollisionCircleCircle.instance, CollisionCirclePolygon.instance },
		{ CollisionPolygonCircle.instance, CollisionPolygonPolygon.instance }
	};

}
