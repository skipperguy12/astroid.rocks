package rocks.astroid.astroid.physics;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Hashtable;


public class PhysicsScene
{

	public float dt;
	public int iterations;
	public ArrayList<Body> bodies = new ArrayList<Body>();
	//public Hashtable<Integer, Body> bodies = new Hashtable<Integer, Body>(120, .8f);
	public ArrayList<Manifold> contacts = new ArrayList<Manifold>();

	public PhysicsScene( float dt, int iterations )
	{
		this.dt = dt;
		this.iterations = iterations;
	}

	public void step(float dt)
	{
		this.dt = dt;
		// Generate new collision info
		contacts.clear();
		for (int i = 0; i < bodies.size(); ++i)
		{
			Body A = bodies.get( i );

			for (int j = i + 1; j < bodies.size(); ++j)
			{
				Body B = bodies.get( j );

				if (A.invMass == 0 && B.invMass == 0)
				{
					continue;
				}

				Manifold m = new Manifold( A, B );
				m.solve();

				if (m.contactCount > 0)
				{
					contacts.add( m );
				}
			}
		}

		// Integrate forces
		for (int i = 0; i < bodies.size(); ++i)
		{
			integrateForces( bodies.get( i ), dt );
		}

		// Initialize collision
		for (int i = 0; i < contacts.size(); ++i)
		{
			contacts.get( i ).initialize();
		}

		// Solve collisions
		for (int j = 0; j < iterations; ++j)
		{
			for (int i = 0; i < contacts.size(); ++i)
			{
				contacts.get( i ).applyImpulse();
			}
		}

		// Integrate velocities
		for (int i = 0; i < bodies.size(); ++i)
		{
			integrateVelocity( bodies.get( i ), dt );
		}

		// Correct positions
		for (int i = 0; i < contacts.size(); ++i)
		{
			contacts.get( i ).positionalCorrection();
		}

		// Clear all forces
		for (int i = 0; i < bodies.size(); ++i)
		{
			Body b = bodies.get( i );
			b.force.set( 0, 0 );
			b.torque = 0;
		}
	}

	public Body add(Shape shape, float x, float y, float orientation)
	{
		Body b = new Body(shape, x, y, orientation);
		bodies.add(b);
		return b;
	}

	public Body add(Body b)
	{
		bodies.add(b);
		return b;
	}
	public boolean remove(Body b)
	{
		try{
			bodies.remove(b);
		}
		catch (ConcurrentModificationException e) {
			return false;
		}
		return true;
	}

	public void clear()
	{
		contacts.clear();
		bodies.clear();
	}

	// Acceleration
	// F = mA
	// => A = F * 1/m

	// Explicit Euler
	// x += v * dt
	// v += (1/m * F) * dt

	// Semi-Implicit (Symplectic) Euler
	// v += (1/m * F) * dt
	// x += v * dt

	// see http://www.niksula.hut.fi/~hkankaan/Homepages/gravity.html
	public void integrateForces( Body b, float dt )
	{
//		if(b->im == 0.0f)
//			return;
//		b->velocity += (b->force * b->im + gravity) * (dt / 2.0f);
//		b->angularVelocity += b->torque * b->iI * (dt / 2.0f);

		if (b.invMass == 0.0f)
		{
			return;
		}

		float dts = dt * 0.5f;

		b.velocity.addsi( b.force, b.invMass * dts );
		b.velocity.addsi( Globals.GRAVITY, dts );
		b.velocity.addsi(new Vec2(b.velocity.x*Globals.DRAG, b.velocity.y*Globals.DRAG),dts);
		b.angularVelocity += b.torque * b.invInertia * dts;
		b.angularVelocity += b.angularVelocity*Globals.DRAG*.1f;
	}

	public void integrateVelocity( Body b, float dt )
	{
//		if(b->im == 0.0f)
//			return;
//		b->position += b->velocity * dt;
//		b->orient += b->angularVelocity * dt;
//		b->SetOrient( b->orient );
//		IntegrateForces( b, dt );

		if (b.invMass == 0.0f)
		{
			return;
		}

		b.position.addsi( b.velocity, dt );
		b.orient += b.angularVelocity * dt;
		b.setOrient( b.orient );

		integrateForces( b, dt );
	}

}
