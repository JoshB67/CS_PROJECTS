import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * When you do a web search, the results page shows you a 
 * <a href="http://searchengineland.com/anatomy-of-a-google-snippet-38357">snippet</a> 
 * for each result, showing you search terms in context. For purposes of this project, a
 * snippet is a subsequence of a document that contains all the search terms.
 * 
 * For this project, you will write code that, given a document (a sequence of
 * words) and set of search terms, find the minimal length subsequence in the
 * document that contains all of the search terms.
 * 
 * If there are multiple subsequences that have the same minimal length, you may
 * return any one of them.
 * 
 */
public class MinimumSnippet {


	private int minStart = 0;
	private int minEnd = 0;
	private int[] firstIndicies = null;

	
	/**
	 * Compute minimum snippet.
	 * 
	 * Given a document (represented as an List<String>), and a set of terms
	 * (represented as a List<String>), find the shortest subsequence of the
	 * document that contains all of the terms.
	 * 
	 * This constructor should find the minimum snippet, and store information
	 * about the snippet in fields so that the methods can be called to query
	 * information about the snippet. All significant computation should be done
	 * during construction.
	 * 
	 * @param document
	 *            The Document is an Iterable<String>. Do not change the
	 *            document. It is an Iterable, rather than a List, to allow for
	 *            implementations where we scan very large documents that are
	 *            not read entirely into memory. If you have problems figuring
	 *            out how to solve it with the document represented as an
	 *            Iterable, you may cast it to a List<String>; in all but a very
	 *            small number of test cases, in will in fact be a List<String>.
	 * 
	 * @param terms
	 *            The terms you need to look for. The terms will be unique
	 *            (e.g., no term will be repeated), although you do not need to
	 *            check for that. There should always be at least one term and 
	 *            your code should
	 *            throw an IllegalArgumentException if "terms" is
	 *            empty.
	 * 
	 * 
	 */
	public MinimumSnippet(Iterable<String> document, List<String> terms) {

		firstIndicies = new int[terms.size()];

		if (terms.size() == 0) {
			throw new IllegalArgumentException("Term Not Found");
		}

		Iterator<String> forward = document.iterator();

		Iterator<String> back = document.iterator();

		/**
		* 
		* we want to track both the index and the document as we traverse the
		* elements. We need a backIndex and a frontIndex for keeping track of
		* the positions of the array. 
		* 
		*/
		String currentBack = back.next();
		String currentFront = null;
		int backIndex = 0;
		int frontIndex = -1;


		ArrayList<String> copyTerms = new ArrayList<String>(terms);

		/**
		 * Checks if the copied terms are empty and that forward has
		 * elements to loop over. Then it updates accordingly.
		 * 
		 */
		while (!(copyTerms.isEmpty()) && forward.hasNext()) {
			currentFront = forward.next();
			frontIndex++;

			if (copyTerms.remove(currentFront)) {
				firstIndicies[terms.indexOf(currentFront)] = frontIndex;
			}
		}
		if (copyTerms.isEmpty()) {

			/**
			 * Moving the back pointer up to the first interesting document
			 * in the list.
			 */
			while (!(terms.contains(currentBack))) {
				currentBack = back.next();
				backIndex++;
			}

			minStart = backIndex;
			minEnd = frontIndex;

			/**
			 * Checks that both forward and back have looping elements 
			 * then this method proceeds to carry out two while loops.
			 * Together the two pointers find a sublist in the array
			 * that has the searched elements in it.
			 */
			while (forward.hasNext() && back.hasNext()) {

				while (forward.hasNext() && !(currentFront.equals(currentBack))) {	
					currentFront = forward.next();
					frontIndex++;
				}

				if (currentFront.equals(currentBack) && back.hasNext()) {
					do {
						currentBack = back.next();
						backIndex++;
					} while (!(terms.contains(currentBack)) && (back.hasNext()));


					if ((frontIndex - backIndex) < (minEnd - minStart) && frontIndex >= backIndex) {
						firstIndicies[terms.indexOf(currentFront)] = frontIndex;
						minStart = backIndex;
						minEnd = frontIndex;
					}

				}


			}
		} else {
			firstIndicies = null;
		}


	}


	/**
	 * Returns whether or not all terms were found in the document. If all terms
	 * were not found, then none of the other methods should be called.
	 * 
	 * @return whether all terms were found in the document.
	 */
	public boolean foundAllTerms() {
		return firstIndicies != null;
	}

	/**
	 * Return the starting position of the snippet
	 * 
	 * @return the index in the document of the first element of the snippet
	 */
	public int getStartingPos() {
		return this.minStart;
	}

	/**
	 * Return the ending position of the snippet
	 * 
	 * @return the index in the document of the last element of the snippet
	 */
	public int getEndingPos() {
		return this.minEnd;
	}

	/**
	 * Return total number of elements contained in the snippet.
	 * 
	 * @return
	 */
	public int getLength() {
		return minEnd - minStart + 1;
	}

	/**
	 * Returns the position of one of the search terms as it appears in the original document
	 * 
	 * @param index index of the term in the original list of terms.  For example, if index
	 * is 0 then the method will return the position (in the document) of the first search term.
	 * If the index is 1, then the method will return the position (in the document) of the
	 * second search term.  Etc.
	 *  
	 * @return position of the term in the document
	 */
	public int getPos(int index) {
		return firstIndicies[index];
	}

}
