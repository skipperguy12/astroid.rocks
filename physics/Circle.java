package org.magnos.impulse;

public class Circle extends Shape
{

	public Circle( float r )
	{
		radius = r;
	}

	@Override
	public Shape clone()
	{
		return new Circle( radius );
	}

	@Override
	public void initialize()
	{
		computeMass( 1.0f );
	}

	@Override
	public void computeMass( float density )
	{
		body.mass = ImpulseMath.PI * radius * radius * density;
		body.invMass = (body.mass != 0.0f) ? 1.0f / body.mass : 0.0f;
		body.inertia = body.mass * radius * radius;
		body.invInertia = (body.inertia != 0.0f) ? 1.0f / body.inertia : 0.0f;
	}

	@Override
	public void setOrient( float radians )
	{
	}

	@Override
	public Type getType()
	{
		return Type.Circle;
	}

}
