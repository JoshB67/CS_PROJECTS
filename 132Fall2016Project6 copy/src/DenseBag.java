import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * <P>
 * The DenseBag class implements a Set-like collection that allows duplicates (a
 * lot of them).
 * </P>
 * <P>
 * The DenseBag class provides Bag semantics: it represents a collection with
 * duplicates. The "Dense" part of the class name comes from the fact that the
 * class needs to efficiently handle the case where the bag contains 100,000,000
 * copies of a particular item (e.g., don't store 100,000,000 references to the
 * item).
 * </P>
 * <P>
 * In a Bag, removing an item removes a single instance of the item. For
 * example, a Bag b could contain additional instances of the String "a" even
 * after calling b.remove("a").
 * </P>
 * <P>
 * The iterator for a dense bag must iterate over all instances, including
 * duplicates. In other words, if a bag contains 5 instances of the String "a",
 * an iterator will generate the String "a" 5 times.
 * </P>
 * <P>
 * In addition to the methods defined in the Collection interface, the DenseBag
 * class supports several additional methods: uniqueElements, getCount, and
 * choose.
 * </P>
 * <P>
 * The class extends AbstractCollection in order to get implementations of
 * addAll, removeAll, retainAll and containsAll.  (We will not be over-riding those).
 * All other methods defined in
 * the Collection interface will be implemented here.
 * </P>
 */
public class DenseBag<T> extends AbstractCollection<T> implements Serializable {


	private int size;
	private Map<T, Integer> denseMap;
	private int modCount = 0;


	/* Leave this here!  (We need it for our testing) */
	private static final long serialVersionUID = 1L;


	/* Create whatever instance variables you think are good choices */



	/**
	 * Initialize a new, empty DenseBag
	 */
	public DenseBag() {

		denseMap = new HashMap<T, Integer>();
		size = 0;

	}


	public int getModCount() {
		return this.modCount;
	}


	/**
	 * Adds an instance of o to the Bag
	 * 
	 * @return always returns true, since added an element to a bag always
	 *         changes it
	 * 
	 */
	@Override
	public boolean add(T o) {

		if (denseMap.get(o) != null) {
			denseMap.put(o, denseMap.get(o) + 1);
			size++;
			modCount++;
		} else {
			denseMap.put(o, 1);
			size++;
			modCount++;
		}

		return true;

	}


	/**
	 * Adds multiple instances of o to the Bag.  If count is 
	 * less than 0 or count is greater than 1 billion, throws
	 * an IllegalArgumentException.
	 * 
	 * @param o the element to add
	 * @param count the number of instances of o to add
	 * @return true, since addMany always modifies
	 * the DenseBag.
	 */
	public boolean addMany(T o, int count) {

		if(count < 0 || count > 1000000000) {
			throw new IllegalArgumentException();
		}
		if (denseMap.get(o) != null) {
			denseMap.put(o, denseMap.get(o) + count);
			size+=count;
			modCount++;
		} else {
			denseMap.put(o, count);
			size+=count;
			modCount++;
		}

		return true;

	}


	/**
	 * Generate a String representation of the DenseBag. This will be useful for
	 * your own debugging purposes, but will not be tested other than to ensure that
	 * it does return a String and that two different DenseBags return two
	 * different Strings.
	 */
	@Override
	public String toString() {

		String stringRepresentation = " ";

		for(Map.Entry<T, Integer> entry : this.denseMap.entrySet()){
			stringRepresentation += entry.toString() + " " + denseMap.get(entry);
		}

		return stringRepresentation;

	}


	/**
	 * Tests if two DenseBags are equal. Two DenseBags are considered equal if they
	 * contain the same number of copies of the same elements.
	 * Comparing a DenseBag to an instance of
	 * any other class should return false;
	 */
	@Override
	public boolean equals(Object o) {

		if (o == this) {
			return true;
		}
		if (!(o instanceof DenseBag)) {
			return false;
		}
		DenseBag<T> bag = (DenseBag<T>) o;
		return size == bag.size;

	}


	/**
	 * Return a hashCode that fulfills the requirements for hashCode (such as
	 * any two equal DenseBags must have the same hashCode) as well as desired
	 * properties (two unequal DenseBags will generally, but not always, have
	 * unequal hashCodes).
	 */
	@Override
	public int hashCode() {

		int hashValue = 0;

		for (T current : denseMap.keySet()) {
			hashValue = hashValue+current.hashCode()*denseMap.get(current);
		}

		return hashValue;

	}


