package rocks.astroid.astroid.physics;

public class Body
{

	public final Vec2 position = new Vec2();
	public final Vec2 velocity = new Vec2();
	public final Vec2 force = new Vec2();
	public float angularVelocity;
	public float torque;
	public float orient;
	public float mass, invMass, inertia, invInertia;
	public float staticFriction;
	public float dynamicFriction;
	public float restitution;
	public final Shape shape;

	public Body( Shape shape, int x, int y )
	{
		this.shape = shape;

		position.set( x, y );
		velocity.set( 0, 0 );
		angularVelocity = 0;
		torque = 0;
		orient = Globals.random( -Globals.PI, Globals.PI );
		force.set( 0, 0 );
		staticFriction = 0.5f;
		dynamicFriction = 0.3f;
		restitution = 0.2f;

		shape.body = this;
		shape.initialize();
	}

	public void applyForce( Vec2 f )
	{
		// force += f;
		force.addi( f );
	}

	public void applyImpulse( Vec2 impulse, Vec2 contactVector )
	{
		// velocity += im * impulse;
		// angularVelocity += iI * Cross( contactVector, impulse );

		velocity.addsi( impulse, invMass );
		angularVelocity += invInertia * Vec2.cross( contactVector, impulse );
	}

	public void setStatic()
	{
		inertia = 0.0f;
		invInertia = 0.0f;
		mass = 0.0f;
		invMass = 0.0f;
	}

	public void setOrient( float radians )
	{
		orient = radians;
		shape.setOrient( radians );
	}

}
