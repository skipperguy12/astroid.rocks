package org.magnos.impulse;

public abstract class Shape
{

	public enum Type
	{
		Circle, Poly, Count
	}

	public Body body;
	public float radius;
	public final Mat2 u = new Mat2();

	public Shape()
	{
	}

	public abstract Shape clone();

	public abstract void initialize();

	public abstract void computeMass( float density );

	public abstract void setOrient( float radians );

	public abstract Type getType();

}