	/**
	 * <P>
	 * Returns an iterator over the elements in a dense bag. Note that if a
	 * Dense bag contains 3 a's, then the iterator must iterate over 3 a's
	 * individually.
	 * </P>
	 */
	@Override
	public Iterator<T> iterator() {


		return new DenseIterator(denseMap, this);

	}

	private class DenseIterator implements Iterator<T> {

		private int index;
		private LinkedList<T> myLink;
		private int modCount;
		private DenseBag<T> DM;
		private Map<T, Integer> map;

		public DenseIterator(Map<T, Integer> map, DenseBag<T> DM){

			index = 0;
			this.DM = DM;
			this.map = map;

			myLink = new LinkedList<T>();
			modCount = DM.getModCount();

			for (T o : map.keySet()) {
				for (int i = 0; i<map.get(o); i++)
					myLink.add(o);
			}

		}

		@Override
		public boolean hasNext() {
			if (index == myLink.size()) {
				return false;
			}
			return true;
		}

		@Override
		public T next() {
			return myLink.get(index++);
		}

		private void updateList(){
			myLink.clear();
			for (T o : map.keySet()) {
				for (int i = 0; i<map.get(o); i++)
					myLink.add(o);
			}
		}

		@Override
		public void remove() {
			if (myLink.get(index) == null)
				throw new IllegalStateException();
			if (modCount != DM.getModCount())
				throw new ConcurrentModificationException();				
			DM.remove(myLink.get(index));
			updateList();
		}
	}


	/**
	 * return a Set of the elements in the Bag (since the returned value is a
	 * set, it will contain one value for each UNIQUE value in the Bag).
	 * 
	 * @return A set of elements in the Bag
	 */
	public Set<T> uniqueElements() {

		return denseMap.keySet();

	}


	/**
	 * Return the number of instances of a particular object in the bag. Return
	 * 0 if it doesn't exist at all.
	 * 
	 * @param o
	 *            object of interest
	 * @return number of times that object occurs in the Bag
	 */
	public int getCount(Object o) {

		if (denseMap.containsKey(o) == false) {
			return 0;
		} else {
			return denseMap.get(o);
		}

	}


	/**
	 * Given a random number generator, randomly choose an element from the Bag
	 * according to the distribution of objects in the Bag (e.g., if a Bag
	 * contains 7 a's and 3 b's, then 70% of the time choose should return an a,
	 * and 30% of the time it should return a b.
	 * 
	 * This operation can take time proportional to the number of unique objects
	 * in the Bag, but no more.
	 * 
	 * This operation should not affect the Bag.
	 * 
	 * @param r
	 *            Random number generator
	 * @return randomly chosen element
	 */
	public T choose(Random r) {

		
		for (T o : map.keySet()) {
			for (int i = 0; i < map.get(o); i++)
				myLink.add(o);
		}

		ArrayList<T> listOfKeys = new ArrayList<T>();

		int index = 0;
		Iterator<T> it = denseMap.keySet().iterator();

		while (it.hasNext()){
			T current = it.next();
			while (index < denseMap.get(current)){
				listOfKeys.add(current);
				index++;
			}
			index = 0;
		}

		return listOfKeys.get(r.nextInt(listOfKeys.size())); 

	}


	/**
	 * Returns true if the Bag contains one or more instances of o
	 */
	@Override
	public boolean contains(Object o) {

		boolean objectValue = false;

		for (T current : denseMap.keySet()){
			if (o.equals(current)){
				objectValue = true;
			}
		}

		return objectValue;

	}


	/**
	 * Decrements the number of instances of o in the Bag.
	 * 
	 * @return return true if and only if at least one instance of o exists in
	 *         the Bag and was removed.
	 */
	@Override
	public boolean remove(Object o) {

		if (o != null) {
			if (denseMap.containsKey(o)) { 
				denseMap.put((T)o, denseMap.get(o) - 1);
				size--;
				modCount++;
				return true;
			}
		}
		return false;
	}


	/**
	 * Total number of instances of any object in the Bag (counting duplicates)
	 */
	@Override
	public int size() {

		return this.size;

	}

}