package sortedPolymorphicLinkedList;

public class NonEmptyList<K extends Comparable<K>> implements List<K> {
	
	private K key;
	private List<K> rest;
	
	public NonEmptyList(K key, List<K> rest) {
		this.key = key;
		this.rest = rest;
	}

	public boolean contains(K key) {
		int result = key.compareTo(this.key);
		if (result == 0) {
			return true;
		} else  if (result > 0) {
			return rest.contains(key);
		} else {
			return false;
		}
	}

	public NonEmptyList<K> insert(K key) {
		int result = key.compareTo(this.key);	
		if (result == 0) {
			return this;
		} else if (result > 0) { 
			rest = rest.insert(key);  /* Notice that you need to assign to rest */
			return this;
		} else {
			return new NonEmptyList<K>(key, this);
		}
	}

	public List<K> remove(K key) {
		int result = key.compareTo(this.key);
		if (result == 0) {
			return rest;
		} else if (result > 0) {
			rest = rest.remove(key);
			return this;
		} else {
			return this;
		}
	}

	public K max() {
		try {
			return rest.max();
		} catch (ListIsEmptyException e) {
			return key;
		}
	}
	
	public K min() {
		return key;
	}
	
	public String toString() {
		return key + "|" + rest;
	}
}