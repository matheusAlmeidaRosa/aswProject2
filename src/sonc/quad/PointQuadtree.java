package sonc.quad;

import java.util.HashSet;
import java.util.Set;

/**
 * This class follows the Facade design pattern and presents a presents a single access point to manage quad trees. 
 * It provides methods for inserting, deleting and finding elements implementing HasPoint. 
 * This class corresponds to the Client in the Composite design pattern used in this package.
 * 
 * @author Matheus Rosa
 *
 * @param <T>
 */
public class PointQuadtree<T extends HasPoint> {
	
	public Trie<T> root;
	
	public PointQuadtree(double topLeftX,
        double topLeftY,
        double bottomRightX,
        double bottomRightY) {
		this.root = new LeafTrie<T>(topLeftX, topLeftY, bottomRightX, bottomRightY);
	}
	
	/**
	 * Delete given point from QuadTree, if it exists there
	 * 
	 * @param point
	 */
	public void delete(T point) {
		this.root.delete(point);
	}
	
	/**
	 * Find a recorded point with the same coordinates of given point
	 * 
	 * @param point
	 * @return
	 */
	public T find(T point) {
		return root.find(point);
	}
	
	/**
	 * Returns a set of points at a distance smaller or equal to radius from point with given coordinates.
	 * 
	 * @param x
	 * @param y
	 * @param radius
	 * @return
	 */
	public Set<T> findNear(double x, double y, double radius) {
		HashSet<T> result = new HashSet<T>();
		root.collectNear(x, y, radius, result);
		return result;
	}
	
	/**
	 * A set with all points in the QuadTree
	 * 
	 * @return
	 */
	public Set<T> getAll() {
		HashSet<T> result = new HashSet<T>();
		root.collectAll(result);
		return result;
	}
	
	/**
	 * Insert given point in the QuadTree
	 * 
	 * @param point
	 */
	public void insert(T point) {
		this.root = root.insert(point);
	}
	
	/**
	 * Insert point, replacing existing point in the same position
	 * 
	 * @param point
	 */
	public void insertReplace(T point) {
		this.root.insertReplace(point);
	}
}
