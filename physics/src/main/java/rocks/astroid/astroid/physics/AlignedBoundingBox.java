package rocks.astroid.astroid.physics;

import com.badlogic.gdx.math.Vector2;

public class AlignedBoundingBox {

    private Vector2 min;
    private Vector2 max;

    public AlignedBoundingBox(Vector2 min, Vector2 max) {
        this.setMin(min);
        this.setMax(max);
    }

    public boolean didCollide(AlignedBoundingBox abb) {
        if(this.max.x < abb.getMin().x || this.min.x > abb.getMax().x) return false;
        if(this.max.y < abb.getMin().y || this.min.y > abb.getMax().y) return false;
        return true;
    }

    public Vector2 getMin() {
        return min;
    }

    public void setMin(Vector2 min) {
        this.min = min;
    }

    public Vector2 getMax() {
        return max;
    }

    public void setMax(Vector2 max) {
        this.max = max;
    }
}
