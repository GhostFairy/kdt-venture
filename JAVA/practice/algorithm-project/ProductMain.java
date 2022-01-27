

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("(1) 상품 등록 (2) 상품 삭제 (3) 상품 검색 (4) 전체 상품 조회 (5) 종료");
			System.out.print("메뉴 선택: ");
			int command = sc.nextInt();
			System.out.println();
			if (command == 1) {
				System.out.println("상품 등록");
				System.out.print("상품 번호 입력: ");
				int key = sc.nextInt();
				System.out.print("상품명 입력: ");
				String value = sc.next();
				bst.add(key, value);
			} else if (command == 2) {
				System.out.println("상품 삭제");
				System.out.print("상품 번호 입력: ");
				int key = sc.nextInt();
				bst.remove(key);
				System.out.println("상품 삭제 완료");
			} else if (command == 3) {
				System.out.println("상품 검색");
				System.out.print("상품 번호 입력: ");
				int key = sc.nextInt();
				System.out.println("상품명: " + bst.search(key));
			} else if (command == 4) {
				bst.print();
			} else if (command == 5) {
				System.out.println("종료합니다.");
				break;
			}
			System.out.println();
		}
		sc.close();
	}

}
