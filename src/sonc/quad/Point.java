package sonc.quad;

/**
 * Representation of a single geometric point
 * 
 * @author Matheus Rosa
 * @version 1.0
 */
public class Point<T> {
	private T x, y;

	public Point(T x, T y) {
		super();
		this.x = x;
		this.y = y;
	}

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}

}
