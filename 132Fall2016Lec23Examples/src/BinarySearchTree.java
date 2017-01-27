

public class BinarySearchTree<K extends Comparable<K>, V> {
	
	private class Node {
		private K key;
		private V value;
		private Node left, right;

		private Node(K key, V data) {
			this.key = key;
			this.value = data;
		}
	}

	private Node root;

	public boolean put(K key, V data) {
		if (root == null) {
			root = new Node(key, data);
			return true;
		} else {
			return putHelper(key, data, root);
		}
	}

	private boolean putHelper(K key, V data, Node localRoot) {
		int comparison = key.compareTo(localRoot.key);
		if (comparison == 0) {
			localRoot.value = data;
			return false;
		} else if (comparison < 0) {
			if (localRoot.left == null) {
				localRoot.left = new Node(key, data);
				return true;
			} else {
				return putHelper(key, data, localRoot.left);
			}
		} else {
			if (localRoot.right == null) {
				localRoot.right = new Node(key, data);
				return true;
			} else {
				return putHelper(key, data, localRoot.right);
			}
		}
	}

	public String toString() {
		return toStringHelper(root);
	}

	private String toStringHelper(Node localRoot) {
		String answer = "";
		if (localRoot == null) {
			return answer;
		}
		answer = toStringHelper(localRoot.left);
		answer += "(" + localRoot.key + ":" + localRoot.value + ")";
		answer += toStringHelper(localRoot.right);
		return answer;
	}

	/*
	 * Tree shape for tree created by createBalancedTree. 40 20 60 10 30 50 70
	 */
	public static void main(String[] args) {
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
		tree.put(40, "Forty");
		tree.put(20, "Twenty");
		tree.put(60, "Sixty");
		tree.put(10, "Ten");
		tree.put(30, "Thirty");
		tree.put(50, "Fifty");
		tree.put(70, "Seventy");
		System.out.println(tree);
	}
}