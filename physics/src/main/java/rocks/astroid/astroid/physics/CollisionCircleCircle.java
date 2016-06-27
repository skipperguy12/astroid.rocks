package rocks.astroid.astroid.physics;

public class CollisionCircleCircle implements CollisionCallback
{

	public static final CollisionCircleCircle instance = new CollisionCircleCircle();

	@Override
	public void handleCollision( Manifold m, Body a, Body b )
	{
		Circle A = (Circle)a.shape;
		Circle B = (Circle)b.shape;

		// Calculate translational vector, which is normal
		// Vec2 normal = b->position - a->position;
		Vec2 normal = b.position.sub( a.position );

		// real dist_sqr = normal.LenSqr( );
		// real radius = A->radius + B->radius;
		float dist_sqr = normal.lengthSq();
		float radius = A.radius + B.radius;

		// Not in contact
		if (dist_sqr >= radius * radius)
		{
			m.contactCount = 0;
			return;
		}

		float distance = (float)StrictMath.sqrt( dist_sqr );

		m.contactCount = 1;

		if (distance == 0.0f)
		{
			// m->penetration = A->radius;
			// m->normal = Vec2( 1, 0 );
			// m->contacts [0] = a->position;
			m.penetration = A.radius;
			m.normal.set( 1.0f, 0.0f );
			m.contacts[0].set( a.position );
		}
		else
		{
			// m->penetration = radius - distance;
			// m->normal = normal / distance; // Faster than using Normalized since
			// we already performed sqrt
			// m->contacts[0] = m->normal * A->radius + a->position;
			m.penetration = radius - distance;
			m.normal.set( normal ).divi( distance );
			m.contacts[0].set( m.normal ).muli( A.radius ).addi( a.position );
		}
	}

}
