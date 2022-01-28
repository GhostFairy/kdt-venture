
public class BinarySearchTree {

	private Node root;

	private class Node {

		private int key;
		private String value;
		private Node left;
		private Node right;

		private Node(int key, String value) {
			this.key = key;
			this.value = value;
		}

	}

	public boolean add(int key, String value) {
		Node current = root;
		// 아직 아무 데이터도 없을 경우
		if (current == null) {
			root = new Node(key, value);
			return true;
		}
		// 데이터를 입력할 위치 검색
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
		Node target = root;
		Node parent = null;
		boolean isLeft = false;

		// 삭제할 대상 검색
		while (target != null) {
			if (key == target.key) {
				break;
			} else {
				parent = target;
				if (key < target.key) {
					target = target.left;
					isLeft = true;
				} else {
					target = target.right;
					isLeft = false;
				}
			}
		}
		// 검색에 실패했을 경우
		if (target == null) {
			return false;
		}
		// 삭제
		if (target.left == null) { // 대상이 오른쪽 자식 노드만 가지는 경우(또는 자식 노드가 없는 경우)
			if (target == root) {
				root = target.right;
			} else if (isLeft) {
				parent.left = target.right;
			} else {
				parent.right = target.right;
			}
		} else if (target.right == null) { // 대상이 왼쪽 자식 노드만 가지는 경우
			if (target == root) {
				root = target.left;
			} else if (isLeft) {
				parent.left = target.left;
			} else {
				parent.right = target.left;
			}
		} else { // 대상이 양쪽 자식 노드를 모두 가지는 경우
			Node current = target.left;
			parent = target;
			isLeft = true;
			// 대상보다 작은 노드 중 가장 큰 노드를 검색(왼쪽 서브트리의 가장 오른쪽 노드)
			while (current.right != null) {
				parent = current;
				current = current.right;
				isLeft = false;
			}
			// 데이터를 덮어 씌워 대상을 삭제
			target.key = current.key;
			target.value = current.value;
			// 복사를 마친 노드에 왼쪽 자식 노드가 있으면 부모에 이어준 후 삭제
			// (서브트리의 가장 오른쪽 노드이므로 오른쪽 자식 노드는 없음)
			if (isLeft) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		}
		return true;
	}

	public String search(int key) {
		Node current = root;
		while (current != null) {
			if (key == current.key) {
				return current.value;
			} else if (key < current.key) {
				current = current.left;
			} else {
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
		// 재귀호출 시작
		print(current);
	}

	private void print(Node current) {
		// 재귀호출을 위한 함수
		if (current != null) {
			print(current.left);
			System.out.println(current.key + " " + current.value);
			print(current.right);
		}
	}

}
