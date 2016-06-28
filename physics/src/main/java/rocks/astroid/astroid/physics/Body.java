package rocks.astroid.astroid.physics;

public class Body
{

	public Vec2 position = new Vec2();
	public Vec2 velocity = new Vec2();
	public Vec2 force = new Vec2();
	public float angularVelocity;
	public float torque;
	public float orient;
	public float mass, invMass, inertia, invInertia;
	public float staticFriction;
	public float dynamicFriction;
	public float restitution;
	public final Shape shape;

	public Body( Shape shape, float x, float y, float orientation)
	{
		this.shape = shape;

		position.set( x, y );
		velocity.set( 0, 0 );
		angularVelocity = 0;
		torque = 0;
		orient = orientation;
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

	public void applyTorque(float torque)
	{
		this.torque+=torque;
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

	public Vec2 getPosition() {
		return position;
	}

	public float getOrient() {
		return orient;
	}

	public Vec2 getVelocity() {
		return velocity;
	}
}
