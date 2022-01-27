
public class BinarySearchTree {

	private Node root;

	private class Node {

		int key;
		String value;
		Node left;
		Node right;

		private Node(int key, String value) {
			this.key = key;
			this.value = value;
		}

	}

	public boolean add(int key, String value) {
		Node current = root;
		if (current == null) {
			root = new Node(key, value);
			return true;
		}
		while (current != null) {
			if (key == current.key) {
				return false;
			} else if (key < current.key) {
				if (current.left == null) {
					current.left = new Node(key, value);
					return true;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					current.right = new Node(key, value);
					return true;
				}
				current = current.right;
			}
		}
		return false;
	}

	public boolean remove(int key) {
		return false;
	}

	public String search(int key) {
		Node current = root;
		while (current != null) {
			if (key == current.key) {
				return current.value;
			} else if (key < current.key) {
				if (current.left == null) {
					break;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					break;
				}
				current = current.right;
			}
		}
		return null;
	}

	public void print() {
		Node current = root;
		if (current == null) {
			System.out.println("등록된 상품이 없습니다.");
			return;
		}
		print(current);
	}

	private void print(Node current) {
		if (current != null) {
			print(current.left);
			System.out.println(current.key + " " + current.value);
			print(current.right);
		}
	}

}
