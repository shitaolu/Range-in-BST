package A3Q1;

import java.util.List;

/**
 * Extends the TreeMap class to allow convenient access to entries within a
 * specified range of key values (findAllInRange).
 * 
 * @author jameselder
 */
public class BSTRange<K, V> extends TreeMap<K, V> {

	/*
	 * Returns the lowest (deepest) position in the subtree rooted at pos that
	 * is a common ancestor to positions with keys k1 and k2, or to the
	 * positions they would occupy were they present.
	 */
	protected Position<Entry<K, V>> findLowestCommonAncestor(K k1, K k2, Position<Entry<K, V>> pos) {
		if (pos == null) {
			return null;
		} else {

			if (pos.getElement() != null && compare(k1, pos.getElement().getKey()) <= 0
					&& compare(pos.getElement().getKey(), k2) <= 0) {
				return pos;
			}

			else if (pos.getElement() != null && compare(k1, pos.getElement().getKey()) > 0) {
				return findLowestCommonAncestor(k1, k2, right(pos));
			}

			else if (pos.getElement() != null && compare(pos.getElement().getKey(), k1) > 0
					&& compare(pos.getElement().getKey(), k2) > 0) {
				return findLowestCommonAncestor(k1, k2, left(pos));
			}

			return null;
		}

		// implement this method
	}

	/*
	 * Finds all entries in the subtree rooted at pos with keys of k or greater
	 * and copies them to L, in non-decreasing order.
	 */
	protected void findAllAbove(K k, Position<Entry<K, V>> pos, PositionalList<Entry<K, V>> L) {

		if (pos.getElement() != null) {
			if (this.compare(pos.getElement().getKey(), k) < 0) {
				findAllAbove(k, this.right(pos), L);
			} else {
				findAllAbove(k, this.left(pos), L);
				L.addLast(pos.getElement());
				findAllAbove(k, this.right(pos), L);
			}
		}

	}

	/*
	 * Finds all entries in the subtree rooted at pos with keys of k or less and
	 * copies them to L, in non-decreasing order.
	 */
	protected void findAllBelow(K k, Position<Entry<K, V>> pos, PositionalList<Entry<K, V>> L) {

		if (pos.getElement() != null) {
			if (this.compare(pos.getElement().getKey(), k) > 0) {
				findAllBelow(k, this.left(pos), L);
			} else {
				findAllBelow(k, this.left(pos), L);
				L.addLast(pos.getElement());
				findAllBelow(k, this.right(pos), L);
			}
		}

	}

	/*
	 * Returns all entries with keys no less than k1 and no greater than k2, in
	 * non-decreasing order.
	 */
	public PositionalList<Entry<K, V>> findAllInRange(K k1, K k2) {
		PositionalList<Entry<K, V>> L = new LinkedPositionalList<>();
		if (this.isEmpty()) {
			return L;
		} else if (compare(k1, k2) <= 0) {
			Position<Entry<K, V>> lca = findLowestCommonAncestor(k1, k2, root());
			if (lca != null) {
				findAllAbove(k1, left(lca), L);
				L.addLast(lca.getElement());
				findAllBelow(k2, right(lca), L);
			}
		}
		return L;

		// implement this method
	}
}